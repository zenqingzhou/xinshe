package com.xinshe.web.common.assertUtils;


import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChangeName {
    String value() ;
}
