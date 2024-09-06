package com.chatai.chataiweb.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    // 회원가입 페이지
    @GetMapping("/register")
    public String register() {
        return "register.html";
    }
}
