package com.zhuliyi.analyticsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Describe : 自定义事件
 * Author : zhuly
 * Date : 2018-11-12
 */

public class CustomAnalyticsActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_analytics);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long duration = System.currentTimeMillis() - startTime;
                Map<String,String> properties=new HashMap<>();
                properties.put("user","zhuly");
                properties.put("question1","1");
                properties.put("question2","3");
                properties.put("question3","4");
                properties.put("question4","2");
                AnalyticsUtils.sendCustomEvent(getPageName()+"-"+"提交报告",duration,properties);
            }
        });
    }
}
