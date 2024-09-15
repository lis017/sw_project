package com.chatai.chataiweb.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입 서비스
    public void saveUser(String id, String pw, String user_name, LocalDate birth, String number) throws Exception {

        // 아이디 중복 확인
        var result = userRepository.findByUserId(id);
        if (result.isPresent()){
            throw new Exception("존재하는 아이디 입니다.");
        }

        // 유효성 검사
        if (id.length() < 5 || pw.length() < 8) {
            throw new Exception("아이디, 비밀번호가 유효하지 않습니다.");
        }

        var hashPw = passwordEncoder.encode(pw); // 비번 해싱

        // 유저 정보 저장
        User user = new User();
        user.setUserId(id);
        user.setUserPw(hashPw);
        user.setUserName(user_name);
        user.setUserBirth(birth);
        user.setUserNumber(number);

        userRepository.save(user); // DB에 유저 정보 저장
    }
}
