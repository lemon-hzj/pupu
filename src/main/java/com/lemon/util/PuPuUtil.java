package com.lemon.util;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.lemon.pojo.Product;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;

public class PuPuUtil {
    /**
     *@ClassName PuPuUtil
     *@Description
     *@Author lemon
     *@Date 10:19 2022/3/19
     *@Version 2.1
     **/
    LinkedTreeMap data ;
    Product product = new Product();
    public void parsePuPu() throws IOException {
        String url="https://j1.pupuapi.com/client/product/storeproduct/detail/831b632e-12bd-4c23-a6fd-a18749d8d508/188d7a73-f518-418e-a928-e293f4b17556";
        Connection.Response res = Jsoup.connect(url)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .header("Content-Type", "application/json;charset=UTF-8")
                .timeout(10000).ignoreContentType(true).execute();
        //创建gson对象
        Gson gson = new Gson();
        //对获取到的数据进行转换
        HashMap hashMap = gson.fromJson(res.body(), HashMap.class);
        //获取data里面的值
        data = (LinkedTreeMap) hashMap.get("data");

        /* 获取数据封装到product中 */
        product.setName((String) data.get("name"));
        product.setSpec((String) data.get("spec"));
        product.setPrice((Double) data.get("price")/100);
        product.setMarket_price((Double) data.get("market_price")/100);
        product.setContent((String) data.get("share_content"));
    }

    public void showProduct() throws IOException {
        parsePuPu();
        //商品信息在控制台输出
        System.out.println("-----------------------商品："+product.getName()+"-----------------------");
        System.out.println("规格："+product.getSpec());
        System.out.println("价格："+product.getPrice());
        System.out.println("原价/折扣价："+product.getMarket_price()+"/"+product.getPrice());
        System.out.println("详细信息："+product.getContent());
        System.out.println("1");
    }

}
