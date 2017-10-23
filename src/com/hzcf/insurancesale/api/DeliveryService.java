package com.hzcf.insurancesale.api;

import java.util.List;
import java.util.Map;

import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import com.hzcf.insurancesale.bean.Delivery;

/**
 * @author 
 *
 */
public interface DeliveryService {
	
	/**
     * @api save 新增配送信息
     * @apiGroup 配送信息管理
     * @apiName  新增配送信息记录
     * @apiDescription 全量插入配送信息记录
     * @apiParam {Delivery} delivery 配送信息对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (Delivery delivery);
	
	/**
     * @api update 修改配送信息
     * @apiGroup 配送信息管理
     * @apiName  修改配送信息记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {Delivery} delivery 配送信息对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(Delivery delivery);
	
	/**
     * @api getById 根据配送信息id查询详情
     * @apiGroup 配送信息管理
     * @apiName  查询配送信息详情
     * @apiDescription 根据主键id查询配送信息详情
     * @apiParam {String} id 主键id
     * @apiSuccess Delivery 配送信息实体对象
     * @apiVersion 1.0.0
     * 
     */
	public Delivery getById(String id);
	
	/**
     * @api list 根据配送信息条件查询列表
     * @apiGroup 配送信息管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam Delivery delivery  实体条件
     * @apiSuccess List<Delivery> 配送信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<Delivery> list(Delivery delivery);
	

	/**
     * @api list 根据配送信息条件查询列表（含排序）
     * @apiGroup 配送信息管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam Delivery} delivery  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<Delivery> 配送信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<Delivery> list(Delivery delivery, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据配送信息条件查询列表（分页）
     * @apiGroup 配送信息管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam Delivery} delivery  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<Delivery> 配送信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<Delivery> findPageByParam(Delivery delivery, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据配送信息条件查询列表（分页，含排序）
     * @apiGroup 配送信息管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam Delivery} delivery  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<Delivery> 配送信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<Delivery> findPageByParam(Delivery delivery, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据配送信息id删除
     * @apiGroup 配送信息管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

