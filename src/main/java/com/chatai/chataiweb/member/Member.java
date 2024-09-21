package com.chatai.chataiweb.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    private String password;

    @Column(length = 20)
    private String displayName;

    private LocalDate birth;

    @Column(length = 20)
    private String number;
}
