package org.ace.core.exception.umc;

/**
 * Created by doraemon on 7/15/2017.
 */
public abstract class AbstractUserException extends UmcException {

    private String username;

    public AbstractUserException(String username) {
        super("%s", username);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    protected abstract String getExpression();

    @Override
    public String getErrorExpression() {
        return String.format(getErrorExpression(), this.getUsername());
    }
}
