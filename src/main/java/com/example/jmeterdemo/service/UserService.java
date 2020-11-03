package com.example.jmeterdemo.service;

import com.example.jmeterdemo.bean.User;
import com.example.jmeterdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(int id) {
        Map<String,Object> map = new HashMap<>();
        map.put("id", id);
        return userDao.selectOne(map);
    }

    public List<User> listUser(Map<String,Object> map) {
        return userDao.selectList(map);
    }

}
