package org.ace.core.test.umc;

import com.alibaba.druid.pool.DruidDataSource;
import com.bonc.core.util.UtilTemplate;
import org.ace.core.util.umc.UserMaid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * Created by doraemon on 7/15/2017.
 */
@Configuration
@ComponentScan("org.ace.core.*")
@ComponentScan("com.bonc.core.*")
public class UserMaidTestConfigurer {
    @Bean("UserMaidInited")
    public Integer initUtil() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://192.168.1.4:3306/db_bayan?characterEncoding=utf8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("1qaz2wsx");
        HashMap<Class<? extends UtilTemplate>, Object[]> args = new HashMap<>();
        args.put(UserMaid.class, new Object[]{druidDataSource});
        UtilTemplate.init(args);
        return 1;
    }
}
