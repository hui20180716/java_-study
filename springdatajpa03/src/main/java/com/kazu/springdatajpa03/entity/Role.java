package com.kazu.springdatajpa03.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色类
 */
@Entity
@Table(name = "t_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String roleName;
//一个角色被多个用户拥有
    //fetch = FetchType.EAGER:立即注册
    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<User> users =new HashSet<User>();


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
