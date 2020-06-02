package com.mtcarpenter.mall.service.impl;

import com.mtcarpenter.mall.service.UmsRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UmsRoleServiceImplTest extends UmsAdminServiceImplTest{
    @Autowired
    private UmsRoleService umsRoleService;


    @Test
    public void list() {
        umsRoleService.list("商品分类管理员",0,10);
    }

    @Test
    public void listMenu() {
       System.out.println( umsRoleService.getMenuList(1L));
    }
}