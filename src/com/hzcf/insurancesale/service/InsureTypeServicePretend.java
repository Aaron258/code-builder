package com.hzcf.insurancesale.service;

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
import com.hzcf.insurancesale.api.InsureTypeService;
import com.hzcf.insurancesale.bean.InsureType;

/**
 * @author
 */
@Service("insureTypeServicePretend")
public class InsureTypeServicePretend {

    private final static Logger logger = LoggerFactory.getLogger(InsureTypeServicePretend.class);

    @Autowired
    private InsureTypeService insureTypeService;

    /**
     * 新增或修改
     *
     * @param insureType
     */
    public ServiceResult<Object> save(InsureType insureType) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            insureType.setId(GeneratorKey.genaraId());
            insureTypeService.save(insureType);
            sr = ServiceTool.buildSuccessResult(insureType);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    /**
     * 修改
     *
     * @param insureType
     */
    public ServiceResult<Object> update(InsureType insureType) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            insureTypeService.update(insureType);
            sr = ServiceTool.buildSuccessResult(insureType);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }

    /**
     * 新增或修改
     *
     * @param insureType
     */
    public ServiceResult<Object> saveOrUpdate(InsureType insureType) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        if (null == insureType) {
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.PARAM_INVALID);
        }
        try {
            if (StringUtils.isBlank(insureType.getId())) {
                this.insureTypeService.save(insureType);
            } else {
                this.insureTypeService.update(insureType);
            }
            sr = ServiceTool.buildSuccessResult(insureType);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    public ServiceResult<InsureType> getById(String id) {
        try {
            InsureType insureType = insureTypeService.getById(id);
            return ServiceTool.buildSuccessResult(insureType);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }



    public ServiceResult<Object> deleteById(String id) {
        try {
            insureTypeService.deleteById(id);
            return ServiceTool.buildSuccessResult(null);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<List<InsureType>> list(InsureType insureType) {
        try {
            List<InsureType> list = insureTypeService.list(insureType);
            return ServiceTool.buildSuccessResult(list);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<PageResult<InsureType>> findPageByParam(InsureType insureType, PageParam pageParam) {
        try {
            PageResult<InsureType> pageResult = insureTypeService.findPageByParam(insureType, pageParam);
            return ServiceTool.buildSuccessResult(pageResult);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }

}
