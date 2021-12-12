package com.urttom.memory.xtpz.module;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class TXtpzTheme {
    @TableId
    private String cId;
    private String cName;
    private String cIcon;
    private Integer nOrder;
    private String isPublic;
    private String hasWatermark;
    private String allowCopy;
    private String cReviewer;
    private String cCreator;
    private String cUpdater;
    @TableField(fill = FieldFill.INSERT)
    private Date dCreateTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date dUpdateTime;

    public Date getdUpdateTime() {
        return dUpdateTime;
    }

    public void setdUpdateTime(Date dUpdateTime) {
        this.dUpdateTime = dUpdateTime;
    }

    public String getcUpdater() {
        return cUpdater;
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

    public String getcIcon() {
        return cIcon;
    }

    public void setcIcon(String cIcon) {
        this.cIcon = cIcon;
    }

    public Integer getnOrder() {
        return nOrder;
    }

    public void setnOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public String getHasWatermark() {
        return hasWatermark;
    }

    public void setHasWatermark(String hasWatermark) {
        this.hasWatermark = hasWatermark;
    }

    public String getAllowCopy() {
        return allowCopy;
    }

    public void setAllowCopy(String allowCopy) {
        this.allowCopy = allowCopy;
    }

    public String getcReviewer() {
        return cReviewer;
    }

    public void setcReviewer(String cReviewer) {
        this.cReviewer = cReviewer;
    }

    public String getcCreator() {
        return cCreator;
    }

    public void setcCreator(String cCreator) {
        this.cCreator = cCreator;
    }

    public String getcUpdator() {
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


}
