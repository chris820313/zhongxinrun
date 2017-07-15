package org.ace.core.mapper.umc;

import org.ace.core.domain.umc.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends UmcMapper<User> {
    Integer authenticate(@Param("username") String username, @Param("password") String password);

    User getUser(@Param("username") String username);

    Integer updateUserFrozenState(@Param("username") String username, @Param("frozen") Integer frozen);
}