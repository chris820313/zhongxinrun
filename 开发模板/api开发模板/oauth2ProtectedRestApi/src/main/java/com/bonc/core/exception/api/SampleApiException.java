package com.bonc.core.exception.api;

import com.bonc.core.exception.Exception;

/**
 * Created by doraemon on 8/9/2017.
 */
public class SampleApiException extends Exception implements ApiException {
    @Override
    public String getErrorExpression() {
        return "1|示例api异常";
    }
}
