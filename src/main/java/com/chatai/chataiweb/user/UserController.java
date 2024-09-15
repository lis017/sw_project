package com.chatai.chataiweb.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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

    // 회원가입
    @PostMapping("/saveuser")
    public String saveUser(String id, String pw, String user_name, LocalDate birth, String number) throws Exception {
        userService.saveUser(id, pw, user_name, birth, number);
        return "redirect:/login";
    }
}
