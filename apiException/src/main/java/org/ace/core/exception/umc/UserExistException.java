package org.ace.core.exception.umc;

import org.ace.core.domain.exception.Error;

/**
 * Created by doraemon on 7/15/2017.
 */
public class UserExistException extends AbstractUserException {

    public UserExistException(String username) {
        super(username);
    }

    @Override
    protected String getExpression() {
        return Error.USER_EXIST;
    }
}
