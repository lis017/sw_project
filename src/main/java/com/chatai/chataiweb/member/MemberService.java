package com.chatai.chataiweb.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입 서비스
    public void saveMember(String username, String password, String display_name, LocalDate birth, String number) throws Exception {

        // 아이디 중복 확인
        var result = memberRepository.findByUsername(username);
        if (result.isPresent()){
            throw new Exception("존재하는 아이디 입니다.");
        }

        // 유효성 검사
        if (username.length() < 5 || password.length() < 8) {
            throw new Exception("아이디, 비밀번호가 유효하지 않습니다.");
        }

        var hash_pw = passwordEncoder.encode(password); // 비번 해싱

        // 유저 정보 저장
        Member user = new Member();
        user.setUsername(username);
        user.setPassword(hash_pw);
        user.setDisplayName(display_name);
        user.setBirth(birth);
        user.setNumber(number);

        memberRepository.save(user); // DB에 유저 정보 저장
    }
}
