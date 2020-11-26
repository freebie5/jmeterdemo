package com.example.jmeterdemo.dao;

import com.example.jmeterdemo.bean.ClassBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ClassDao {

    int batchInsert(@Param("classes") List<ClassBean> users);

}
