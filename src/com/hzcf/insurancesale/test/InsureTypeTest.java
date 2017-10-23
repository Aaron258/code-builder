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
import com.hzcf.insurancesale.api.InsureTypeService;
import com.hzcf.insurancesale.bean.InsureType;
@Ignore
public class InsureTypeTest extends SpringConfigLoader {

	private final static Logger logger = LoggerFactory.getLogger(InsureTypeTest.class); 
	
	@Resource
   InsureTypeService insureTypeService;

	@Test
	public void saveTest() {
		InsureType insureType =new InsureType();
		insureType.setId("1");
		this.insureTypeService.save(insureType);
	}
	
	
	@Test
	public void updateTest() {
		InsureType insureType =new InsureType();
		insureType.setId("1");
		this.insureTypeService.update(insureType);
	}
	
	@Test
	public void getByIdTest() {
		InsureType userdeom=this.insureTypeService.getById("1");
		logger.debug("id:"+userdeom.getId());
	}
	
	@Test
	public void listTest() {
		List<InsureType> userdemos=this.insureTypeService.list(null);
		logger.debug("userdemos.size:"+userdemos.size());
	}
	
	@Test
	public void findPageByParamTest() {
		PageParam pageParam=new PageParam();
		pageParam.setPageNo(1);
		pageParam.setPageSize(3);
		PageResult<InsureType> pageRes=this.insureTypeService.findPageByParam(null, pageParam);
		logger.debug("getPageNo:"+pageRes.getPageNo());
		logger.debug("getPageSize:"+pageRes.getPageSize());
		logger.debug("getTotalCount:"+pageRes.getTotalCount());
		logger.debug("getTotalPage:"+pageRes.getTotalPage());
		logger.debug("getList:"+pageRes.getList().size());
	}
	
	@Test
	public void deleteByIdTest() {
		this.insureTypeService.deleteById("1");
		logger.debug("deleteById end!");
	}
	

}
