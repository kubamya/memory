package com.urttom.memory.passage.module;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class TPassage {

    @TableId
    private String cId;
    private String cTitle;
    private String cContent;
    private String cTheme;
    private String cLabels;
    private String cExcellent;
    private String cEssence;
    private String cTop;
    private Integer nBrowse;
    private Integer nLike;
    private String cStatus;
    private String cType;
    private String cValid;
    private Integer nCollection;
    private String cCreator;
    private String cUpdater;
    @TableField(fill = FieldFill.INSERT)
    private Date dCreateTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date dUpdateTime;
    private String cText;

    public String getcText() {
        return cText;
    }

    public void setcText(String cText) {
        this.cText = cText;
    }

    public String getcValid() {
        return cValid;
    }

    public void setcValid(String cValid) {
        this.cValid = cValid;
    }

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

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    public String getcTheme() {
        return cTheme;
    }

    public void setcTheme(String cTheme) {
        this.cTheme = cTheme;
    }

    public String getcLabels() {
        return cLabels;
    }

    public void setcLabels(String cLabels) {
        this.cLabels = cLabels;
    }

    public String getcExcellent() {
        return cExcellent;
    }

    public void setcExcellent(String cExcellent) {
        this.cExcellent = cExcellent;
    }

    public String getcEssence() {
        return cEssence;
    }

    public void setcEssence(String cEssence) {
        this.cEssence = cEssence;
    }

    public String getcTop() {
        return cTop;
    }

    public void setcTop(String cTop) {
        this.cTop = cTop;
    }

    public Integer getnBrowse() {
        return nBrowse;
    }

    public void setnBrowse(Integer nBrowse) {
        this.nBrowse = nBrowse;
    }

    public Integer getnLike() {
        return nLike;
    }

    public void setnLike(Integer nLike) {
        this.nLike = nLike;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public Integer getnCollection() {
        return nCollection;
    }

    public void setnCollection(Integer nCollection) {
        this.nCollection = nCollection;
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
