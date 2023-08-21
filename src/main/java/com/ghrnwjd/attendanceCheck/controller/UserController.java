<<<<<<< HEAD
//package com.ghrnwjd.attendanceCheck.controller;
//
//import com.ghrnwjd.attendanceCheck.model.User;
//import com.ghrnwjd.attendanceCheck.service.GitRepoService;
//import com.ghrnwjd.attendanceCheck.service.UserService;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//public class UserController {
//
//    private final GitRepoService gitRepoService;
//    private final UserService userService;
//
//    public UserController(GitRepoService gitRepoService, UserService userService) {
//        this.gitRepoService = gitRepoService;
//        this.userService = userService;
//    }
//
//    @GetMapping("/")
//    public String index(Model model) throws InterruptedException {
//
//        List<User> users = userService.findAll();
//
//        for(int i = 0; i < users.size(); i++) {
//            User user = users.get(i);
//            model.addAttribute("attendanceCheck"+user.getGitId(), user.getState());
//        }
//
//        return "index.html";
//    }
//
//
//    @GetMapping("/renew")
//    public String renew() {
//
//        List<User> users = userService.findAll();
//
//        for(int i = 0; i < users.size(); i++) {
//            gitRepoService.getRepos(users.get(i).getGitId());
//        }
//
//        return "index.html";
//    }
//}
=======
package com.ghrnwjd.attendanceCheck.controller;

import com.ghrnwjd.attendanceCheck.model.User;
import com.ghrnwjd.attendanceCheck.service.GitRepoService;
import com.ghrnwjd.attendanceCheck.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final GitRepoService gitRepoService;
    private final UserService userService;

    public UserController(GitRepoService gitRepoService, UserService userService) {
        this.gitRepoService = gitRepoService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) throws InterruptedException {

        List<User> users = userService.findAll();

        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            model.addAttribute("attendanceCheck"+user.getGitId(), user.getState());
        }

        return "index.html";
    }


    @GetMapping("/renew")
    public String renew() {

        List<User> users = userService.findAll();

        for(int i = 0; i < users.size(); i++) {
            gitRepoService.getRepos(users.get(i).getGitId());
        }

        return "index.html";
    }



//    @GetMapping("/login")
//    public String login() {
//        return "login.html";
//    }
//
//    @GetMapping("/join")
//    public String join() {
//        return "join.html";
//    }

//    @GetMapping("https://api.github.com/users/ghrnwjd/repos")
//    public String getRepos(@RequestBody GitRepo gitRepo) {
//
//        return gitRepo.toString();
////        gitRepoService.saveRepos(gitRepo);
//    }

}
>>>>>>> facc1e5b9e27b9e9335aaab8cfc5e84b5ac0e568
