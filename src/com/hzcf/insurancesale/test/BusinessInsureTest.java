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
import com.hzcf.insurancesale.api.BusinessInsureService;
import com.hzcf.insurancesale.bean.BusinessInsure;
@Ignore
public class BusinessInsureTest extends SpringConfigLoader {

	private final static Logger logger = LoggerFactory.getLogger(BusinessInsureTest.class); 
	
	@Resource
   BusinessInsureService businessInsureService;

	@Test
	public void saveTest() {
		BusinessInsure businessInsure =new BusinessInsure();
		businessInsure.setId("1");
		this.businessInsureService.save(businessInsure);
	}
	
	
	@Test
	public void updateTest() {
		BusinessInsure businessInsure =new BusinessInsure();
		businessInsure.setId("1");
		this.businessInsureService.update(businessInsure);
	}
	
	@Test
	public void getByIdTest() {
		BusinessInsure userdeom=this.businessInsureService.getById("1");
		logger.debug("id:"+userdeom.getId());
	}
	
	@Test
	public void listTest() {
		List<BusinessInsure> userdemos=this.businessInsureService.list(null);
		logger.debug("userdemos.size:"+userdemos.size());
	}
	
	@Test
	public void findPageByParamTest() {
		PageParam pageParam=new PageParam();
		pageParam.setPageNo(1);
		pageParam.setPageSize(3);
		PageResult<BusinessInsure> pageRes=this.businessInsureService.findPageByParam(null, pageParam);
		logger.debug("getPageNo:"+pageRes.getPageNo());
		logger.debug("getPageSize:"+pageRes.getPageSize());
		logger.debug("getTotalCount:"+pageRes.getTotalCount());
		logger.debug("getTotalPage:"+pageRes.getTotalPage());
		logger.debug("getList:"+pageRes.getList().size());
	}
	
	@Test
	public void deleteByIdTest() {
		this.businessInsureService.deleteById("1");
		logger.debug("deleteById end!");
	}
	

}
