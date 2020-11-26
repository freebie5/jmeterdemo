package com.example.jmeterdemo.bean;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ClassBean {

    private int id;

    private String name;

    private int grade;

    private String subject;

}
