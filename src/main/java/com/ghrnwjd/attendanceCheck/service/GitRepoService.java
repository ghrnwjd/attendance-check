//package com.ghrnwjd.attendanceCheck.service;
//
//
//import com.ghrnwjd.attendanceCheck.model.GitRepo;
//import com.ghrnwjd.attendanceCheck.model.User;
//import com.ghrnwjd.attendanceCheck.repository.GitRepoRepository;
//import com.ghrnwjd.attendanceCheck.repository.UserRepository;
//import jakarta.transaction.Transactional;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Service
//@Slf4j
//public class GitRepoService {
//
//
//    @Autowired
//    private GitRepoRepository gitRepoRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//
//    @Transactional
//    public void saveRepos(String repoName, String gitId) {
//
//        GitRepo gitRepo = new GitRepo();
//        gitRepo.setRepoName(repoName);
//        gitRepo.setUser(userRepository.findByGitId(gitId).orElseGet(()-> {
//            User user = new User();
//            user.setGitId(gitId);
//            userRepository.save(user);
//            return user;
//        }));
//
//        gitRepoRepository.save(gitRepo);
//
//    }
//
//
//
//    public void getRepos(String gitId) {
//        WebClient client = WebClient.create();
//        String url = "https://api.github.com/users/" + gitId + "/repos";
//        Mono<String> stringMono = client.get()
//                .uri(url)
//                .retrieve()
//                .bodyToMono(String.class);
//
//        String [] jsonList = stringMono.flux().toStream().findAny().toString().split(",");
//        ArrayList<String> repoList = new ArrayList<>();
//        for(int i = 0; i < jsonList.length; i++) {
//            if(jsonList[i].startsWith("\"name\"")) {
//                repoList.add(jsonList[i].substring(8, jsonList[i].length()-1));
//            }
//        }
//
//        for(int i = 0; i < repoList.size(); i++) {
//            saveRepos(repoList.get(i), gitId);
//        }
//    }
//
//
//    @Transactional
//    public ArrayList<String> getCommits(String gitId) throws InterruptedException {
//
//
//        List<GitRepo> repoList = gitRepoRepository.findAllByUser(userRepository.findByGitId(gitId).orElseGet(()-> {
//            System.out.println("해당 사용자를 찾을 수 없습니다.");
//            return null;
//        }));
//
//        ArrayList<String> commitList = new ArrayList<>();
//
//        if(repoList != null) {
//            for(int i = 0; i < repoList.size(); i++) {
//                try {
//                    WebClient client = WebClient.create();
//                    String url = "https://api.github.com/repos/" + gitId + "/" + repoList.get(i).getRepoName() + "/commits";
//
//                    Mono<String> stringMono = client.get()
//                            .uri(url)
//                            .retrieve()
//                            .bodyToMono(String.class);
//
//                    String[] jsonList = stringMono.flux().toStream().findAny().toString().split(",");
//
//                    for (int j = 0; j < jsonList.length; j++) {
//                        if (jsonList[i].startsWith("\"date\"")) {
////                            System.out.println(jsonList[j]);
//                            commitList.add(jsonList[i].substring(8, jsonList[i].length() - 3));
//                            break;
//                        }
//                    }
//                }
//                catch (Exception e) {
//                    e.printStackTrace();
//                }
//                Thread.sleep(10 * 1000);
//                // 10초 간격으로 api를 요청하겠음.
//                // git api request 는 10 requests per minutes 임
//            }
//
//            return commitList;
//        }
//
//        return null;
//
//    }
//
//
//    public String attendanceCheck(String gitId) throws InterruptedException {
//        ArrayList<String> commitList = getCommits(gitId);
//
//        if(commitList != null) {
//            for(int i = 0; i < commitList.size(); i++) {
//                String date_time = commitList.get(i);
//                if(addTime(date_time)) {
//                    return "오늘 출석하였습니다.";
//                }
//            }
//        }
//
//        return "출석하지 못하였습니다.";
//    }
//
//    public boolean addTime(String date_time) {
//        LocalDateTime localDateTime = LocalDateTime.parse(date_time);
//        localDateTime.plusHours(9);
//
//
//        if(LocalDate.now().isEqual(localDateTime.toLocalDate())) {
//            return true;
//        }
//
//        return false;
//
//    }
//
//
//}
