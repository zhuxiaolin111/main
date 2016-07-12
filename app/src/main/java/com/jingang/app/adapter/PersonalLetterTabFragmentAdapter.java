package com.jingang.app.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jingang.app.fragment.MyFragment;

/**
 * Created by Administrator on 2016/6/13
 */

public class PersonalLetterTabFragmentAdapter extends FragmentPagerAdapter {

    private String[] strs = null ;
    private ArrayList<MyFragment> fragments ;

    public PersonalLetterTabFragmentAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    public void setData(String[] strs,ArrayList<MyFragment> fragments){
        if(strs == null){
            strs = new String[]{} ;
        }

        this.strs = strs ;

        if(fragments == null){
            fragments = new ArrayList<MyFragment>();
        }

        this.fragments = fragments ;
    }

    @Override
    public Fragment getItem(int position) {
        // TODO Auto-generated method stub
        return  fragments != null && fragments.size() > 0 ? fragments.get(position) : null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strs != null && strs.length > position ? strs[position] : "";
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return strs != null ? strs.length : 0;
    }

}

