package com.zhuliyi.analyticsdemo;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.sdk.android.man.MANPageHitBuilder;
import com.alibaba.sdk.android.man.MANServiceProvider;

/**
 * Describe : BaseActivity
 * Author : zhuly
 * Date : 2018-11-12
 */

public class BaseActivity extends AppCompatActivity {
    protected long startTime;
    private static final String TAG="BASIC_ANALYTICS";
    @Override
    protected void onResume() {
        super.onResume();
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        long duration = System.currentTimeMillis() - startTime;
        String pageName= getPageName();
        Log.d(TAG, "页面"+pageName+"的停留时间："+duration/1000+"s");
        AnalyticsUtils.sendPagePathEvent(pageName,duration,null);
    }

    protected String getPageName(){
        return this.getClass().getSimpleName();
    }
}
