package com.example.demo.signUp.controller.form;

import com.example.demo.signUp.entity.Member;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestForm {

    private String userId;

    private String userPw;

    private String userName;

    private String useremail;

    public Member toMember() {
        return Member.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .useremail(useremail)
                .build();
    }
}
