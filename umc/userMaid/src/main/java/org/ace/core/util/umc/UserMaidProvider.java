package org.ace.core.util.umc;

import com.bonc.core.annotation.util.UtilService;
import com.bonc.core.util.UtilProvider;
import org.ace.core.domain.umc.User;
import org.ace.core.exception.umc.UserNotExistException;
import org.ace.core.mapper.umc.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by doraemon on 7/15/2017.
 */
@Component
public class UserMaidProvider extends UtilProvider {
    private static SqlSessionFactory sessionFactory;

    private static SqlSession openSession() {
        return sessionFactory.openSession();
    }

    private static SqlSessionFactory primarySqlSessionFactoryBean(DataSource primaryDataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(primaryDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("org.ace.core.domain.umc");

        // Another
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("org/ace/core/mapper/umc/*.xml"));
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sqlSessionFactory;
    }

    @Override
    protected void onInit(Object[] objects) {
        DataSource dataSource = (DataSource) objects[0];
        sessionFactory = primarySqlSessionFactoryBean((DataSource) dataSource);
    }

    @UtilService
    public boolean authenticate(String username, String password) {
        SqlSession session = openSession();
        try {
            session = sessionFactory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.authenticate(username, password) > 0;
        } finally {
            session.close();
        }

    }

    @UtilService
    public User getUser(String username) {
        SqlSession session = openSession();
        try {
            session = sessionFactory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUser(username);
            if (user == null) throw new UserNotExistException(username);
            return user;
        } finally {
            session.close();
        }
    }

    @UtilService
    public void updateUserFrozenState(String username, Integer frozen) {
        SqlSession session = openSession();
        try {
            session = sessionFactory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            if (mapper.updateUserFrozenState(username, frozen) == 0) {
                throw new UserNotExistException(username);
            }
        } finally {
            session.close();
        }
    }

    @UtilService
    public void updatePassword(String username, String password) {
        SqlSession session = openSession();
        try {
            session = sessionFactory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            if (mapper.updatePassword(username, password) == 0) {
                throw new UserNotExistException(username);
            }
        } finally {
            session.close();
        }
    }
}
