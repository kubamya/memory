package com.urttom.memory.xtpz.module;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * 标签
 */
public class TXtpzLabel {

    @TableId
    private String cId;
    private String cPid;
    private String cName;
    private String cDescription;
    private Integer nOrder;
    private String cRights;
    private String cCreator;
    private String cUpdater;
    private String cBgc;
    @TableField(fill = FieldFill.INSERT)
    private Date dCreateTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date dUpdateTime;

    public String getcBgc() {
        return cBgc;
    }

    public void setcBgc(String cBgc) {
        this.cBgc = cBgc;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcPid() {
        return cPid;
    }

    public void setcPid(String cPid) {
        this.cPid = cPid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription;
    }

    public Integer getnOrder() {
        return nOrder;
    }

    public void setnOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }

    public String getcRights() {
        return cRights;
    }

    public void setcRights(String cRights) {
        this.cRights = cRights;
    }

    public String getcCreator() {
        return cCreator;
    }

    public void setcCreator(String cCreator) {
        this.cCreator = cCreator;
    }

    public String getcUpdater() {
        return cUpdater;
    }

    public void setcUpdater(String cUpdater) {
        this.cUpdater = cUpdater;
    }

    public Date getdCreateTime() {
        return dCreateTime;
    }

    public void setdCreateTime(Date dCreateTime) {
        this.dCreateTime = dCreateTime;
    }

    public Date getdUpdateTime() {
        return dUpdateTime;
    }

    public void setdUpdateTime(Date dUpdateTime) {
        this.dUpdateTime = dUpdateTime;
    }
}
