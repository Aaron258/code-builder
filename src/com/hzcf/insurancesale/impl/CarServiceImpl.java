package com.hzcf.insurancesale.impl;

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
import com.hzcf.insurancesale.api.CarService;
import com.hzcf.insurancesale.bean.Car;
import com.hzcf.insurancesale.bean.CarExample;
import com.hzcf.insurancesale.bean.CarExample.Criteria;
import com.hzcf.insurancesale.dao.CarMapper;


@Service("carService")
public class CarServiceImpl implements CarService {

	private final static Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

	@Resource
	private CarMapper carMapper;


	@Override
	public void save(Car car) {
		if (null == car) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.carMapper.insertSelective(car);
	}

	@Override
	public void update(Car car) {
		if (null == car) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.carMapper.updateByPrimaryKeySelective(car);
	}

	@Override
	public Car getById(String id) {
		return carMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Car> list(Car car) {
		return this.list(car, null);
	}

	@Override
	public List<Car> list(Car car, String orderByStr) {
		CarExample example = new CarExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<Car> carList = this.carMapper.selectByExample(example);
		return carList;
	}

	@Override
	public PageResult<Car> findPageByParam(Car car, PageParam pageParam) {
		return this.findPageByParam(car, pageParam, null);
	}

	@Override
	public PageResult<Car> findPageByParam(Car car, PageParam pageParam, String orderByStr) {
		PageResult<Car> pageResult = new PageResult<Car>();

		CarExample example = new CarExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<Car> list = carMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.carMapper.deleteByPrimaryKey(id);
	}

}
