package com.renren.breadtravel.widget.easytagdragview.bean;

import static com.renren.breadtravel.R.string.tip;

public class SimpleTitleTip implements Tip {
    private String cityId;
    private String ciryName;
    @Override
    public String getId() {
        return cityId;
    }

    @Override
    public void setId(String id) {
        this.cityId = id;
    }

    public String getTip() {
        return ciryName;
    }

    public void setTip(String tip) {
        this.ciryName = tip;
    }

    @Override
    public String toString() {
        return "tip:"+ tip;
    }
}
