package org.ace.core.util.umc;

import com.bonc.core.util.UtilProvider;
import com.bonc.core.util.UtilTemplate;
import org.ace.core.domain.umc.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by doraemon on 7/15/2017.
 */
@Component
public class UserMaid extends UtilTemplate {
    private static UserMaidProvider provider;

    @Autowired
    private void wireProvider(UserMaidProvider userMaidProvider) {
        provider = userMaidProvider;
    }

    @Override
    protected UtilProvider announceProvider() {
        return provider;
    }

    public static boolean authenticate(String username, String password) {
        return provider.authenticate(username, password);
    }

    public static User getUser(String username) {
        return provider.getUser(username);
    }

    public static void updateUserFrozenState(String username, Integer frozen) {
        provider.updateUserFrozenState(username, frozen);
    }

    public static void updatePassword(String username, String password) {
        provider.updatePassword(username, password);
    }

    public static void addUser(String username, String password, Map args) {
        provider.addUser(username, password, args);
    }
}
