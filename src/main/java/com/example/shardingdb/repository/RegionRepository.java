package com.example.shardingdb.repository;

import com.example.shardingdb.entity.Region;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author 罗集强
 * @Date 2022/4/7 14:39
 */
@Mapper
public interface RegionRepository {

    @Insert("insert into region (id,region_code,region_name,`level`,parent_region_code)" +
            "values (#{id},#{regionCode},#{regionName},#{level},#{parentRegionCode})")
    void insertRegion(Region region);


    @Select("select * from region where id=#{id}")
    Region selectById(@Param("id") Long id);
}
