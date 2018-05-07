package com.waynechen.recyclerviewusage;

/**
 * Created by Wayne Chen on 2018/5/7.
 */
public class UsageItem {

    private String mTitle;
    private int mDrawableNum;

    public UsageItem() {
        mTitle = "";
        mDrawableNum = -1;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getDrawableNum() {
        return mDrawableNum;
    }

    public void setDrawableNum(int drawableNum) {
        mDrawableNum = drawableNum;
    }
}
