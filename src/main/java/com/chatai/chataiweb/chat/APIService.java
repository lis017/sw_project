package com.chatai.chataiweb.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class APIService {
    public void callPythonApi(String username, String question) {

        // 로그인 여부 확인
        if (username == null) {
            System.out.println("비로그인임");
        } else {
            System.out.println("로그인임");
        }
        
        
        RestTemplate restTemplate = new RestTemplate();

        // 전송할 데이터 준비
        Map<String, String> requestData = new HashMap<>();
        requestData.put("question", question);

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestData, headers);

//        System.out.println(question);
//        System.out.println(request);


//        // Python 서버에 POST 요청
//        String url = "http://127.0.0.1:5000/process";
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
//
//        // Python으로부터 받은 응답 출력
//        System.out.println("Response from Python: " + response.getBody());
    }
}
