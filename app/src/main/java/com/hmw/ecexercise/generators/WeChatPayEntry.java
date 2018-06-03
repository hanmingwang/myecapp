package com.hmw.ecexercise.generators;


import com.hmw.lib.annotations.PayEntryGenerator;
import com.hmw.lib.core.wechat.templates.WXPayEntryTemplate;

/**
 * Created by han on 2018/6/3.
 */
@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.diabin.fastec.example",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
