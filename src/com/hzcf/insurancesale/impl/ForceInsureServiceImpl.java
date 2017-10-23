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
import com.hzcf.insurancesale.api.ForceInsureService;
import com.hzcf.insurancesale.bean.ForceInsure;
import com.hzcf.insurancesale.bean.ForceInsureExample;
import com.hzcf.insurancesale.bean.ForceInsureExample.Criteria;
import com.hzcf.insurancesale.dao.ForceInsureMapper;


@Service("forceInsureService")
public class ForceInsureServiceImpl implements ForceInsureService {

	private final static Logger logger = LoggerFactory.getLogger(ForceInsureServiceImpl.class);

	@Resource
	private ForceInsureMapper forceInsureMapper;


	@Override
	public void save(ForceInsure forceInsure) {
		if (null == forceInsure) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.forceInsureMapper.insertSelective(forceInsure);
	}

	@Override
	public void update(ForceInsure forceInsure) {
		if (null == forceInsure) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.forceInsureMapper.updateByPrimaryKeySelective(forceInsure);
	}

	@Override
	public ForceInsure getById(String id) {
		return forceInsureMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ForceInsure> list(ForceInsure forceInsure) {
		return this.list(forceInsure, null);
	}

	@Override
	public List<ForceInsure> list(ForceInsure forceInsure, String orderByStr) {
		ForceInsureExample example = new ForceInsureExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<ForceInsure> forceInsureList = this.forceInsureMapper.selectByExample(example);
		return forceInsureList;
	}

	@Override
	public PageResult<ForceInsure> findPageByParam(ForceInsure forceInsure, PageParam pageParam) {
		return this.findPageByParam(forceInsure, pageParam, null);
	}

	@Override
	public PageResult<ForceInsure> findPageByParam(ForceInsure forceInsure, PageParam pageParam, String orderByStr) {
		PageResult<ForceInsure> pageResult = new PageResult<ForceInsure>();

		ForceInsureExample example = new ForceInsureExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<ForceInsure> list = forceInsureMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.forceInsureMapper.deleteByPrimaryKey(id);
	}

}
