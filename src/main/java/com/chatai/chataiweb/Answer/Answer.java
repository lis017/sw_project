package com.chatai.chataiweb.Answer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
@ToString
//답변 저장 jpa
public class Answer {

    //아직 따로 새 질문페이지 만드는지 모르겠어서
    //페이지별로 저장테이블 나눠 찾을수있는
    //페이지 인덱스는 안만들어 놨습니당
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String answer;

}
