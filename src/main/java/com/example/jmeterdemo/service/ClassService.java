package com.example.jmeterdemo.service;

import com.example.jmeterdemo.dao.ClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @Autowired
    ClassDao classDao;



}
