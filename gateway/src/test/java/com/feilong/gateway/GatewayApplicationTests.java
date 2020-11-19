package com.feilong.gateway;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@SpringBootTest
public class GatewayApplicationTests {

    @Test
    public void contextLoads() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        String str = "2020-11-15";
        String string = "2020-11-16";
        String string1="2020-11-17";
//        Date parse = sdf.parse(string);
//        long time1 = parse.getTime();
        System.out.println(string.compareTo(format));
        System.out.println(string1.compareTo(format));
        System.out.println(str.compareTo(format));

//        System.out.println();
//        long time = date.getTime();


    }

}
