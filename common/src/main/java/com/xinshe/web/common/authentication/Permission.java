package com.xinshe.web.common.authentication;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    boolean ignore() default false;

    /**
     * 接口权限的 权限码
     * @return
     */
    int codes() default 0;

    /**
     * 接口权限的中文分组
     * 此属性相同的接口权限，在权限管理页面会按同一组显示
     * @return
     */
    String  category() default "";

    /**
     * 接口权限的中文描述
     * @return
     */
    String description() default "";
}
