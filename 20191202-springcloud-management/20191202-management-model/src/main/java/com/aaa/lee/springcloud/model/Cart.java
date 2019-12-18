package com.aaa.lee.springcloud.model;

import java.io.Serializable;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/5 17:10
 * @Description
 **/
public class Cart implements Serializable {

    private Long id;
    private String goodsName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
