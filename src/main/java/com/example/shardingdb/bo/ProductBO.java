package com.example.shardingdb.bo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author 罗集强
 * @Date 2022/4/8 16:14
 */
@Data
@ToString
public class ProductBO implements Serializable {
    private Long productInfoId;

    private Long storeInfoId;

    private String productName;

    private String spec;

    private String regionCode;

    private BigDecimal price;

    private String image_url;

    private Long id ;

    private String storeName;

    /**
     * 信誉等级
     */
    private Long reputation;
}
