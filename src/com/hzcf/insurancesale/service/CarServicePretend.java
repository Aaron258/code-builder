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
import com.hzcf.insurancesale.api.CarService;
import com.hzcf.insurancesale.bean.Car;

/**
 * @author
 */
@Service("carServicePretend")
public class CarServicePretend {

    private final static Logger logger = LoggerFactory.getLogger(CarServicePretend.class);

    @Autowired
    private CarService carService;

    /**
     * 新增或修改
     *
     * @param car
     */
    public ServiceResult<Object> save(Car car) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            car.setId(GeneratorKey.genaraId());
            carService.save(car);
            sr = ServiceTool.buildSuccessResult(car);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    /**
     * 修改
     *
     * @param car
     */
    public ServiceResult<Object> update(Car car) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        try {
            carService.update(car);
            sr = ServiceTool.buildSuccessResult(car);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }

    /**
     * 新增或修改
     *
     * @param car
     */
    public ServiceResult<Object> saveOrUpdate(Car car) {
        ServiceResult<Object> sr = new ServiceResult<Object>();
        if (null == car) {
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.PARAM_INVALID);
        }
        try {
            if (StringUtils.isBlank(car.getId())) {
                this.carService.save(car);
            } else {
                this.carService.update(car);
            }
            sr = ServiceTool.buildSuccessResult(car);
        } catch (Exception e) {
            logger.error("error", e);
            sr = ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
        return sr;
    }


    public ServiceResult<Car> getById(String id) {
        try {
            Car car = carService.getById(id);
            return ServiceTool.buildSuccessResult(car);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }



    public ServiceResult<Object> deleteById(String id) {
        try {
            carService.deleteById(id);
            return ServiceTool.buildSuccessResult(null);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<List<Car>> list(Car car) {
        try {
            List<Car> list = carService.list(car);
            return ServiceTool.buildSuccessResult(list);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }


    public ServiceResult<PageResult<Car>> findPageByParam(Car car, PageParam pageParam) {
        try {
            PageResult<Car> pageResult = carService.findPageByParam(car, pageParam);
            return ServiceTool.buildSuccessResult(pageResult);
        } catch (Exception e) {
            logger.error("error", e);
            return ServiceTool.buildBusinessFailResult(ErrCodeE.DB_ERROR);
        }
    }

}
