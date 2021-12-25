package com.urttom.memory.user.module;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 */
public class TSysUser implements Serializable {

    private String cId;
    private String cName;
    private String cSex;
    private String cDeptId;
    private String cCorpId;
    private String cLoginId;
    private String cPassword;
    private String cAvatar;
    private String cEmail;

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex;
    }

    public String getcDeptId() {
        return cDeptId;
    }

    public void setcDeptId(String cDeptId) {
        this.cDeptId = cDeptId;
    }

    public String getcCorpId() {
        return cCorpId;
    }

    public void setcCorpId(String cCorpId) {
        this.cCorpId = cCorpId;
    }

    public String getcLoginId() {
        return cLoginId;
    }

    public void setcLoginId(String cLoginId) {
        this.cLoginId = cLoginId;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getcAvatar() {
        return cAvatar;
    }

    public void setcAvatar(String cAvatar) {
        this.cAvatar = cAvatar;
    }
}
