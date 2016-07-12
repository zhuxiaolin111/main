package com.jingang.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jingang.app.R;

/**
 * 
 * @author liuhai
 *
 */
public class testfragment extends MyFragment {

	private View view;
	private boolean isRefresh = true;// 获取数据成功还是失败 为后面执行刷新还是加载 成功或者失败

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		view = inflater.inflate(R.layout.setting_activity, container, false);

		ViewGroup parent = (ViewGroup) view.getParent();
		if (parent != null) {
			parent.removeView(view);
		}
		return view;
	}

	@Override
	protected void onVisible(boolean isInit) {
		// TODO Auto-generated method stub
		if (isInit) {
			initView();

		}

	}

	private void initView() {

	}

}
