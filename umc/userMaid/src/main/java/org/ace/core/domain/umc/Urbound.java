package org.ace.core.domain.umc;

import javax.persistence.*;

@Table(name = "urbound")
public class Urbound {
    /**
     * 用户名
     */
    @Id
    private String username;

    /**
     * 角色
     */
    @Id
    private String role;

    /**
     * 删除标记
     */
    private Boolean deleted;

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
     * 获取角色
     *
     * @return role - 角色
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置角色
     *
     * @param role 角色
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 获取删除标记
     *
     * @return deleted - 删除标记
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 设置删除标记
     *
     * @param deleted 删除标记
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}