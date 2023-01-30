package ru.misis.courseproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.misis.courseproject.entities.Client;
import ru.misis.courseproject.repos.ClientsRepos;

@Controller
public class SignUpController {
    @Autowired
    private ClientsRepos clientsRepos;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp_page";
    }

    @PostMapping("/signUp")
    public String signUpClient(Client client) {
        clientsRepos.save(client);
        return "redirect:/signIn";
    }

    @PostMapping("goSignIn")
    public String goSignIn() {
        return "redirect:/signIn";
    }
//    @PostMapping("signInGo")
//    public String goSignUpPage(){
//        return "redirect:/signIn";
//    }
}

