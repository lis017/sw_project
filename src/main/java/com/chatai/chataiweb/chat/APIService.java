package com.chatai.chataiweb.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class APIService {
    public void callPythonApi(String username, String question) {

        // 로그인 여부 확인
        if (username == null) {
            System.out.println("비로그인임");
            System.out.println("질문 : " + question);
        } else {
            System.out.println(username + "님의 로그인임");
            System.out.println("질문 : " + question);
        }
        
        
        RestTemplate restTemplate = new RestTemplate();

        // 전송할 데이터 준비
        Map<String, String> requestData = new HashMap<>();
        requestData.put("question", question);

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(requestData, headers);


        // 챗봇 API에 질문 전달 (요청)
        String url = "http://127.0.0.1:5000/process"; // API URL
        // 요청 후 받은 응답 저장
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        try {
            // json으로 유니코드 이스퀘이프를 문자열로 변환
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(response.getBody(), Map.class);

            // 챗봇 API으로부터 받은 응답 출력
            System.out.println("Response from Python: " + map.get("response"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
