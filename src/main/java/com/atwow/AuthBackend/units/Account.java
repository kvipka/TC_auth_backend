package com.atwow.AuthBackend.units;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @JsonIgnore
    @Column(columnDefinition = "binary(32)", length = 32)
    private byte[] salt;
    @JsonIgnore
    @Column(columnDefinition = "binary(32)", length = 32)
    private byte[] verifier;
    @JsonIgnore
    @Column(columnDefinition = "binary(40)", length = 40)
    private byte[] session_key_auth;
    @JsonIgnore
    private byte[] session_key_bnet;
    @JsonIgnore
    private byte[] totp_secret;

    private String email;
    private String reg_mail;
    private Timestamp joindate;
    private String last_ip;
    private String last_attempt_ip;
    private Integer failed_logins;
    private Boolean locked;
    private String lock_country;
    private Timestamp last_login;
    private Boolean online;
    private Integer expansion;
    private Long mutetime;
    private String mutereason;
    private String muteby;
    private Integer locale;
    private String os;
    private Long recruiter;
    private Integer coins;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public byte[] getVerifier() {
        return verifier;
    }

    public void setVerifier(byte[] verifier) {
        this.verifier = verifier;
    }

    public byte[] getSession_key_auth() {
        return session_key_auth;
    }

    public void setSession_key_auth(byte[] session_key_auth) {
        this.session_key_auth = session_key_auth;
    }

    public byte[] getSession_key_bnet() {
        return session_key_bnet;
    }

    public void setSession_key_bnet(byte[] session_key_bnet) {
        this.session_key_bnet = session_key_bnet;
    }

    public byte[] getTotp_secret() {
        return totp_secret;
    }

    public void setTotp_secret(byte[] totp_secret) {
        this.totp_secret = totp_secret;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReg_mail() {
        return reg_mail;
    }

    public void setReg_mail(String reg_mail) {
        this.reg_mail = reg_mail;
    }

    public Timestamp getJoindate() {
        return joindate;
    }

    public void setJoindate(Timestamp joindate) {
        this.joindate = joindate;
    }

    public String getLast_ip() {
        return last_ip;
    }

    public void setLast_ip(String last_ip) {
        this.last_ip = last_ip;
    }

    public String getLast_attempt_ip() {
        return last_attempt_ip;
    }

    public void setLast_attempt_ip(String last_attempt_ip) {
        this.last_attempt_ip = last_attempt_ip;
    }

    public Integer getFailed_logins() {
        return failed_logins;
    }

    public void setFailed_logins(Integer failed_logins) {
        this.failed_logins = failed_logins;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getLock_country() {
        return lock_country;
    }

    public void setLock_country(String lock_country) {
        this.lock_country = lock_country;
    }

    public Timestamp getLast_login() {
        return last_login;
    }

    public void setLast_login(Timestamp last_login) {
        this.last_login = last_login;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Integer getExpansion() {
        return expansion;
    }

    public void setExpansion(Integer expansion) {
        this.expansion = expansion;
    }

    public Long getMutetime() {
        return mutetime;
    }

    public void setMutetime(Long mutetime) {
        this.mutetime = mutetime;
    }

    public String getMutereason() {
        return mutereason;
    }

    public void setMutereason(String mutereason) {
        this.mutereason = mutereason;
    }

    public String getMuteby() {
        return muteby;
    }

    public void setMuteby(String muteby) {
        this.muteby = muteby;
    }

    public Integer getLocale() {
        return locale;
    }

    public void setLocale(Integer locale) {
        this.locale = locale;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Long getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Long recruiter) {
        this.recruiter = recruiter;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "\nWoWAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salt=" + Arrays.toString(salt) +
                ", verifier=" + Arrays.toString(verifier) +
                ", session_key_auth=" + Arrays.toString(session_key_auth) +
                ", session_key_bnet=" + Arrays.toString(session_key_bnet) +
                ", totp_secret=" + Arrays.toString(totp_secret) +
                ", email='" + email + '\'' +
                ", reg_mail='" + reg_mail + '\'' +
                ", joindate=" + joindate +
                ", last_ip='" + last_ip + '\'' +
                ", last_attempt_ip='" + last_attempt_ip + '\'' +
                ", failed_logins=" + failed_logins +
                ", locked=" + locked +
                ", lock_country='" + lock_country + '\'' +
                ", last_login=" + last_login +
                ", online=" + online +
                ", expansion=" + expansion +
                ", mutetime=" + mutetime +
                ", mutereason='" + mutereason + '\'' +
                ", muteby='" + muteby + '\'' +
                ", locale=" + locale +
                ", os='" + os + '\'' +
                ", recruiter=" + recruiter +
                ", coins=" + coins +
                '}';
    }
}

