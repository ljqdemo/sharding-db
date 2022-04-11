package com.example.shardingdb.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author 罗集强
 * @Date 2022/4/7 14:30
 */
@Data
public class ProductInfo implements Serializable {

    private Long productInfoId;

    private Long storeInfoId;

    private String productName;

    private String spec;

    private String regionCode;

    private BigDecimal price;

    private String image_url;
}
