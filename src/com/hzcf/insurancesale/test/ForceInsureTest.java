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
import com.hzcf.insurancesale.api.ForceInsureService;
import com.hzcf.insurancesale.bean.ForceInsure;
@Ignore
public class ForceInsureTest extends SpringConfigLoader {

	private final static Logger logger = LoggerFactory.getLogger(ForceInsureTest.class); 
	
	@Resource
   ForceInsureService forceInsureService;

	@Test
	public void saveTest() {
		ForceInsure forceInsure =new ForceInsure();
		forceInsure.setId("1");
		this.forceInsureService.save(forceInsure);
	}
	
	
	@Test
	public void updateTest() {
		ForceInsure forceInsure =new ForceInsure();
		forceInsure.setId("1");
		this.forceInsureService.update(forceInsure);
	}
	
	@Test
	public void getByIdTest() {
		ForceInsure userdeom=this.forceInsureService.getById("1");
		logger.debug("id:"+userdeom.getId());
	}
	
	@Test
	public void listTest() {
		List<ForceInsure> userdemos=this.forceInsureService.list(null);
		logger.debug("userdemos.size:"+userdemos.size());
	}
	
	@Test
	public void findPageByParamTest() {
		PageParam pageParam=new PageParam();
		pageParam.setPageNo(1);
		pageParam.setPageSize(3);
		PageResult<ForceInsure> pageRes=this.forceInsureService.findPageByParam(null, pageParam);
		logger.debug("getPageNo:"+pageRes.getPageNo());
		logger.debug("getPageSize:"+pageRes.getPageSize());
		logger.debug("getTotalCount:"+pageRes.getTotalCount());
		logger.debug("getTotalPage:"+pageRes.getTotalPage());
		logger.debug("getList:"+pageRes.getList().size());
	}
	
	@Test
	public void deleteByIdTest() {
		this.forceInsureService.deleteById("1");
		logger.debug("deleteById end!");
	}
	

}
