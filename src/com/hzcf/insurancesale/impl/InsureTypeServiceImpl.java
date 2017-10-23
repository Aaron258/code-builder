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
import com.hzcf.insurancesale.api.InsureTypeService;
import com.hzcf.insurancesale.bean.InsureType;
import com.hzcf.insurancesale.bean.InsureTypeExample;
import com.hzcf.insurancesale.bean.InsureTypeExample.Criteria;
import com.hzcf.insurancesale.dao.InsureTypeMapper;


@Service("insureTypeService")
public class InsureTypeServiceImpl implements InsureTypeService {

	private final static Logger logger = LoggerFactory.getLogger(InsureTypeServiceImpl.class);

	@Resource
	private InsureTypeMapper insureTypeMapper;


	@Override
	public void save(InsureType insureType) {
		if (null == insureType) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.insureTypeMapper.insertSelective(insureType);
	}

	@Override
	public void update(InsureType insureType) {
		if (null == insureType) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.insureTypeMapper.updateByPrimaryKeySelective(insureType);
	}

	@Override
	public InsureType getById(String id) {
		return insureTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<InsureType> list(InsureType insureType) {
		return this.list(insureType, null);
	}

	@Override
	public List<InsureType> list(InsureType insureType, String orderByStr) {
		InsureTypeExample example = new InsureTypeExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<InsureType> insureTypeList = this.insureTypeMapper.selectByExample(example);
		return insureTypeList;
	}

	@Override
	public PageResult<InsureType> findPageByParam(InsureType insureType, PageParam pageParam) {
		return this.findPageByParam(insureType, pageParam, null);
	}

	@Override
	public PageResult<InsureType> findPageByParam(InsureType insureType, PageParam pageParam, String orderByStr) {
		PageResult<InsureType> pageResult = new PageResult<InsureType>();

		InsureTypeExample example = new InsureTypeExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<InsureType> list = insureTypeMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.insureTypeMapper.deleteByPrimaryKey(id);
	}

}
