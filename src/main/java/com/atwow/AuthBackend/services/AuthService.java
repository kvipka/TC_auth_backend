package com.atwow.AuthBackend.services;

import com.atwow.AuthBackend.jsons.requests.AccountCreateRq;
import com.atwow.AuthBackend.jsons.requests.AccountVerifyRq;
import com.atwow.AuthBackend.jsons.responses.BaseResponse;
import com.atwow.AuthBackend.repos.AccountRepository;
import com.atwow.AuthBackend.units.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.atwow.AuthBackend.helpers.HelperTCSRP6.*;

@Service
public class AuthService {
    @Autowired
    AccountRepository accountRepository;

    public AuthService() {
    }

    public Object getAccount(String accName) {
        Account account = this.accountRepository.findByUsername(accName);
        if (account != null) {
            return account;
        }
        return new BaseResponse("Account not founded", 0);
    }

    public Object verifyAccount(AccountVerifyRq body) {
        if (body.getAccount_name() == null ||
                body.getAccount_name().length() < 1) {
            return new BaseResponse("username should be exist (1-16 symbols)", 200);
        }

        if (body.getAccount_password() == null ||
                body.getAccount_password().length() < 1) {
            return new BaseResponse("password should be exist (1-16 symbols)", 201);
        }

        Account check = this.accountRepository.findByUsername(body.getAccount_name());
        if (check == null) {
            return new BaseResponse("Account with this username doesn't exist", 0);
        }

        if (verifySRP6(body.getAccount_name(), body.getAccount_password(), check.getSalt(), check.getVerifier())) {
            return new BaseResponse("Login-Password correct", 0);
        }
        return new BaseResponse("Login-Password incorrect", 0);
    }

    public Object createAccount(AccountCreateRq body) {
        if (body.getAccount_name() == null ||
                body.getAccount_name().length() < 1) {
            return new BaseResponse("username should be exist (1-16 symbols)", 200);
        }

        if (body.getAccount_password() == null ||
                body.getAccount_password().length() < 1) {
            return new BaseResponse("password should be exist (1-16 symbols)", 201);
        }

        if (body.getAccount_name().length() > 16) {
            return new BaseResponse("username's too long", 202);
        }
        if (body.getAccount_password().length() > 16) {
            return new BaseResponse("password's too long", 203);
        }

        if (body.getAccount_email() == null) {
            return new BaseResponse("email should be exist", 204);
        }

        Account check = this.accountRepository.findByUsername(body.getAccount_name());
        if (check != null) {
            return new BaseResponse("Account with this username already exist", 205);
        }

        // Reg
        byte[] salt = generateRandomSalt(32);
        byte[] verifier = calculateSRP6TCVerifier(body.getAccount_name(), body.getAccount_password(), salt);

        Account account = new Account();
        account.setUsername(body.getAccount_name());
        account.setSalt(salt);
        account.setVerifier(verifier);
        account.setEmail(body.getAccount_email());
        account.setReg_mail(body.getAccount_email());
        account.setLast_ip("127.0.0.1");
        account.setLast_attempt_ip("127.0.0.1");
        account.setFailed_logins(0);
        account.setLocked(false);
        account.setLock_country("00");
        account.setOnline(false);
        account.setExpansion(2);
        account.setMutetime(0L);
        account.setMutereason("");
        account.setMuteby("");
        account.setLocale(0);
        account.setOs("");
        account.setRecruiter(0L);
        account.setCoins(0);

        this.accountRepository.save(account);
        return new BaseResponse("Account successfully created", 0);
    }
}
