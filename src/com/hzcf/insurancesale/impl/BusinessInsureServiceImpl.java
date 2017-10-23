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
import com.hzcf.insurancesale.api.BusinessInsureService;
import com.hzcf.insurancesale.bean.BusinessInsure;
import com.hzcf.insurancesale.bean.BusinessInsureExample;
import com.hzcf.insurancesale.bean.BusinessInsureExample.Criteria;
import com.hzcf.insurancesale.dao.BusinessInsureMapper;


@Service("businessInsureService")
public class BusinessInsureServiceImpl implements BusinessInsureService {

	private final static Logger logger = LoggerFactory.getLogger(BusinessInsureServiceImpl.class);

	@Resource
	private BusinessInsureMapper businessInsureMapper;


	@Override
	public void save(BusinessInsure businessInsure) {
		if (null == businessInsure) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.businessInsureMapper.insertSelective(businessInsure);
	}

	@Override
	public void update(BusinessInsure businessInsure) {
		if (null == businessInsure) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.businessInsureMapper.updateByPrimaryKeySelective(businessInsure);
	}

	@Override
	public BusinessInsure getById(String id) {
		return businessInsureMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BusinessInsure> list(BusinessInsure businessInsure) {
		return this.list(businessInsure, null);
	}

	@Override
	public List<BusinessInsure> list(BusinessInsure businessInsure, String orderByStr) {
		BusinessInsureExample example = new BusinessInsureExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<BusinessInsure> businessInsureList = this.businessInsureMapper.selectByExample(example);
		return businessInsureList;
	}

	@Override
	public PageResult<BusinessInsure> findPageByParam(BusinessInsure businessInsure, PageParam pageParam) {
		return this.findPageByParam(businessInsure, pageParam, null);
	}

	@Override
	public PageResult<BusinessInsure> findPageByParam(BusinessInsure businessInsure, PageParam pageParam, String orderByStr) {
		PageResult<BusinessInsure> pageResult = new PageResult<BusinessInsure>();

		BusinessInsureExample example = new BusinessInsureExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<BusinessInsure> list = businessInsureMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.businessInsureMapper.deleteByPrimaryKey(id);
	}

}
