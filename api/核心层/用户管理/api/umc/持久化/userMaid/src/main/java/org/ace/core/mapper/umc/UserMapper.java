package org.ace.core.mapper.umc;

import org.ace.core.domain.umc.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper extends UmcMapper<User> {
    Integer authenticate(@Param("username") String username, @Param("password") String password);

    User getUser(@Param("username") String username);

    int updateUserFrozenState(@Param("username") String username, @Param("frozen") Integer frozen);

    int updatePassword(@Param("username") String username, @Param("password") String password);

    int addUser(Map args);
}