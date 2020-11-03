package com.example.jmeterdemo.dao;

import com.example.jmeterdemo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDao {

    int insertOne(User user);

    int batchInsert(@Param("users") List<User> users);

    User selectOne(Map<String,Object> map);

    List<User> selectList(Map<String,Object> map);

}
