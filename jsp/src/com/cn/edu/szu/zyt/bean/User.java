package com.cn.edu.szu.zyt.bean;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private int age;
    private Address addr;

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        System.out.println("getusername执行了");
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        System.out.println("getpassword执行了");
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        System.out.println("getage执行了");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
    public int getEmail() {
        System.out.println("getemail执行了");
        return 11111110;
    }
}
