package com.ghrnwjd.attendanceCheck.service;


import com.ghrnwjd.attendanceCheck.model.GitRepo;
import com.ghrnwjd.attendanceCheck.repository.GitRepoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


@Service
@Slf4j
public class GitRepoService {


    @Autowired
    private GitRepoRepository gitRepoRepository;



    @Transactional
    public void saveRepos(GitRepo gitRepo) {
        gitRepoRepository.save(gitRepo);
    }



    public ArrayList<String> getRepos(String gitId) {
        WebClient client = WebClient.create();
        String url = "https://api.github.com/users/" + gitId+ "/repos";
        Mono<String> stringMono = client.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
        stringMono.flux().toStream().findAny()
        String [] jsonList = stringMono.flux().toStream().findAny().toString().split(",");
        ArrayList<String> repoList = new ArrayList<>();
        for(int i = 0; i < jsonList.length; i++) {
            if(jsonList[i].startsWith("\"name\"")) {
                repoList.add(jsonList[i].substring(8, jsonList[i].length()-1));
            }
        }

        return repoList;
    }


    public ArrayList<String> getCommits() {
        String gitId = "mmmjunjoy";
        ArrayList <String> repoList = getRepos(gitId);

        for(String temp : repoList) {
            System.out.println(temp);
        }
        ArrayList<String> commitList = new ArrayList<>();

        for(int i = 0; i < repoList.size(); i++) {

            try {
                WebClient client = WebClient.create();
                String url = "https://api.github.com/repos/" + gitId + "/" + repoList.get(i) + "/commits";

                Mono<String> stringMono = client.get()
                        .uri(url)
                        .retrieve()
                        .bodyToMono(String.class);

                String[] jsonList = stringMono.flux().toStream().findAny().toString().split(",");

                for (int j = 0; j < jsonList.length; j++) {
                    if (jsonList[i].startsWith("\"date\"")) {
                        System.out.println(jsonList[j]);
                        commitList.add(jsonList[i].substring(8, jsonList[i].length() - 3));
                        break;
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }


        return commitList;
    }


    public String attendanceCheck() {
        ArrayList<String> commitList = getCommits();
        for(int i = 0; i < commitList.size(); i++) {
            String date_time = commitList.get(i);
            if(addTime(date_time)) {
                return "오늘 출석하였습니다.";
            }
        }
        return "출석하지 못하였습니다.";
    }

    public boolean addTime(String date_time) {
        LocalDateTime localDateTime = LocalDateTime.parse(date_time);
        localDateTime.plusHours(9);


        if(LocalDate.now().isEqual(localDateTime.toLocalDate())) {
            return true;
        }

        return false;

    }


}
