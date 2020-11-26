package com.example.jmeterdemo.utils;

import java.util.Random;

public class CreateSubjectUtils {

    private static String[] subjectArr = new String[]{
            "语文","数学","英语","物理","化学","生物","历史","地理","政治"
    };

    public static String getSubject() {
        Integer random = new Random().nextInt(9);
        return subjectArr[random];
    }

}
