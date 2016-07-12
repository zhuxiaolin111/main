package com.jingang.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jingang.app.R;

/**
 *     底部信息栏
 *
 * @author liuhai
 */
public class InfomationFragment extends MyFragment implements View.OnClickListener  {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_list, container, false);

        return view;
    }
    /**
     * onClick事件
     */
    @Override
    public void onClick(View view) {
    }




    @Override
    protected void onVisible(boolean isInit) {

    }
}
