package com.zhuliyi.analyticsdemo;

import android.app.Application;

import com.alibaba.sdk.android.man.MANService;
import com.alibaba.sdk.android.man.MANServiceProvider;

/**
 * Describe : Application
 * Author : zhuly
 * Date : 2018-11-12
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 获取MAN服务
        MANService manService = MANServiceProvider.getService();
        // 打开调试日志，线上版本建议关闭
        // manService.getMANAnalytics().turnOnDebug();
        // 若需要关闭 SDK 的自动异常捕获功能可进行如下操作(如需关闭crash report，建议在init方法调用前关闭crash),详见文档5.4
        manService.getMANAnalytics().turnOffCrashReporter();
        // 设置渠道（用以标记该app的分发渠道名称），如果不关心可以不设置即不调用该接口，渠道设置将影响控制台【渠道分析】栏目的报表展现。如果文档3.3章节更能满足您渠道配置的需求，就不要调用此方法，按照3.3进行配置即可；1.1.6版本及之后的版本，请在init方法之前调用此方法设置channel.
//        manService.getMANAnalytics().setChannel("测试渠道");
        // MAN初始化方法之一，从AndroidManifest.xml中获取appKey和appSecret初始化，若您采用上述 2.3中"统一接入的方式"，则使用当前init方法即可。
        manService.getMANAnalytics().init(this, getApplicationContext());

        // 通过此接口关闭页面自动打点功能，详见文档4.2
        manService.getMANAnalytics().turnOffAutoPageTrack();

    }
}
