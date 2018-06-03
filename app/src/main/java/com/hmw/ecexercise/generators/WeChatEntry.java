package com.hmw.ecexercise.generators;


import com.hmw.lib.annotations.EntryGenerator;
import com.hmw.lib.core.wechat.templates.WXEntryTemplate;

/**
 * Created by han on 2018/6/3.
 */

@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.diabin.fastec.example",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
