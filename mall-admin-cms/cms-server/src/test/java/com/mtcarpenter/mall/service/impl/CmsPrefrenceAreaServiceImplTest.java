package com.mtcarpenter.mall.service.impl;

import com.mtcarpenter.mall.service.CmsPrefrenceAreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPrefrenceAreaServiceImplTest {


    @Autowired
    private CmsPrefrenceAreaService cmsPrefrenceAreaService;

    @Test
    public void listAll() {
        System.out.println(cmsPrefrenceAreaService.listAll());

    }
}