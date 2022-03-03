package com.urttom.memory.passage.module;

import com.baomidou.mybatisplus.annotation.TableId;

public class TPassageLabel {
    @TableId
    private String cId;
    private String cPassageId;
    private String cLabelId;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcPassageId() {
        return cPassageId;
    }

    public void setcPassageId(String cPassageId) {
        this.cPassageId = cPassageId;
    }

    public String getcLabelId() {
        return cLabelId;
    }

    public void setcLabelId(String cLabelId) {
        this.cLabelId = cLabelId;
    }
}
