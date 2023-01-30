package ru.misis.courseproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.misis.courseproject.entities.Client;
import ru.misis.courseproject.repos.ClientsRepos;

@Controller
public class SignInController {
    @Autowired
    ClientsRepos clientsRepos;

    @GetMapping("/signIn")
    public String getSignInPage() {
        return "signIn_page";
    }

    @PostMapping("/signIn")
    public String getDownloadPage(String email, String password) {
        Client client = clientsRepos.findByEmail(email);
        if (client != null && client.getPassword().equals(password)) {
            return "redirect:/download";
        } else {
            System.out.println("User with this data is not exists");
            return "redirect:/signIn";
        }
    }

    @PostMapping("signInGo")
    public String getSignUpPage() {
        return "redirect:/signUp";
    }


}

