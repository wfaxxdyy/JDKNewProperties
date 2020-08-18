package cn.wf.model;

import lombok.Data;

@Data
public class User {
    private String name;
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
