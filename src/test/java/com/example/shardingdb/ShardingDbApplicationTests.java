package com.example.shardingdb;

import com.example.shardingdb.bo.ProductBO;
import com.example.shardingdb.entity.ProductDescript;
import com.example.shardingdb.entity.ProductInfo;
import com.example.shardingdb.entity.Region;
import com.example.shardingdb.entity.StoreInfo;
import com.example.shardingdb.repository.ProductDescriptRepository;
import com.example.shardingdb.repository.ProductInfoRepository;
import com.example.shardingdb.repository.RegionRepository;
import com.example.shardingdb.repository.StoreInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ShardingDbApplicationTests {

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Autowired
	private ProductDescriptRepository productDescriptRepository;
	@Autowired
	private StoreInfoRepository storeInfoRepository;

	@Autowired
	private RegionRepository regionRepository;
	@Test
	void contextLoads() {
	}


	@Test
	void productTest() {
		//分库分表插入
		ProductInfo productInfo =new ProductInfo();
		productInfo.setImage_url("https://blog.csdn.net/sinat_32023305/article/details/80253107");
		productInfo.setPrice(new BigDecimal(123.99));
		productInfo.setProductName("商品1号");
		productInfo.setStoreInfoId(81L);
		productInfo.setRegionCode("110000");
		productInfo.setProductInfoId(25513651423L);
		productInfo.setSpec("商品2号的描述");
		int update = productInfoRepository.insertProductInfo(productInfo);
		System.out.println("update===="+update);
	}


	@Test
	void storeTest() {
		//分库分表插入
		StoreInfo storeInfo=new StoreInfo();
		storeInfo.setRegionCode("110000");
		storeInfo.setReputation(1L);
		storeInfo.setStoreName("我的店铺2");
		storeInfo.setId(14L);
		int update = storeInfoRepository.insertStore(storeInfo);
		System.out.println("StoreInfo  update===="+update);

	}
	@Test
	void productDescriptTest(){
		ProductDescript productDescript=new ProductDescript();
		productDescript.setProductInfoId(25513651423L);
		productDescript.setDescript("查询详情描述121112");
		productDescript.setStoreInfoId(82L);
		int update = productDescriptRepository.insertProductDescript(productDescript);
		System.out.println("ProductDescript  update===="+update);

		//分库分表单表查询
		ProductDescript result=productDescriptRepository.getById(productDescript.getId());
		System.out.println("result ====="+result.toString());

		ProductDescript result2=productDescriptRepository.getByIdAndProductId(productDescript.getId(),productDescript.getProductInfoId());
		System.out.println("result2 ====="+result2.toString());
	}
	@Test
	void regionTest(){
		//插入广播表数据
		Region region=new Region();
		region.setId(21L);
		region.setLevel(2);
		region.setParentRegionCode("4300");
		region.setRegionCode("4302");
		region.setRegionName("株洲");
		regionRepository.insertRegion(region);
		//查询广播表
		Region result=regionRepository.selectById(region.getId());
		System.out.println("region result ====="+result.toString());
	}

	@Test
	void uinTest(){
		//联合查询,店铺下所有的商品 不带分片键
		List<ProductBO> allProuctInfo = productInfoRepository.getAllProuctInfo();

		allProuctInfo.forEach(e->{
			System.out.println(e.toString());
		});
		//带分表分片键
		List<ProductBO> allProuctInfo2 = productInfoRepository.getAllProuctInfoById(25513651423L);
		System.out.println("===================================");
		allProuctInfo2.forEach(e->{
			System.out.println(e.toString());
		});
		//带分库以及分表分片键
		System.out.println("===================================");
		List<ProductBO> allProuctInfoByIdAndStoreId = productInfoRepository.getAllProuctInfoByIdAndStoreId(25513651423L, 82L);

		allProuctInfoByIdAndStoreId.forEach(e->{
			System.out.println(e.toString());
		});



		/*List<ProductInfo> allProuct = productInfoRepository.getAllProuct();
		if (CollectionUtils.isEmpty(allProuct)) {
			System.out.println("----------null---------");
		}else {
			allProuct.forEach(e->{
				System.out.println(e.toString());
			});
		}*/

	}

}
