package com.atwow.AuthBackend.units;

import jakarta.persistence.*;

@Entity
@Table(name = "account_access")
public class AccountAccess {
    @Id
    @Column(name = "AccountID")
    private Long accountID;
    @Column(name = "SecurityLevel")
    private Integer securityLevel;
    @Column(name = "RealmID")
    private Integer realmID;
    @Column(name = "Comment")
    private String comment;

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }

    public Integer getRealmID() {
        return realmID;
    }

    public void setRealmID(Integer realmID) {
        this.realmID = realmID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "AccountAccess{" +
                "accountID=" + accountID +
                ", securityLevel=" + securityLevel +
                ", realmID=" + realmID +
                ", comment='" + comment + '\'' +
                '}';
    }
}
