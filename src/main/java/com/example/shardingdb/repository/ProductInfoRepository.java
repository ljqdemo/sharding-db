package com.example.shardingdb.repository;

import com.example.shardingdb.bo.ProductBO;
import com.example.shardingdb.entity.ProductInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author 罗集强
 * @Date 2022/4/7 14:39
 */
@Mapper
public interface ProductInfoRepository {

    /**
     * 添加基本信息
     * @param productInfo
     * @return
     */
    @Insert("insert into product_info(store_info_id,product_name,spec,region_code,price,product_info_id) value(#{storeInfoId},#{productName},#{spec},#{regionCode},#{price},#{productInfoId})")
    @Options(useGeneratedKeys = true,keyProperty = "productInfoId",keyColumn = "id")
    int insertProductInfo(ProductInfo productInfo);




    @Select("SELECT s.id,s.store_name,p.product_name,p.price,p.image_url FROM  store_info s " +
            "LEFT JOIN product_info p ON (s.id=p.store_info_id)")
    List<ProductInfo> getAllProuct();

    @Select("SELECT pd.id,pd.descript,p.product_name,p.price,p.image_url FROM  product_info p " +
            "LEFT JOIN product_descript pd ON (p.product_info_id=p.product_info_id)")
    List<ProductBO> getAllProuctInfo();

    @Select("SELECT pd.id,pd.descript,p.product_name,p.price,p.image_url FROM  product_info p " +
            "LEFT JOIN product_descript pd ON (p.product_info_id=p.product_info_id)" +
            "WHERE pd.product_info_id=#{productInfoId}")
    List<ProductBO> getAllProuctInfoById(@Param("productInfoId") Long id );

    
    @Select("SELECT pd.id,pd.descript,p.product_name,p.price,p.image_url FROM  product_info p " +
            "LEFT JOIN product_descript pd ON (p.product_info_id=p.product_info_id)" +
            "WHERE pd.product_info_id=#{productInfoId} and " +
            "pd.store_info_id=#{StoreId}")
    List<ProductBO> getAllProuctInfoByIdAndStoreId(@Param("productInfoId") Long id,@Param("StoreId") Long storeId );
}
