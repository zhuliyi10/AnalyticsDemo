package com.zhuliyi.analyticsdemo;

import com.alibaba.sdk.android.man.MANHitBuilders;
import com.alibaba.sdk.android.man.MANPageHitBuilder;
import com.alibaba.sdk.android.man.MANServiceProvider;

import java.util.Map;

/**
 * Describe : 统计工具
 * Author : zhuly
 * Date : 2018-11-12
 */

public class AnalyticsUtils {
    /**
     * 发送页面埋点事件
     * @param pageName 页面名字(中文的)
     * @param duration 持续时长(单位毫秒)
     * @param properties 要发送的信息 (键:String, 值:String)
     * */
    public static void sendPagePathEvent(String pageName, long duration, Map<String, String> properties){
        MANPageHitBuilder pageHitBuilder = new MANPageHitBuilder(pageName);
        pageHitBuilder.setDurationOnPage(duration);
        if(properties!=null) {
            pageHitBuilder.setProperties(properties);
        }
        MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(pageHitBuilder.build());
    }


    /**
     * 发送自定义事件
     * @param eventName
     * @param duration
     * @param properties
     */
    public static void sendCustomEvent(String eventName, long duration, Map<String, String> properties){
        MANHitBuilders.MANCustomHitBuilder hitBuilder = new MANHitBuilders.MANCustomHitBuilder(eventName);
        hitBuilder.setEventPage("测评结果");
        hitBuilder.setDurationOnEvent(duration);
        hitBuilder.setProperties(properties);
        MANServiceProvider.getService().getMANAnalytics().getDefaultTracker().send(hitBuilder.build());
    }
}
