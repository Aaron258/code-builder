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
import com.hzcf.insurancesale.api.ForceInsureService;
import com.hzcf.insurancesale.bean.ForceInsure;

/**
 * @author
 */
@Service("forceInsureServicePretend")
public class ForceInsureServicePretend {

    private final static Logger logger = LoggerFactory.getLogger(ForceInsureServicePretend.class);

    @Autowired
    private ForceInsureService forceInsureService;

    /**
     * 新增或修改
     *
     * @param forceInsure
     */
    public ServiceResult<Object> save(ForceInsure forceInsure) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            forceInsure.setId(GeneratorKey.genaraId());
            forceInsureService.save(forceInsure);
            sr = ServiceTool.buildSuccessResult(forceInsure);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    /**
     * 修改
     *
     * @param forceInsure
     */
    public ServiceResult<Object> update(ForceInsure forceInsure) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            forceInsureService.update(forceInsure);
            sr = ServiceTool.buildSuccessResult(forceInsure);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }

    /**
     * 新增或修改
     *
     * @param forceInsure
     */
    public ServiceResult<Object> saveOrUpdate(ForceInsure forceInsure) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        if (null == forceInsure) {
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.PARAM_INVALID);
        }
        try {
            if (StringUtils.isBlank(forceInsure.getId())) {
                this.forceInsureService.save(forceInsure);
            } else {
                this.forceInsureService.update(forceInsure);
            }
            sr = ServiceTool.buildSuccessResult(forceInsure);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    public ServiceResult<ForceInsure> getById(String id) {
        try {
            ForceInsure forceInsure = forceInsureService.getById(id);
            return ServiceTool.buildSuccessResult(forceInsure);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }



    public ServiceResult<Object> deleteById(String id) {
        try {
            forceInsureService.deleteById(id);
            return ServiceTool.buildSuccessResult(null);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<List<ForceInsure>> list(ForceInsure forceInsure) {
        try {
            List<ForceInsure> list = forceInsureService.list(forceInsure);
            return ServiceTool.buildSuccessResult(list);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<PageResult<ForceInsure>> findPageByParam(ForceInsure forceInsure, PageParam pageParam) {
        try {
            PageResult<ForceInsure> pageResult = forceInsureService.findPageByParam(forceInsure, pageParam);
            return ServiceTool.buildSuccessResult(pageResult);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }

}
