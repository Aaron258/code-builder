package ${packageName};

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zgg.common.code.ErrCodeE;
import com.zgg.common.exception.BusinessException;
import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import com.zgg.service.demo.user.api.${domainObjectName}Service;
import com.zgg.service.demo.user.bean.${domainObjectName};
import com.zgg.service.demo.user.bean.${domainObjectName}Example;
import com.zgg.service.demo.user.bean.${domainObjectName}Example.Criteria;
import com.zgg.service.demo.user.dao.${domainObjectName}Mapper;


@Service("${domainObjectNameLower}Service")
public class ${domainObjectName}ServiceImpl implements ${domainObjectName}Service {

    private final static Logger logger = LoggerFactory.getLogger(${domainObjectName}ServiceImpl.class);

    @Resource
    private ${domainObjectName}Mapper ${domainObjectNameLower}Mapper;


    @Override
    public void save(${domainObjectName} ${domainObjectNameLower}) {
        if (null == ${domainObjectNameLower}) {
            throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
        }
        this.${domainObjectNameLower}Mapper.insertSelective(${domainObjectNameLower});
    }

    @Override
    public void update(${domainObjectName} ${domainObjectNameLower}) {
        if (null == ${domainObjectNameLower}) {
            throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
        }
        this.${domainObjectNameLower}Mapper.updateByPrimaryKeySelective(${domainObjectNameLower});
    }

    @Override
    public ${domainObjectName} getById(String id) {
        return ${domainObjectNameLower}Mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<${domainObjectName}> list(${domainObjectName} ${domainObjectNameLower}) {
        return this.list(${domainObjectNameLower}, null);
    }

    @Override
    public List<${domainObjectName}> list(${domainObjectName} ${domainObjectNameLower}, String orderByStr) {
     ${domainObjectName}Example example = new ${domainObjectName}Example();
        if (StringUtils.isNotBlank(orderByStr)) {
            example.setOrderByClause(orderByStr);
        }
        Criteria criteria = example.createCriteria();

        List<${domainObjectName}> ${domainObjectNameLower}List = this.${domainObjectNameLower}Mapper.selectByExample(example);
        return ${domainObjectNameLower}List;
    }

    @Override
    public PageResult<${domainObjectName}> findPageByParam(${domainObjectName} ${domainObjectNameLower}, PageParam pageParam) {
        return this.findPageByParam(${domainObjectNameLower}, pageParam, null);
    }

    @Override
    public PageResult<${domainObjectName}> findPageByParam(${domainObjectName} ${domainObjectNameLower}, PageParam pageParam, String orderByStr) {
        PageResult<${domainObjectName}> pageResult = new PageResult<${domainObjectName}>();

        ${domainObjectName}Example example = new ${domainObjectName}Example();
        if (StringUtils.isNotBlank(orderByStr)) {
            example.setOrderByClause(orderByStr);
        }
        Criteria criteria = example.createCriteria();
        PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
        List<${domainObjectName}> list = ${domainObjectNameLower}Mapper.selectByExample(example);
        //兼容分页和不分页
        pageResult = PageResult.toPage(list);
        return pageResult;
    }

    @Override
    public void deleteById(String id) {
        this.${domainObjectNameLower}Mapper.deleteByPrimaryKey(id);
    }

}
