package com.example.fung_backend_repo.domain.user.presentation;

import com.example.fung_backend_repo.domain.auth.presentation.response.TokenResponse;
import com.example.fung_backend_repo.domain.user.presentation.dto.request.*;
import com.example.fung_backend_repo.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.fung_backend_repo.domain.user.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;
    private final ChangePasswordService changePasswordService;
    private final ChangeAccountIdService changeAccountIdService;
    private final ChangeInterestService changeInterestService;
    private final ChangeBirthService changeBirthService;
    private final UserInfoService userInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request){
        userSignUpService.execute(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/signin")
    public TokenResponse signIn(@RequestBody @Valid UserSignInRequest request) {
        return userSignInService.signIn(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/password")
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        changePasswordService.updatePassword(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/account-id")
    public void changeAccountId(@RequestBody @Valid ChangeAccountIdRequest request) {
        changeAccountIdService.updateAccountId(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/interest")
    public void changeInterest(@RequestBody @Valid ChangeInterestRequest request) {
        changeInterestService.updateInterest(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/birth")
    public void changeBirth(@RequestBody @Valid ChangeBirthRequest request) {
        changeBirthService.updateBirth(request);
    }


    @GetMapping("/user")
    public UserInfoResponse userInfo(){

        return userInfoService.execute();
    }

}

