package com.chatai.chataiweb.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final APIService apiService;

    // 메인 페이지 (ChatAI 선택 화면)
    @GetMapping("/")
    public String main() {
//        apiService.callPythonApi(); // api 테스트
        return "main.html";
    }
}
