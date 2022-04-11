package com.example.shardingdb.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 罗集强
 * @Date 2022/4/7 14:37
 */
@Data
public class StoreInfo implements Serializable {
    private Long id ;

    private String storeName;

    private String regionCode;
    /**
     * 信誉等级
     */
    private Long reputation;
}
