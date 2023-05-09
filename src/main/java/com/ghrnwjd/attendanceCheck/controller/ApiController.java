package com.ghrnwjd.attendanceCheck.controller;

import com.ghrnwjd.attendanceCheck.model.User;
import com.ghrnwjd.attendanceCheck.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ApiController {

    private final UserService userService;

    public ApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/loginProc")
    public void login(@RequestBody User user, HttpServletResponse response) throws IOException {
        User user1 = userService.login(user);
        if(user1 == null) {
            response.sendRedirect("http://localhost:7777/user/login");
        }
        else{
            response.sendRedirect("http://localhost:7777/");
        }
    }

    @PostMapping("/joinProc")
    public void join(@RequestBody User user, HttpServletResponse response) throws IOException{
        userService.join(user);
        response.sendRedirect("http://localhost:7777/");
    }
}
