package com.hzcf.insurancesale.test;

import java.util.List;
import javax.annotation.Resource;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import com.zgg.demo.test.SpringConfigLoader;
import com.hzcf.insurancesale.api.DeliveryService;
import com.hzcf.insurancesale.bean.Delivery;
@Ignore
public class DeliveryTest extends SpringConfigLoader {

	private final static Logger logger = LoggerFactory.getLogger(DeliveryTest.class); 
	
	@Resource
   DeliveryService deliveryService;

	@Test
	public void saveTest() {
		Delivery delivery =new Delivery();
		delivery.setId("1");
		this.deliveryService.save(delivery);
	}
	
	
	@Test
	public void updateTest() {
		Delivery delivery =new Delivery();
		delivery.setId("1");
		this.deliveryService.update(delivery);
	}
	
	@Test
	public void getByIdTest() {
		Delivery userdeom=this.deliveryService.getById("1");
		logger.debug("id:"+userdeom.getId());
	}
	
	@Test
	public void listTest() {
		List<Delivery> userdemos=this.deliveryService.list(null);
		logger.debug("userdemos.size:"+userdemos.size());
	}
	
	@Test
	public void findPageByParamTest() {
		PageParam pageParam=new PageParam();
		pageParam.setPageNo(1);
		pageParam.setPageSize(3);
		PageResult<Delivery> pageRes=this.deliveryService.findPageByParam(null, pageParam);
		logger.debug("getPageNo:"+pageRes.getPageNo());
		logger.debug("getPageSize:"+pageRes.getPageSize());
		logger.debug("getTotalCount:"+pageRes.getTotalCount());
		logger.debug("getTotalPage:"+pageRes.getTotalPage());
		logger.debug("getList:"+pageRes.getList().size());
	}
	
	@Test
	public void deleteByIdTest() {
		this.deliveryService.deleteById("1");
		logger.debug("deleteById end!");
	}
	

}
