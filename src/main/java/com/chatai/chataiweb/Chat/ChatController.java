package com.chatai.chataiweb.Chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    // 메인 페이지 (ChatAI 선택 화면)
    @GetMapping("/")
    public String main() {
        return "main.html";
    }

    // ChatAI 대화 화면
    @GetMapping("/chat")
    public String chat() {
        return "chat.html";
    }
}
