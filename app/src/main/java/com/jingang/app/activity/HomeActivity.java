package com.jingang.app.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jingang.app.R;
import com.jingang.app.entity.TabMode;
import com.jingang.app.fragment.HomeFragment;
import com.jingang.app.fragment.InfomationFragment;
import com.jingang.app.fragment.SearchFriendFragment;
import com.jingang.app.fragment.testfragment;
import com.jingang.app.libs.DragLayout;
import com.jingang.app.libs.MyRelativeLayout;
import com.jingang.app.tabhost.TabFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主页
 * 
 * @author liuhai.com
 */
public class HomeActivity extends BaseActivity {

	// 控制底部标题栏图标颜色改变
	public static final int HOME_TAB = 1000;
	public static final int SEARCH_TAB = 2000;
	public static final int HOME_TAB_MESSAGE = 3000;
	public static final int FENLEI_TAB = 4000;

	private String TAG = "HomeActivity";
	private Context context;
	/**
	 * 左边侧滑菜单
	 */
	private DragLayout mDragLayout;
	private LinearLayout menu_header;
	private TextView menu_setting, tv_name;

	private ListView menuListView;// 菜单列表

	private TabFragment actionBarFragment;
	private MyRelativeLayout myRelativeLayout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		initView();// 初始化控件

		// 左侧页面listView添加数据
		List<Map<String, Object>> data = getMenuData();

		menuListView.setAdapter(new SimpleAdapter(this, data,
				R.layout.wxtong_leftitem,
				new String[] { "item", "image", "iv" }, new int[] {
						R.id.tv_item, R.id.iv_item, R.id.iv }));
	}

	/**
	 * 控件初始化
	 */
	private void initView() {
		context = this;
		MangerActivitys.addActivity(context);

		// 点击back按钮
		actionBarFragment = (TabFragment) getSupportFragmentManager()
				.findFragmentById(R.id.tab_bar_fragment);

		int code = 1;
		final ArrayList<TabMode> listTabModes = new ArrayList<TabMode>();
			{// 底部导航栏首页
				final TabMode tabMode = new TabMode(HOME_TAB,
					R.drawable.tab_1_selector, "首页",
					R.color.tab_text_color_selector, new HomeFragment(),
					code == 1);
			listTabModes.add(tabMode);
		}
		{// 底部搜索栏
			final TabMode tabMode = new TabMode(SEARCH_TAB,
					R.drawable.tab_2_selector, "搜索",
					R.color.tab_text_color_selector,
					new SearchFriendFragment(), code == 2);//
			listTabModes.add(tabMode);

		}

		{// 底部消息栏
			final TabMode tabMode = new TabMode(HOME_TAB_MESSAGE,
					R.drawable.tab_3_selector, "信息",
					R.color.tab_text_color_selector, new InfomationFragment(),
					code == 3);
			listTabModes.add(tabMode);
		}

		{// 底部分类栏（图标颜色的改变机制有待研究）
			final TabMode tabMode = new TabMode(FENLEI_TAB,
					R.drawable.tab_5_selector, "分类",
					R.color.tab_text_color_selector, new testfragment(),
					code == 4);
			listTabModes.add(tabMode);

		}
		actionBarFragment.creatTab(HomeActivity.this, listTabModes,
				new TabFragment.IFocusChangeListener() {

					@Override
					public void OnFocusChange(int currentTabId, int tabIndex) {

					}
				});

		// 这部分是底部menu的view控件
		menu_setting = (TextView) this.findViewById(R.id.iv_setting);
		menu_header = (LinearLayout) this.findViewById(R.id.menu_header);
		mDragLayout = (DragLayout) findViewById(R.id.dl);
		tv_name = (TextView) findViewById(R.id.tv_name);
		myRelativeLayout = (MyRelativeLayout) findViewById(R.id.rl_layout);
		mDragLayout.setBorder(actionBarFragment);
		myRelativeLayout.setDragLayout(mDragLayout);

		/**
		 * 抽屜动作监听(侧滑时的动作监听)
		 */
		mDragLayout
				.setOnLayoutDragingListener(new DragLayout.OnLayoutDragingListener() {

					@Override
					public void onOpen() {
						// 打开
						Log.d(TAG, "抽屉打开?>>>>>>>>>>");
					}

					@Override
					public void onDraging(float percent) {
						// 滑动中
						Log.d(TAG, "抽屉滑动>>>>>>>>>>>>>>");
					}

					@Override
					public void onClose() {
						// 关闭
						Log.d(TAG, "抽屉关闭？>>>>>>>>>>>>");
					}
				});

		menuListView = (ListView) findViewById(R.id.menu_listview);// 抽屉列表
		// 侧滑栏抽屉的点击事件(listview de点击事件)
		menuListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long arg3) {
				// TODO Auto-generated method stub
				// Toast.makeText(HomeActivity.this, "点击生效", 1000).show();
				if (position == 3) {
					Toast.makeText(HomeActivity.this, "点击生效++++++++++++", Toast.LENGTH_SHORT).show();

				}

			}
		});
		initResideListener();// 个人中心、设置点击事件
	}

	/**
	 * 个人中心、设置点击事件
	 */
	private void initResideListener() {
		// 点击个人中心
		menu_header.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(HomeActivity.this, "头部点击事件",Toast.LENGTH_SHORT).show();

			}
		});

		// 昵称的点击事件
		tv_name.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(HomeActivity.this, "请输入昵称", Toast.LENGTH_SHORT).show();
			}
		});

		// 进入设置界面(跳转到另一个界面)
		menu_setting.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, SettingActivity.class);
				startActivity(intent);
			}
		});

	}

	/**
	 * 加载抽屉列表数据
	 *
	 * @return
	 */
	private List<Map<String, Object>> getMenuData() {
			List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
			Map<String, Object> item;
			item = new HashMap<String, Object>();
			item.put("item", "关于");
			item.put("image", R.drawable.ic_launcher);
			item.put("iv", R.drawable.icon_kehu_arrow);
			data.add(item);

			item = new HashMap<String, Object>();
			item.put("item", "一键预览");
			item.put("image", R.drawable.ic_launcher);
			item.put("iv", R.drawable.icon_kehu_arrow);
			data.add(item);

			item = new HashMap<String, Object>();
			item.put("item", "版本更新");
			item.put("image", R.drawable.ic_launcher);
			item.put("iv", R.drawable.icon_kehu_arrow);
			data.add(item);

			item = new HashMap<String, Object>();
			item.put("item", "联系客服");
			item.put("image", R.drawable.ic_launcher);
			item.put("iv", R.drawable.icon_kehu_arrow);
			data.add(item);

			item=new HashMap<String, Object>();
			item.put("item", "技术支持");
			item.put("image", R.drawable.ic_launcher);
			item.put("iv", R.drawable.icon_kehu_arrow);
			data.add(item);

			return data;
	}

	/**
	 * activity对象回收
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		for (int i = 0; i < MangerActivitys.activitys.size(); i++) {
			if (MangerActivitys.activitys.get(i) != null) {
				((Activity) MangerActivitys.activitys.get(i)).finish();
			}
		}
		finish();
		System.gc();
	}
	/**
	 * 返回键监听(现在好像不怎么用这个了)
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("确定要退出吗？")
					.setCancelable(false)
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent intent = new Intent(
											Intent.ACTION_MAIN);
									intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
									intent.addCategory(Intent.CATEGORY_HOME);
									startActivity(intent);
								}
							})
					.setNegativeButton("取消",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			AlertDialog alert = builder.create();
			alert.show();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
