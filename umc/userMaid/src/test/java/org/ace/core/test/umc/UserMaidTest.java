package org.ace.core.test.umc;

import org.ace.core.util.umc.UserMaid;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by doraemon on 7/15/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserMaidTestConfigurer.class)
public class UserMaidTest {


    @Test
    public void testAuthenticate() {
        Assert.assertTrue(UserMaid.authenticate("root", "123456"));
    }

    @Test
    public void testGetUser() {
        Assert.assertNotNull(UserMaid.getUser("root"));
        Assert.assertNull(UserMaid.getUser("some"));
    }

    @Test
    public void testUpdateFrozen() {
        UserMaid.updateUserFrozenState("root", null);
    }
}
