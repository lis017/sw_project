package com.chatai.chataiweb.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 로그인 페이지
    @PreAuthorize("isAnonymous()")
    @GetMapping("/login")
    public String login(Authentication auth) {
        return "login.html";
    }

    // 회원가입 페이지
    @PreAuthorize("isAnonymous()")
    @GetMapping("/register")
    public String register() {
        return "register.html";
    }

    // 회원가입
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/register")
    public String saveMember(String username, String password, String display_name, LocalDate birth, String number) throws Exception {
        memberService.saveMember(username, password, display_name, birth, number);
        return "redirect:/login";
    }
}
