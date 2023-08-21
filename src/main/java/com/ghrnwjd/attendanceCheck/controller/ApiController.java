package com.ghrnwjd.attendanceCheck.controller;

<<<<<<< HEAD
import com.ghrnwjd.attendanceCheck.service.GitService;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.PagedIterator;
import org.springframework.web.bind.annotation.GetMapping;
=======
import com.ghrnwjd.attendanceCheck.model.GitRepo;
import com.ghrnwjd.attendanceCheck.service.GitRepoService;
import com.ghrnwjd.attendanceCheck.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> facc1e5b9e27b9e9335aaab8cfc5e84b5ac0e568
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {

<<<<<<< HEAD
    private final GitService gitService;

    public ApiController(GitService gitService) {
        this.gitService = gitService;
    }

    @GetMapping("/getCommitLogs")
    public PagedIterator<GHCommit> getCommitLogs() {
        return gitService.getCommitLogs();
    }
=======
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
>>>>>>> facc1e5b9e27b9e9335aaab8cfc5e84b5ac0e568
}
