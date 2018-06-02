package com.hmw.ecexercise;

import android.app.Application;

import com.hmw.lib.core.app.Latte;
import com.hmw.lib.core.interceptors.DebugInterceptor;
import com.hmw.lib.ec.icon.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;


/**
 * Created by han on 2018/5/31.
 */

public class ExampleApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://192.168.31.80:20002/api/")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .withWeChatAppId("你的微信AppKey")
                .withWeChatAppSecret("你的微信AppSecret")
                .withJavascriptInterface("latte")
//                .withWebEvent("test", new TestEvent())
//                .withWebEvent("share", new ShareEvent())
                //添加Cookie同步拦截器
                .withWebHost("https://www.baidu.com/")
//                .withInterceptor(new AddCookieInterceptor())
                .configure();
    }
}
