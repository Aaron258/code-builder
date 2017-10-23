package ${packageName};

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zgg.common.GeneratorKey;
import com.zgg.common.ServiceResult;
import com.zgg.common.ServiceTool;
import com.zgg.common.code.ErrCodeE;
import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import com.zgg.service.demo.user.api.${domainObjectName}Service;
import com.zgg.service.demo.user.bean.${domainObjectName};

/**
 * @author
 */
@Service("${domainObjectNameLower}ServicePretend")
public class ${domainObjectName}ServicePretend {

    private final static Logger logger = LoggerFactory.getLogger(${domainObjectName}ServicePretend.class);

    @Autowired
    private ${domainObjectName}Service ${domainObjectNameLower}Service;

    /**
     * 新增或修改
     *
     * @param ${domainObjectNameLower}
     */
    public ServiceResult<Object> save(${domainObjectName} ${domainObjectNameLower}) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            ${domainObjectNameLower}.setId(GeneratorKey.genaraId());
            ${domainObjectNameLower}Service.save(${domainObjectNameLower});
            sr = ServiceTool.buildSuccessResult(${domainObjectNameLower});
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    /**
     * 修改
     *
     * @param ${domainObjectNameLower}
     */
    public ServiceResult<Object> update(${domainObjectName} ${domainObjectNameLower}) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            ${domainObjectNameLower}Service.update(${domainObjectNameLower});
            sr = ServiceTool.buildSuccessResult(${domainObjectNameLower});
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }

    /**
     * 新增或修改
     *
     * @param ${domainObjectNameLower}
     */
    public ServiceResult<Object> saveOrUpdate(${domainObjectName} ${domainObjectNameLower}) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        if (null == ${domainObjectNameLower}) {
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.PARAM_INVALID);
        }
        try {
            if (StringUtils.isBlank(${domainObjectNameLower}.getId())) {
                this.${domainObjectNameLower}Service.save(${domainObjectNameLower});
            } else {
                this.${domainObjectNameLower}Service.update(${domainObjectNameLower});
            }
            sr = ServiceTool.buildSuccessResult(${domainObjectNameLower});
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    public ServiceResult<${domainObjectName}> getById(String id) {
        try {
            ${domainObjectName} ${domainObjectNameLower} = ${domainObjectNameLower}Service.getById(id);
            return ServiceTool.buildSuccessResult(${domainObjectNameLower});
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }



    public ServiceResult<Object> deleteById(String id) {
        try {
            ${domainObjectNameLower}Service.deleteById(id);
            return ServiceTool.buildSuccessResult(null);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<List<${domainObjectName}>> list(${domainObjectName} ${domainObjectNameLower}) {
        try {
            List<${domainObjectName}> list = ${domainObjectNameLower}Service.list(${domainObjectNameLower});
            return ServiceTool.buildSuccessResult(list);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<PageResult<${domainObjectName}>> findPageByParam(${domainObjectName} ${domainObjectNameLower}, PageParam pageParam) {
        try {
            PageResult<${domainObjectName}> pageResult = ${domainObjectNameLower}Service.findPageByParam(${domainObjectNameLower}, pageParam);
            return ServiceTool.buildSuccessResult(pageResult);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }

}
