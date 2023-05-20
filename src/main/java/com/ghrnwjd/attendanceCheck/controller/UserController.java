package com.ghrnwjd.attendanceCheck.controller;

import com.ghrnwjd.attendanceCheck.model.GitRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/join")
    public String join() {
        return "join.html";
    }

//    @GetMapping("https://api.github.com/users/ghrnwjd/repos")
//    public String getRepos(@RequestBody GitRepo gitRepo) {
//
//        return gitRepo.toString();
////        gitRepoService.saveRepos(gitRepo);
//    }

}
