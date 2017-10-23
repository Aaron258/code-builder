package ${packageName};

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import com.zgg.demo.test.SpringConfigLoader;
import com.zgg.demo.user.api.${domainObjectName}Service;
import com.zgg.demo.user.bean.${domainObjectName};

public class ${domainObjectName}Test extends SpringConfigLoader {

	private final static Logger logger = LoggerFactory.getLogger(${domainObjectName}Test.class); 
	
	@Resource
   ${domainObjectName}Service ${domainObjectNameLower}Service;

	//@Test
	//@Ignore
	public void saveTest() {
		${domainObjectName} ${domainObjectNameLower} =new ${domainObjectName}();
		${domainObjectNameLower}.setId("1");
		this.${domainObjectNameLower}Service.save(${domainObjectNameLower});
	}
	
	
	//@Test
	//@Ignore
	public void updateTest() {
		${domainObjectName} ${domainObjectNameLower} =new ${domainObjectName}();
		${domainObjectNameLower}.setId("1");
		this.${domainObjectNameLower}Service.update(${domainObjectNameLower});
	}
	
	//@Test
	//@Ignore
	public void getByIdTest() {
		${domainObjectName} userdeom=this.${domainObjectNameLower}Service.getById("1");
		logger.debug("id:"+userdeom.getId());
	}
	
	//@Test
	//@Ignore
	public void listTest() {
		List<${domainObjectName}> userdemos=this.${domainObjectNameLower}Service.list(null);
		logger.debug("userdemos.size:"+userdemos.size());
	}
	
	//@Test
	//@Ignore
	public void findPageByParamTest() {
		PageParam pageParam=new PageParam();
		pageParam.setPageNo(1);
		pageParam.setPageSize(3);
		PageResult<${domainObjectName}> pageRes=this.${domainObjectNameLower}Service.findPageByParam(null, pageParam);
		logger.debug("getPageNo:"+pageRes.getPageNo());
		logger.debug("getPageSize:"+pageRes.getPageSize());
		logger.debug("getTotalCount:"+pageRes.getTotalCount());
		logger.debug("getTotalPage:"+pageRes.getTotalPage());
		logger.debug("getList:"+pageRes.getList().size());
	}
	
	//@Test
	//@Ignore
	public void deleteByIdTest() {
		this.${domainObjectNameLower}Service.deleteById("1");
		logger.debug("deleteById end!");
	}
	

}
