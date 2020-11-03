package com.example.jmeterdemo;

import com.example.jmeterdemo.bean.User;
import com.example.jmeterdemo.dao.UserDao;
import com.example.jmeterdemo.utils.CreateAddressUtils;
import com.example.jmeterdemo.utils.CreateDateUtils;
import com.example.jmeterdemo.utils.CreateMobileUtils;
import com.example.jmeterdemo.utils.CreateNameUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
class JmeterdemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void tt() {
        for (int i=0;i<100;i++) {
            int gender = new Random().nextInt(2);
            System.out.println(gender);
        }
    }

    @Test
    void contextLoads() {
        long stime = System.currentTimeMillis();
        String name = CreateNameUtils.getName();
        int age = new Random().nextInt(100);
        String phone = CreateMobileUtils.getMobilePhone();
        String gender = new Random().nextInt(2) + "";
        String address = CreateAddressUtils.getAddress();
        Date birthday = CreateDateUtils.getRandomDate("1950-01-01","2010-12-31");
        User user = new User()
                .setName(name)
                .setAge(age)
                .setGender(gender)
                .setPhone(phone)
                .setAddress(address)
                .setBirthday(birthday)
                .setCreateTime(new Date())
                .setModifyTime(new Date());
        long etime = System.currentTimeMillis();
        System.out.println("生成随机数据耗时："+(etime-stime));
        userDao.insertOne(user);
        long etime2 = System.currentTimeMillis();
        System.out.println("插入数据耗时："+(etime2-etime));
    }

    @Test
    void batchInsert() {
        long astime = System.currentTimeMillis();
        for(int j=0;j<1000;j++) {
            List<User> users = new ArrayList<>();
            long stime = System.currentTimeMillis();
            for(int i=0;i<1000;i++) {
                String name = CreateNameUtils.getName();
                int age = new Random().nextInt(100);
                String phone = CreateMobileUtils.getMobilePhone();
                String gender = new Random().nextInt(2) + "";
                String address = CreateAddressUtils.getAddress();
                Date birthday = CreateDateUtils.getRandomDate("1950-01-01","2010-12-31");
                User user = new User()
                        .setName(name)
                        .setAge(age)
                        .setGender(gender)
                        .setPhone(phone)
                        .setAddress(address)
                        .setBirthday(birthday)
                        .setCreateTime(new Date())
                        .setModifyTime(new Date());
                users.add(user);
            }
            long etime = System.currentTimeMillis();
            System.out.println("生成随机数据耗时："+(etime-stime));
            userDao.batchInsert(users);
            long etime2 = System.currentTimeMillis();
            System.out.println("插入数据耗时："+(etime2-etime));
        }
        System.out.println("插入数据总耗时："+(System.currentTimeMillis()-astime));
    }
}
