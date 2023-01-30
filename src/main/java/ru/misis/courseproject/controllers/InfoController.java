package ru.misis.courseproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.misis.courseproject.CSVCreator;
import ru.misis.courseproject.models.StatisticsModel;
import ru.misis.courseproject.models.TransactionModel;
import ru.misis.courseproject.repos.TransactionsRepos;
import ru.misis.courseproject.services.DBService;
import ru.misis.courseproject.services.TransactionService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InfoController {
    @Autowired
    TransactionsRepos transactionsRepos;
    @Autowired
    TransactionService transactionService;
    @Autowired
    DBService DBService;

    CSVCreator csvCreator = new CSVCreator();
    List<StatisticsModel> list2 = new ArrayList<>();

    @RequestMapping("/info")
    public String getInfoPage(Model model) throws SQLException, IOException {
        List<TransactionModel> list = transactionService.findAll();
        model.addAttribute("transactions", list);
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/account", "postgres", "12203044");
        list2 = DBService.getTrans(connection);
        model.addAttribute("statistics", list2);
        return "info_page";
    }

    @GetMapping("/downloadCsv")
    public String getFile() throws IOException {
        try {
            String name = "fileDueTo" + LocalDateTime.now().toString() + ".csv";
            csvCreator.setPathToCsv("C:\\Users\\acya2\\Downloads\\" + name.replace(':', '-'));
            csvCreator.createCSV(list2);
        } catch (IOException ex) {
            System.out.println("mistake");
        }
        return "redirect:/info";
    }

    @PostMapping("/info")
    public String getDownloadPage() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/account", "postgres", "12203044");
        DBService.deleteAllTrans(connection);
        DownloadController downloadController = new DownloadController();
        downloadController.flag = false;
        return "redirect:/download";
    }

}

