package org.ace.core.domain.umc;

import javax.persistence.*;

@Table(name = "role")
public class Role {
    /**
     * 角色
     */
    @Id
    private String role;

    /**
     * 角色名称
     */
    private String comment;

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
     * 获取角色名称
     *
     * @return comment - 角色名称
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置角色名称
     *
     * @param comment 角色名称
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}