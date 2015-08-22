package com.maplookup.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.maplookup.db.domain.Zipcodes;
import com.maplookup.exception.MaplookupException;
import com.maploopup.service.ZipcodesService;

public class MaplookupServiceTest {

	ApplicationContext context;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }

    @Test
    public void test() throws MaplookupException {
        ZipcodesService zipCodesService = (ZipcodesService) context.getAutowireCapableBeanFactory().getBean(
                "zipcodesService");
        
        System.out.println(zipCodesService.findZipCodesById( "10001" ).getCity());
        assertEquals(zipCodesService.findZipCodesById( "10001" ).getCity(),"New York");
    }
	
}
