<<<<<<< HEAD
//package com.ghrnwjd.attendanceCheck.service;
//
//import com.ghrnwjd.attendanceCheck.model.User;
//import com.ghrnwjd.attendanceCheck.repository.UserRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserService(UserRepository userRepository, GitRepoService gitRepoService) {
//        this.userRepository = userRepository;
//        this.gitRepoService = gitRepoService;
//    }
//
//
//    @Autowired
//    private GitRepoService gitRepoService;
//
//
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//
//    @Transactional
//    @Scheduled(cron = "0 0 0 * * *") // 매일 저녁
//    public void resetState() {
//        List<User> users = userRepository.findAll();
//        for(int i = 0; i < users.size(); i++) {
//            users.get(i).setState("출석하지 못하였습니다.");
//        }
//    }
//
//    @Transactional
//    @Scheduled(cron = "0 0 10,19 * * *") // 매일 아침 10시, 저녁 19시에 업데이트
//    public void updateState() throws InterruptedException {
//        List<User> users = userRepository.findAll();
//        for(int i = 0; i < users.size(); i++) {
//            User user = users.get(i);
//            String attendance = gitRepoService.attendanceCheck(user.getGitId());
//            if(!user.getState().equals(attendance)) {
//                user.setCumulativeAttendance(user.getCumulativeAttendance() + 1);
//            }
//            users.get(i).setState(gitRepoService.attendanceCheck(user.getGitId()));
//        }
//    }
//
//}
=======
package com.ghrnwjd.attendanceCheck.service;

import com.ghrnwjd.attendanceCheck.model.User;
import com.ghrnwjd.attendanceCheck.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository, GitRepoService gitRepoService) {
        this.userRepository = userRepository;
        this.gitRepoService = gitRepoService;
    }


    @Autowired
    private GitRepoService gitRepoService;


    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Transactional
    @Scheduled(cron = "0 0 0 * * *") // 매일 저녁
    public void resetState() {
        List<User> users = userRepository.findAll();
        for(int i = 0; i < users.size(); i++) {
            users.get(i).setState("출석하지 못하였습니다.");
        }
    }

    @Transactional
    @Scheduled(cron = "0 0 10,19 * * *") // 매일 아침 10시, 저녁 19시에 업데이트
    public void updateState() throws InterruptedException {
        List<User> users = userRepository.findAll();
        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            String attendance = gitRepoService.attendanceCheck(user.getGitId());
            if(!user.getState().equals(attendance)) {
                user.setCumulativeAttendance(user.getCumulativeAttendance() + 1);
            }
            users.get(i).setState(gitRepoService.attendanceCheck(user.getGitId()));
        }
    }

}
>>>>>>> facc1e5b9e27b9e9335aaab8cfc5e84b5ac0e568
