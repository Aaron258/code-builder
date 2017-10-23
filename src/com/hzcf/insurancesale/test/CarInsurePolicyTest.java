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
import com.hzcf.insurancesale.api.CarInsurePolicyService;
import com.hzcf.insurancesale.bean.CarInsurePolicy;
@Ignore
public class CarInsurePolicyTest extends SpringConfigLoader {

	private final static Logger logger = LoggerFactory.getLogger(CarInsurePolicyTest.class); 
	
	@Resource
   CarInsurePolicyService carInsurePolicyService;

	@Test
	public void saveTest() {
		CarInsurePolicy carInsurePolicy =new CarInsurePolicy();
		carInsurePolicy.setId("1");
		this.carInsurePolicyService.save(carInsurePolicy);
	}
	
	
	@Test
	public void updateTest() {
		CarInsurePolicy carInsurePolicy =new CarInsurePolicy();
		carInsurePolicy.setId("1");
		this.carInsurePolicyService.update(carInsurePolicy);
	}
	
	@Test
	public void getByIdTest() {
		CarInsurePolicy userdeom=this.carInsurePolicyService.getById("1");
		logger.debug("id:"+userdeom.getId());
	}
	
	@Test
	public void listTest() {
		List<CarInsurePolicy> userdemos=this.carInsurePolicyService.list(null);
		logger.debug("userdemos.size:"+userdemos.size());
	}
	
	@Test
	public void findPageByParamTest() {
		PageParam pageParam=new PageParam();
		pageParam.setPageNo(1);
		pageParam.setPageSize(3);
		PageResult<CarInsurePolicy> pageRes=this.carInsurePolicyService.findPageByParam(null, pageParam);
		logger.debug("getPageNo:"+pageRes.getPageNo());
		logger.debug("getPageSize:"+pageRes.getPageSize());
		logger.debug("getTotalCount:"+pageRes.getTotalCount());
		logger.debug("getTotalPage:"+pageRes.getTotalPage());
		logger.debug("getList:"+pageRes.getList().size());
	}
	
	@Test
	public void deleteByIdTest() {
		this.carInsurePolicyService.deleteById("1");
		logger.debug("deleteById end!");
	}
	

}
