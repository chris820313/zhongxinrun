package org.ace.core.conf.umc;

import com.bonc.core.util.UtilTemplate;
import org.ace.core.util.umc.UserMaid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Created by doraemon on 7/15/2017.
 */
@Configuration
public class UserMaidConfigurer {
    @Autowired
    private void wireUtil(UserMaid maid) {
        UtilTemplate.registerUtil(maid);
    }
}
