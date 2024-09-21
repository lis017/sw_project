package com.chatai.chataiweb.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final APIService apiService;

    // 메인 페이지 (ChatAI 선택 화면)
    @GetMapping("/")
    public String main() {
        return "main.html";
    }

    // 챗봇 서비스
    @PostMapping("/question")
    public String chat(String username, String question) {
        apiService.callPythonApi(username, question); // 챗봇 api 호출

        return "redirect:/";
    }
}
