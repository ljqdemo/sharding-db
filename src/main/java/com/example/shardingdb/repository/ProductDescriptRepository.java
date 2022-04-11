package com.example.shardingdb.repository;

import com.example.shardingdb.entity.ProductDescript;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Author 罗集强
 * @Date 2022/4/7 14:39
 */
@Mapper
@Repository
public interface ProductDescriptRepository {

    //添加商品描述信息
    @Insert("insert into product_descript(product_info_id,descript,store_info_id) value(#{productInfoId},#{descript},#{storeInfoId})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insertProductDescript(ProductDescript productDescript);

    @Select("select  * from product_descript where id = #{id}")
    ProductDescript getById(@Param("id") Long id);

    @Select("select  * from product_descript where id = #{id} and product_info_id=#{productInfoId}")
    ProductDescript getByIdAndProductId(@Param("id")Long id, @Param("productInfoId")Long productInfoId);
}
