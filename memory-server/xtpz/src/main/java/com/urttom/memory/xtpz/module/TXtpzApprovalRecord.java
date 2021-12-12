package com.urttom.memory.xtpz.module;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * 审批记录
 */
public class TXtpzApprovalRecord {

    @TableId
    private String cId;
    private String cTitle;
    private String cTheme;
    private String cReviewer;
    private Date dReviewTime;
    private String cApproved;
    private String cReason;
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

    public String getcTitle() {
        return cTitle;
    }

    public void setcTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    public String getcTheme() {
        return cTheme;
    }

    public void setcTheme(String cTheme) {
        this.cTheme = cTheme;
    }

    public String getcReviewer() {
        return cReviewer;
    }

    public void setcReviewer(String cReviewer) {
        this.cReviewer = cReviewer;
    }

    public Date getdReviewTime() {
        return dReviewTime;
    }

    public void setdReviewTime(Date dReviewTime) {
        this.dReviewTime = dReviewTime;
    }

    public String getcApproved() {
        return cApproved;
    }

    public void setcApproved(String cApproved) {
        this.cApproved = cApproved;
    }

    public String getcReason() {
        return cReason;
    }

    public void setcReason(String cReason) {
        this.cReason = cReason;
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
