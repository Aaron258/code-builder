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
import com.hzcf.insurancesale.api.CarInsurePolicyService;
import com.hzcf.insurancesale.bean.CarInsurePolicy;
import com.hzcf.insurancesale.bean.CarInsurePolicyExample;
import com.hzcf.insurancesale.bean.CarInsurePolicyExample.Criteria;
import com.hzcf.insurancesale.dao.CarInsurePolicyMapper;


@Service("carInsurePolicyService")
public class CarInsurePolicyServiceImpl implements CarInsurePolicyService {

	private final static Logger logger = LoggerFactory.getLogger(CarInsurePolicyServiceImpl.class);

	@Resource
	private CarInsurePolicyMapper carInsurePolicyMapper;


	@Override
	public void save(CarInsurePolicy carInsurePolicy) {
		if (null == carInsurePolicy) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.carInsurePolicyMapper.insertSelective(carInsurePolicy);
	}

	@Override
	public void update(CarInsurePolicy carInsurePolicy) {
		if (null == carInsurePolicy) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.carInsurePolicyMapper.updateByPrimaryKeySelective(carInsurePolicy);
	}

	@Override
	public CarInsurePolicy getById(String id) {
		return carInsurePolicyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<CarInsurePolicy> list(CarInsurePolicy carInsurePolicy) {
		return this.list(carInsurePolicy, null);
	}

	@Override
	public List<CarInsurePolicy> list(CarInsurePolicy carInsurePolicy, String orderByStr) {
		CarInsurePolicyExample example = new CarInsurePolicyExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<CarInsurePolicy> carInsurePolicyList = this.carInsurePolicyMapper.selectByExample(example);
		return carInsurePolicyList;
	}

	@Override
	public PageResult<CarInsurePolicy> findPageByParam(CarInsurePolicy carInsurePolicy, PageParam pageParam) {
		return this.findPageByParam(carInsurePolicy, pageParam, null);
	}

	@Override
	public PageResult<CarInsurePolicy> findPageByParam(CarInsurePolicy carInsurePolicy, PageParam pageParam, String orderByStr) {
		PageResult<CarInsurePolicy> pageResult = new PageResult<CarInsurePolicy>();

		CarInsurePolicyExample example = new CarInsurePolicyExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<CarInsurePolicy> list = carInsurePolicyMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.carInsurePolicyMapper.deleteByPrimaryKey(id);
	}

}
