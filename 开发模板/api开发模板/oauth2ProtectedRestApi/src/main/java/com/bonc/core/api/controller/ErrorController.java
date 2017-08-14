package com.bonc.core.api.controller;

import com.bonc.core.domain.api.StandardResponse;
import com.bonc.core.exception.api.SampleApiException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理error请求的controller
 * Created by doraemon on 5/21/2017.
 */
@RestController
public class ErrorController {
    /**
     * 输出错误状态表达式
     *
     * @return 标准响应
     */
    @RequestMapping("/apiError")
    @ResponseBody
    @PreAuthorize("scopeCover('error')")
    public StandardResponse error() {
        throw new SampleApiException();
    }
}
