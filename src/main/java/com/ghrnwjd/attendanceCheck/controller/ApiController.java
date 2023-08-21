package com.ghrnwjd.attendanceCheck.controller;

import com.ghrnwjd.attendanceCheck.service.GitService;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.PagedIterator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {

    private final GitService gitService;

    public ApiController(GitService gitService) {
        this.gitService = gitService;
    }

    @GetMapping("/getCommitLogs")
    public PagedIterator<GHCommit> getCommitLogs() {
        return gitService.getCommitLogs();
    }
}
