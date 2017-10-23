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
import com.hzcf.insurancesale.api.DeliveryService;
import com.hzcf.insurancesale.bean.Delivery;
import com.hzcf.insurancesale.bean.DeliveryExample;
import com.hzcf.insurancesale.bean.DeliveryExample.Criteria;
import com.hzcf.insurancesale.dao.DeliveryMapper;


@Service("deliveryService")
public class DeliveryServiceImpl implements DeliveryService {

	private final static Logger logger = LoggerFactory.getLogger(DeliveryServiceImpl.class);

	@Resource
	private DeliveryMapper deliveryMapper;


	@Override
	public void save(Delivery delivery) {
		if (null == delivery) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.deliveryMapper.insertSelective(delivery);
	}

	@Override
	public void update(Delivery delivery) {
		if (null == delivery) {
		throw new BusinessException(ErrCodeE.PARAM_INVALID.getCode(), ErrCodeE.PARAM_INVALID.getName());
		}
		this.deliveryMapper.updateByPrimaryKeySelective(delivery);
	}

	@Override
	public Delivery getById(String id) {
		return deliveryMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Delivery> list(Delivery delivery) {
		return this.list(delivery, null);
	}

	@Override
	public List<Delivery> list(Delivery delivery, String orderByStr) {
		DeliveryExample example = new DeliveryExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();

		List<Delivery> deliveryList = this.deliveryMapper.selectByExample(example);
		return deliveryList;
	}

	@Override
	public PageResult<Delivery> findPageByParam(Delivery delivery, PageParam pageParam) {
		return this.findPageByParam(delivery, pageParam, null);
	}

	@Override
	public PageResult<Delivery> findPageByParam(Delivery delivery, PageParam pageParam, String orderByStr) {
		PageResult<Delivery> pageResult = new PageResult<Delivery>();

		DeliveryExample example = new DeliveryExample();
		if (StringUtils.isNotBlank(orderByStr)) {
		example.setOrderByClause(orderByStr);
		}
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(pageParam.getPageNo(), pageParam.getPageSize()); //true:进行count查询,默认true
		List<Delivery> list = deliveryMapper.selectByExample(example);
		//兼容分页和不分页
		pageResult = PageResult.toPage(list);
		return pageResult;
	}

	@Override
	public void deleteById(String id) {
		this.deliveryMapper.deleteByPrimaryKey(id);
	}

}
