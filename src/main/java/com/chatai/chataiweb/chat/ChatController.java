package com.chatai.chataiweb.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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
    @ResponseBody
    public Map<String, Object> chat(@RequestBody Map<String, Object> data) {
        String username = (String) data.get("username");
        String question = (String) data.get("question");
        Map<String, Object> answer = apiService.callPythonApi(username, question); // 챗봇 api 호출

        // 챗봇 api 대답 출력
        System.out.println("응답 : " + answer);

        return answer;
    }
}
