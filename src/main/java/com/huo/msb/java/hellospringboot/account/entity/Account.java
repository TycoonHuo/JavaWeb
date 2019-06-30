package com.huo.msb.java.hellospringboot.account.entity;


/**
 * 实体类 对应Spring data jpa
 *
 * @author huoyun
 * @date 2019/6/29-12:37
 */
public class Account {
    private Integer id;
    private String loginName;
    private Integer age;
    private String password;
    private String nickName;
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Account() {
    }


    public Account(Integer id, String loginName, Integer age, String password, String nickName, String location) {
        this.id = id;
        this.loginName = loginName;
        this.age = age;
        this.password = password;
        this.nickName = nickName;
        this.location = location;
    }
}
