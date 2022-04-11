package com.example.shardingdb.repository;

import com.example.shardingdb.entity.StoreInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 罗集强
 * @Date 2022/4/7 14:39
 */
@Mapper
public interface StoreInfoRepository {
    @Insert("insert into store_info (id,store_name,reputation,region_code) values(#{id},#{storeName},#{reputation},#{regionCode}) ")
     int insertStore(StoreInfo storeInfo);
}
