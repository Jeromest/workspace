package com.song.test;

import com.song.service.BedService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void TestTms(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        BedService bedService = (BedService) ctx.getBean("bedService");
        bedService.getAll();

    }

}
