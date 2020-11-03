package com.example.jmeterdemo.utils;

import java.util.Random;

public class CreateAddressUtils {

    private static String[] regionName = {
            "罗湖区", "龙华区", "深汕特别合作区", "坪山区", "大鹏新区",
            "南山区", "大鹏新区", "龙岗区", "宝安区", "光明区",
            "盐田区", "前海蛇口自贸片", "福田区"
    };

    public static String getAddress() {
        int index = new Random().nextInt(regionName.length-1);
        return "广东省深圳市"+regionName[index];
    }

}
