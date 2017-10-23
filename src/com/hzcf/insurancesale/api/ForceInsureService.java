package com.hzcf.insurancesale.api;

import java.util.List;
import java.util.Map;

import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import com.hzcf.insurancesale.bean.ForceInsure;

/**
 * @author 
 *
 */
public interface ForceInsureService {
	
	/**
     * @api save 新增交强险,车船税
     * @apiGroup 交强险,车船税管理
     * @apiName  新增交强险,车船税记录
     * @apiDescription 全量插入交强险,车船税记录
     * @apiParam {ForceInsure} forceInsure 交强险,车船税对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (ForceInsure forceInsure);
	
	/**
     * @api update 修改交强险,车船税
     * @apiGroup 交强险,车船税管理
     * @apiName  修改交强险,车船税记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {ForceInsure} forceInsure 交强险,车船税对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(ForceInsure forceInsure);
	
	/**
     * @api getById 根据交强险,车船税id查询详情
     * @apiGroup 交强险,车船税管理
     * @apiName  查询交强险,车船税详情
     * @apiDescription 根据主键id查询交强险,车船税详情
     * @apiParam {String} id 主键id
     * @apiSuccess ForceInsure 交强险,车船税实体对象
     * @apiVersion 1.0.0
     * 
     */
	public ForceInsure getById(String id);
	
	/**
     * @api list 根据交强险,车船税条件查询列表
     * @apiGroup 交强险,车船税管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam ForceInsure forceInsure  实体条件
     * @apiSuccess List<ForceInsure> 交强险,车船税实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<ForceInsure> list(ForceInsure forceInsure);
	

	/**
     * @api list 根据交强险,车船税条件查询列表（含排序）
     * @apiGroup 交强险,车船税管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam ForceInsure} forceInsure  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<ForceInsure> 交强险,车船税实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<ForceInsure> list(ForceInsure forceInsure, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据交强险,车船税条件查询列表（分页）
     * @apiGroup 交强险,车船税管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam ForceInsure} forceInsure  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<ForceInsure> 交强险,车船税实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<ForceInsure> findPageByParam(ForceInsure forceInsure, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据交强险,车船税条件查询列表（分页，含排序）
     * @apiGroup 交强险,车船税管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam ForceInsure} forceInsure  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<ForceInsure> 交强险,车船税实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<ForceInsure> findPageByParam(ForceInsure forceInsure, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据交强险,车船税id删除
     * @apiGroup 交强险,车船税管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

