package com.ghrnwjd.attendanceCheck.config;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class GithubInfoConfig {
    @Value("${github.id}")
    private String githubId;

    @Value("${github.password}")
    private String githubPassword;

    @Value("${github.token}")
    private String githubToken;

    public String getGithubToken() {
        return githubToken;
    }

    public String getGithubId() {
        return githubId;
    }

    public String getGithubPassword() {
        return githubPassword;
    }
}
