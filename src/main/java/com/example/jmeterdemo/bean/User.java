package com.example.jmeterdemo.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class User {

    private String id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phone;
    private Date birthday;
    private Date createTime;
    private Date modifyTime;

}
