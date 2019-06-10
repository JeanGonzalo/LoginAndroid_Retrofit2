package com.example.platzigram.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.platzigram.views.fragment.TabOneFragment;
import com.example.platzigram.views.fragment.TabTwoFragment;

public class PageAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    public PageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                TabOneFragment tab1 = new TabOneFragment();
                return tab1;
            case 1:
                TabTwoFragment tab2 = new TabTwoFragment();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
