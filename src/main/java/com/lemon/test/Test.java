package com.lemon.test;

import com.lemon.pojo.Product;
import com.lemon.util.PuPuUtil;

import java.io.IOException;

public class Test {
    /**
     *@ClassName Test测试类
     *@Description
     *@Author lemon
     *@Date 10:23 2022/3/19
     *@Version 2.1
     **/
    public static void main(String[] args) throws IOException, InterruptedException {
        PuPuUtil PuPuUtil = new PuPuUtil();
        PuPuUtil.showProduct();
        PuPuUtil.realTimeMonitoring();
    }
}
