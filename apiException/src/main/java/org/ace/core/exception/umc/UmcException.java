package org.ace.core.exception.umc;

import com.bonc.core.exception.ApiException;
import com.bonc.core.exception.Exception;

/**
 * Created by doraemon on 7/15/2017.
 */
public abstract class UmcException extends Exception implements ApiException {
    public UmcException(String format, Object... args) {
        super(format, args);
    }
}
