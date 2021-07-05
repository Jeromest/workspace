package com.song.test;

import com.song.pojo.Tms;
import com.song.service.BedService;
import com.song.service.TmsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

    @Test
    public void TestTms(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
//        TmsService tmsService = (TmsService) ctx.getBean("TmsService");
//        List<Tms> tmsList = new ArrayList<Tms>();
//        Tms tms = new Tms();

        BedService bedService = (BedService) ctx.getBean("BedService");
        bedService.getAll();

//        System.out.println(tmsService.getAll());

    }
}
