package com.urttom.memory.xtpz.module;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * 系统广播实体
 */
public class TXtpzBroadcast {
    @TableId
    private String cId;
    private String cContent;
    private String cFontColor;
    private String cBackgroundColor;
    private String cValid;
    private String cCreator;
    private String cUpdater;
    @TableField(fill = FieldFill.INSERT)
    private Date dCreateTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date dUpdateTime;


    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    public String getcFontColor() {
        return cFontColor;
    }

    public void setcFontColor(String cFontColor) {
        this.cFontColor = cFontColor;
    }

    public String getcBackgroundColor() {
        return cBackgroundColor;
    }

    public void setcBackgroundColor(String cBackgroundColor) {
        this.cBackgroundColor = cBackgroundColor;
    }

    public String getcValid() {
        return cValid;
    }

    public void setcValid(String cValid) {
        this.cValid = cValid;
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
