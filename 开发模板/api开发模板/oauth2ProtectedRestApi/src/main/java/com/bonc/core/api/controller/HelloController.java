package com.bonc.core.api.controller;

import com.bonc.core.domain.api.StandardResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by doraemon on 5/20/2017.
 * /welcome请求的controller
 */
@RestController
public class HelloController {
    /**
     * 输出名字参数
     *
     * @return 一个成功的标准相应
     */
    @RequestMapping("/hello")
    @ResponseBody
    @PreAuthorize("scopeCover('hawkeye.hello')")
    public StandardResponse welcome() {
        return StandardResponse.newResponse(StandardResponse.SUCCESS, "%s").format("hello");
    }
}
