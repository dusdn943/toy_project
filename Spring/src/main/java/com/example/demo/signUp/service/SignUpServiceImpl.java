package com.example.demo.signUp.service;

import com.example.demo.signUp.controller.form.SignUpRequestForm;
import com.example.demo.signUp.entity.Member;
import com.example.demo.signUp.repository.SignUpRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    final private SignUpRepository signUpRepository;
    @Override
    public void register(SignUpRequestForm requestForm) {
        // 1. 해당 아이디가 존재하는지?
        // 있는지 없는지 회원이 저장되어 있는 데이터베이스에서 아이디를 찾아와줘.
        Optional<Member> member = signUpRepository.findByUserId(requestForm.getUserId());
        if (member.isPresent()) {
            throw new RuntimeException("이메일이 존재합니다.");
        }

        Member member1 = requestForm.toMember();
        signUpRepository.save(member1);
    }
}
