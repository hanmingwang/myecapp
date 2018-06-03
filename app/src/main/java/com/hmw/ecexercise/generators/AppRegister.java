package com.hmw.ecexercise.generators;


import com.hmw.lib.annotations.AppRegisterGenerator;
import com.hmw.lib.core.wechat.templates.AppRegisterTemplate;

/**
 * Created by han on 2018/6/3.
 */
@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.diabin.fastec.example",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
