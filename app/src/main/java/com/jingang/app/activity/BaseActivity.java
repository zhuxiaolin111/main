
package com.jingang.app.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;


public class BaseActivity extends FragmentActivity {

    private boolean isExit ;

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean isExit) {
        this.isExit = isExit;
    }

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    /**
     * 返回
     * @param view
     */
    public void back(View view) {
        finish();
    }
}
