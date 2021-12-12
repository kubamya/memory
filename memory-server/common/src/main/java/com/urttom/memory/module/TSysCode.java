package com.urttom.memory.module;

import java.io.Serializable;

/**
 * 单值代码
 */
public class TSysCode implements Serializable {

    private String cPid;
    private String cId;
    private String cSfyx;
    private String cName;
    private String cPname;

    public String getcPid() {
        return cPid;
    }

    public void setcPid(String cPid) {
        this.cPid = cPid;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcSfyx() {
        return cSfyx;
    }

    public void setcSfyx(String cSfyx) {
        this.cSfyx = cSfyx;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcPname() {
        return cPname;
    }

    public void setcPname(String cPname) {
        this.cPname = cPname;
    }
}
