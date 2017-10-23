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
import com.hzcf.insurancesale.api.BusinessInsureService;
import com.hzcf.insurancesale.bean.BusinessInsure;

/**
 * @author
 */
@Service("businessInsureServicePretend")
public class BusinessInsureServicePretend {

    private final static Logger logger = LoggerFactory.getLogger(BusinessInsureServicePretend.class);

    @Autowired
    private BusinessInsureService businessInsureService;

    /**
     * 新增或修改
     *
     * @param businessInsure
     */
    public ServiceResult<Object> save(BusinessInsure businessInsure) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            businessInsure.setId(GeneratorKey.genaraId());
            businessInsureService.save(businessInsure);
            sr = ServiceTool.buildSuccessResult(businessInsure);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    /**
     * 修改
     *
     * @param businessInsure
     */
    public ServiceResult<Object> update(BusinessInsure businessInsure) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            businessInsureService.update(businessInsure);
            sr = ServiceTool.buildSuccessResult(businessInsure);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }

    /**
     * 新增或修改
     *
     * @param businessInsure
     */
    public ServiceResult<Object> saveOrUpdate(BusinessInsure businessInsure) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        if (null == businessInsure) {
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.PARAM_INVALID);
        }
        try {
            if (StringUtils.isBlank(businessInsure.getId())) {
                this.businessInsureService.save(businessInsure);
            } else {
                this.businessInsureService.update(businessInsure);
            }
            sr = ServiceTool.buildSuccessResult(businessInsure);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    public ServiceResult<BusinessInsure> getById(String id) {
        try {
            BusinessInsure businessInsure = businessInsureService.getById(id);
            return ServiceTool.buildSuccessResult(businessInsure);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }



    public ServiceResult<Object> deleteById(String id) {
        try {
            businessInsureService.deleteById(id);
            return ServiceTool.buildSuccessResult(null);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<List<BusinessInsure>> list(BusinessInsure businessInsure) {
        try {
            List<BusinessInsure> list = businessInsureService.list(businessInsure);
            return ServiceTool.buildSuccessResult(list);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<PageResult<BusinessInsure>> findPageByParam(BusinessInsure businessInsure, PageParam pageParam) {
        try {
            PageResult<BusinessInsure> pageResult = businessInsureService.findPageByParam(businessInsure, pageParam);
            return ServiceTool.buildSuccessResult(pageResult);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }

}
