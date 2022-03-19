package com.lemon.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Product {
    /**
     *@ClassName Product
     *@Description
     *@Author lemon
     *@Date 10:09 2022/3/19
     *@Version 2.1
     **/
    private String name;
    private String spec;
    private Double price;
    private Double market_price;
    private String content;
}
