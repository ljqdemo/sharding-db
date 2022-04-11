package com.example.shardingdb.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author 罗集强
 * @Date 2022/4/7 14:33
 */
@Data
@ToString
public class ProductDescript implements Serializable {
    private Long id;

    private Long productInfoId;

    private Long storeInfoId;

    private String descript;


}
