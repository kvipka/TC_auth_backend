package com.atwow.AuthBackend.jsons.requests;

public class AccountVerifyRq {
    private String account_name;
    private String account_password;

    public String getAccount_name() {
        return account_name;
    }

    public String getAccount_password() {
        return account_password;
    }

    @Override
    public String toString() {
        return "AccountVerifyRq{" +
                "account_name='" + account_name + '\'' +
                ", account_password='" + account_password + '\'' +
                '}';
    }
}
