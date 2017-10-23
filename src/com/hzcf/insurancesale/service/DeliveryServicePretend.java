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
import com.hzcf.insurancesale.api.DeliveryService;
import com.hzcf.insurancesale.bean.Delivery;

/**
 * @author
 */
@Service("deliveryServicePretend")
public class DeliveryServicePretend {

    private final static Logger logger = LoggerFactory.getLogger(DeliveryServicePretend.class);

    @Autowired
    private DeliveryService deliveryService;

    /**
     * 新增或修改
     *
     * @param delivery
     */
    public ServiceResult<Object> save(Delivery delivery) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            delivery.setId(GeneratorKey.genaraId());
            deliveryService.save(delivery);
            sr = ServiceTool.buildSuccessResult(delivery);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    /**
     * 修改
     *
     * @param delivery
     */
    public ServiceResult<Object> update(Delivery delivery) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            deliveryService.update(delivery);
            sr = ServiceTool.buildSuccessResult(delivery);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }

    /**
     * 新增或修改
     *
     * @param delivery
     */
    public ServiceResult<Object> saveOrUpdate(Delivery delivery) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        if (null == delivery) {
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.PARAM_INVALID);
        }
        try {
            if (StringUtils.isBlank(delivery.getId())) {
                this.deliveryService.save(delivery);
            } else {
                this.deliveryService.update(delivery);
            }
            sr = ServiceTool.buildSuccessResult(delivery);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    public ServiceResult<Delivery> getById(String id) {
        try {
            Delivery delivery = deliveryService.getById(id);
            return ServiceTool.buildSuccessResult(delivery);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }



    public ServiceResult<Object> deleteById(String id) {
        try {
            deliveryService.deleteById(id);
            return ServiceTool.buildSuccessResult(null);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<List<Delivery>> list(Delivery delivery) {
        try {
            List<Delivery> list = deliveryService.list(delivery);
            return ServiceTool.buildSuccessResult(list);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<PageResult<Delivery>> findPageByParam(Delivery delivery, PageParam pageParam) {
        try {
            PageResult<Delivery> pageResult = deliveryService.findPageByParam(delivery, pageParam);
            return ServiceTool.buildSuccessResult(pageResult);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }

}
