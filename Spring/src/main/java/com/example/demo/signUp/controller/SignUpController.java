package com.example.demo.signUp.controller;

import com.example.demo.signUp.controller.form.SignUpRequestForm;
import com.example.demo.signUp.service.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/Member")
public class SignUpController {

    final private SignUpService signUpService;
    @PostMapping("/sing-up")
    public void signUp (@RequestBody SignUpRequestForm requestForm) {
        log.info("signUp()");
        signUpService.register(requestForm);
    }
}
