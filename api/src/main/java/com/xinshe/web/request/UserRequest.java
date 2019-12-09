package com.xinshe.web.request;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * Created by zengqingzhou on 2019/7/9 0:41
 */
@Data
public class UserRequest{
    /**
     * 用户名
     */
    @NotNull(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    private String passWord;
}
