package com.atwow.AuthBackend.jsons.requests;

public class AccountCreateRq {
    private String account_name;
    private String account_password;
    private String account_email;

    public String getAccount_name() {
        return account_name;
    }

    public String getAccount_password() {
        return account_password;
    }

    public String getAccount_email() {
        return account_email;
    }

    @Override
    public String toString() {
        return "AccountCreateRq{" +
                "account_name='" + account_name + '\'' +
                ", account_password='" + account_password + '\'' +
                ", account_email='" + account_email + '\'' +
                '}';
    }
}
