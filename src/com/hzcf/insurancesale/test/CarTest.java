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
import com.hzcf.insurancesale.api.CarService;
import com.hzcf.insurancesale.bean.Car;
@Ignore
public class CarTest extends SpringConfigLoader {

	private final static Logger logger = LoggerFactory.getLogger(CarTest.class); 
	
	@Resource
   CarService carService;

	@Test
	public void saveTest() {
		Car car =new Car();
		car.setId("1");
		this.carService.save(car);
	}
	
	
	@Test
	public void updateTest() {
		Car car =new Car();
		car.setId("1");
		this.carService.update(car);
	}
	
	@Test
	public void getByIdTest() {
		Car userdeom=this.carService.getById("1");
		logger.debug("id:"+userdeom.getId());
	}
	
	@Test
	public void listTest() {
		List<Car> userdemos=this.carService.list(null);
		logger.debug("userdemos.size:"+userdemos.size());
	}
	
	@Test
	public void findPageByParamTest() {
		PageParam pageParam=new PageParam();
		pageParam.setPageNo(1);
		pageParam.setPageSize(3);
		PageResult<Car> pageRes=this.carService.findPageByParam(null, pageParam);
		logger.debug("getPageNo:"+pageRes.getPageNo());
		logger.debug("getPageSize:"+pageRes.getPageSize());
		logger.debug("getTotalCount:"+pageRes.getTotalCount());
		logger.debug("getTotalPage:"+pageRes.getTotalPage());
		logger.debug("getList:"+pageRes.getList().size());
	}
	
	@Test
	public void deleteByIdTest() {
		this.carService.deleteById("1");
		logger.debug("deleteById end!");
	}
	

}
