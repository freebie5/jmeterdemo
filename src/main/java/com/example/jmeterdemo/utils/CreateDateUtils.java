package com.example.jmeterdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateDateUtils {

    public static void main(String[] args) {
        Date date = getRandomDate("2019-01-01","2020-11-01");
        System.out.println(date);
    }

    public static Date getRandomDate(String beginDate, String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if(start.getTime() >= end.getTime()){
                return null;
            }
            long date = random(start.getTime(),end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }

}
