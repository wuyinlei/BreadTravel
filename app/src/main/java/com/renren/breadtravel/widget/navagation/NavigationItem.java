package com.renren.breadtravel.widget.navagation;

import android.graphics.drawable.Drawable;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: NavigationItem.java
 * @author: myName
 * @date: 2016-07-30 15:54
 */

public class NavigationItem {
    private String mText;


    public NavigationItem(String text) {
        mText = text;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

}
