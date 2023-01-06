package com.atwow.AuthBackend.controllers;

import com.atwow.AuthBackend.jsons.requests.AccountCreateRq;
import com.atwow.AuthBackend.jsons.requests.AccountVerifyRq;
import com.atwow.AuthBackend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/getAccount")
    public Object getWoWAccount(@RequestParam(value = "acc_name") String accName) {
        return this.authService.getAccount(accName);
    }

    @PostMapping("/createAccount")
    public Object createWoWAccount(@RequestBody AccountCreateRq rqBody) {
        return this.authService.createAccount(rqBody);
    }

    @PostMapping("/verifyAccount")
    public Object verifyWoWAccount(@RequestBody AccountVerifyRq rqBody) {
        return this.authService.verifyAccount(rqBody);
    }
}

