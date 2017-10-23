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
import com.hzcf.insurancesale.api.CarInsurePolicyService;
import com.hzcf.insurancesale.bean.CarInsurePolicy;

/**
 * @author
 */
@Service("carInsurePolicyServicePretend")
public class CarInsurePolicyServicePretend {

    private final static Logger logger = LoggerFactory.getLogger(CarInsurePolicyServicePretend.class);

    @Autowired
    private CarInsurePolicyService carInsurePolicyService;

    /**
     * 新增或修改
     *
     * @param carInsurePolicy
     */
    public ServiceResult<Object> save(CarInsurePolicy carInsurePolicy) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            carInsurePolicy.setId(GeneratorKey.genaraId());
            carInsurePolicyService.save(carInsurePolicy);
            sr = ServiceTool.buildSuccessResult(carInsurePolicy);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    /**
     * 修改
     *
     * @param carInsurePolicy
     */
    public ServiceResult<Object> update(CarInsurePolicy carInsurePolicy) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            carInsurePolicyService.update(carInsurePolicy);
            sr = ServiceTool.buildSuccessResult(carInsurePolicy);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }

    /**
     * 新增或修改
     *
     * @param carInsurePolicy
     */
    public ServiceResult<Object> saveOrUpdate(CarInsurePolicy carInsurePolicy) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        if (null == carInsurePolicy) {
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.PARAM_INVALID);
        }
        try {
            if (StringUtils.isBlank(carInsurePolicy.getId())) {
                this.carInsurePolicyService.save(carInsurePolicy);
            } else {
                this.carInsurePolicyService.update(carInsurePolicy);
            }
            sr = ServiceTool.buildSuccessResult(carInsurePolicy);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    public ServiceResult<CarInsurePolicy> getById(String id) {
        try {
            CarInsurePolicy carInsurePolicy = carInsurePolicyService.getById(id);
            return ServiceTool.buildSuccessResult(carInsurePolicy);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }



    public ServiceResult<Object> deleteById(String id) {
        try {
            carInsurePolicyService.deleteById(id);
            return ServiceTool.buildSuccessResult(null);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<List<CarInsurePolicy>> list(CarInsurePolicy carInsurePolicy) {
        try {
            List<CarInsurePolicy> list = carInsurePolicyService.list(carInsurePolicy);
            return ServiceTool.buildSuccessResult(list);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<PageResult<CarInsurePolicy>> findPageByParam(CarInsurePolicy carInsurePolicy, PageParam pageParam) {
        try {
            PageResult<CarInsurePolicy> pageResult = carInsurePolicyService.findPageByParam(carInsurePolicy, pageParam);
            return ServiceTool.buildSuccessResult(pageResult);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }

}
