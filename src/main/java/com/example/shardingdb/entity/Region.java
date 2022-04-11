package com.example.shardingdb.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author 罗集强
 * @Date 2022/4/7 14:35
 */
@Data
@ToString
public class Region implements Serializable {
    private Long id;

    private String regionCode;

    private String regionName;

    private Integer level;

    private String parentRegionCode;
}
