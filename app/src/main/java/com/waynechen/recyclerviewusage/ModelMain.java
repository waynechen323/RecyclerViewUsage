package com.waynechen.recyclerviewusage;

import java.util.ArrayList;

/**
 * Created by Wayne Chen on 2018/5/7.
 */
public class ModelMain {

    private ArrayList<UsageItem> mUsageItems;

    public ModelMain() {
        initMockData();
    }

    public ArrayList<UsageItem> getUsageItems() {
        return mUsageItems;
    }

    private void initMockData() {
        mUsageItems = new ArrayList<>();

        for (int i = 0; i < 17; i++) {
            UsageItem item = new UsageItem();
            item.setTitle("Number " + (i + 1));
            item.setDrawableNum(i % 2);
            mUsageItems.add(item);
        }
    }
}
