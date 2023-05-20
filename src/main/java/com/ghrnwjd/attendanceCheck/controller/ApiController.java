package com.ghrnwjd.attendanceCheck.controller;

import com.ghrnwjd.attendanceCheck.model.GitRepo;
import com.ghrnwjd.attendanceCheck.service.GitRepoService;
import com.ghrnwjd.attendanceCheck.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {

    private final UserService userService;
    private final GitRepoService gitRepoService;

    public ApiController(UserService userService, GitRepoService gitRepoService) {
        this.userService = userService;
        this.gitRepoService = gitRepoService;
    }

//    @GetMapping("/")
//    public void getRepos(@RequestBody GitRepo gitRepo) {
//
//
////        gitRepoService.saveRepos(gitRepo);
//    }
}
