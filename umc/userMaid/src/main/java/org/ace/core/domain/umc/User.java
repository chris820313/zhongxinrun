package org.ace.core.domain.umc;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "user")
public class User {
    /**
     * 用户名
     */
    @Id
    private String username;

    /**
     * 用户的冻结标志
     */
    private Boolean frozen;

    /**
     * 用户的创建时间
     */
    private Date create;

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户的冻结标志
     *
     * @return frozen - 用户的冻结标志
     */
    public Boolean getFrozen() {
        return frozen;
    }

    /**
     * 设置用户的冻结标志
     *
     * @param frozen 用户的冻结标志
     */
    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    /**
     * 获取用户的创建时间
     *
     * @return create - 用户的创建时间
     */
    public Date getCreate() {
        return create;
    }

    /**
     * 设置用户的创建时间
     *
     * @param create 用户的创建时间
     */
    public void setCreate(Date create) {
        this.create = create;
    }
}