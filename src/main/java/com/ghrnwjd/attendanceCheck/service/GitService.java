package com.ghrnwjd.attendanceCheck.service;


import com.ghrnwjd.attendanceCheck.config.GithubInfoConfig;
import org.kohsuke.github.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GitService {

    GitHub gitHub;

    private final GithubInfoConfig githubInfoConfig;

    public GitService(GithubInfoConfig githubInfoConfig) throws IOException {
        this.githubInfoConfig = githubInfoConfig;
    }

    public void connectToGitHub() throws IOException {
        this.gitHub = new GitHubBuilder().withOAuthToken(githubInfoConfig.getGithubToken()).build();
        this.gitHub.checkApiUrlValidity();
    }

    public PagedIterator<GHCommit> getCommitLogs() {
        try {
            connectToGitHub();
        }
        catch (IOException e) {
            throw new IllegalArgumentException("failed to connect gitHub");
        }

        GHCommitSearchBuilder builder = gitHub.searchCommits()
                .author(githubInfoConfig.getGithubId())
                .sort(GHCommitSearchBuilder.Sort.AUTHOR_DATE);

        PagedSearchIterable<GHCommit> commits = builder.list().withPageSize(5);
        return commits._iterator(1);
    }


}
