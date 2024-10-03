package com.chatai.chataiweb.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    // DB에 있던 유저 정보 꺼내서 로그인 확인
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // DB에 있던 유저 정보 가져오기
        var result = memberRepository.findByUsername(username);
        if (result.isEmpty()) {
            throw  new UsernameNotFoundException("해당 아이디가 존재하지 않습니다.");
        }
        var user = result.get();

        // 권한 추가
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getUsername().equals("admin")) {
            authorities.add(new SimpleGrantedAuthority("어드민"));
        } else {
            authorities.add(new SimpleGrantedAuthority("일반유저"));
        }

        // 유저의 로그인 정보
        var customUser = new User(user.getUsername(), user.getPassword(), authorities);
        
        // Authentication 삽입
        return customUser;
    }
}