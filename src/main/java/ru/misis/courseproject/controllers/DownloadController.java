package ru.misis.courseproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.misis.courseproject.entities.Transaction;
import ru.misis.courseproject.repos.ClientsRepos;
import ru.misis.courseproject.repos.MCCRepos;
import ru.misis.courseproject.repos.TransactionTypeRepos;
import ru.misis.courseproject.repos.TransactionsRepos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@Controller
public class DownloadController {
    public Boolean flag = false;
    @Autowired
    TransactionsRepos transactionsRepos;
    @Autowired
    MCCRepos mccRepos;
    @Autowired
    ClientsRepos clientsRepos;
    @Autowired
    TransactionTypeRepos transactionTypeRepos;

    @GetMapping("/download")
    public String getDownloadPage() {
        return "/download_page";
    }

    @PostMapping("getInfoPage")
    public String getInfoPage() {
        if (flag) return "redirect:/info";
        else {
            System.out.println("Error! File is not chosen");
            return "/download_page";
        }
    }

    @PostMapping("fileIn")
    public String getFile(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        File csvFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
        file.transferTo(csvFile);
        FileReader fr = new FileReader(csvFile);
        Scanner scanner = new Scanner(fr);
        String line;
        String[] arr;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            arr = line.split(",");
            if (arr.length == 4) {
                Transaction transaction = new Transaction();
                transaction.setSum(Long.parseLong(arr[0]));
                transaction.setMCC(mccRepos.findMCCodesByMCC(Long.parseLong(arr[1])));
                transaction.setClient(clientsRepos.findClientByClientId(Long.parseLong(arr[2])));
                transaction.setTypeId(transactionTypeRepos.findTransactionTypeByTypeId(Long.parseLong(arr[3])));
                transactionsRepos.save(transaction);
                flag = true;
            } else {
                System.out.println("Error! Chosen file's data have incorrect format");
                break;
            }
        }
        fr.close();
        return "download_page";
    }
}

