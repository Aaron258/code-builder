package com.hzcf.insurancesale.api;

import java.util.List;
import java.util.Map;

import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import com.hzcf.insurancesale.bean.CarInsurePolicy;

/**
 * @author 
 *
 */
public interface CarInsurePolicyService {
	
	/**
     * @api save 新增车险保单
     * @apiGroup 车险保单管理
     * @apiName  新增车险保单记录
     * @apiDescription 全量插入车险保单记录
     * @apiParam {CarInsurePolicy} carInsurePolicy 车险保单对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (CarInsurePolicy carInsurePolicy);
	
	/**
     * @api update 修改车险保单
     * @apiGroup 车险保单管理
     * @apiName  修改车险保单记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {CarInsurePolicy} carInsurePolicy 车险保单对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(CarInsurePolicy carInsurePolicy);
	
	/**
     * @api getById 根据车险保单id查询详情
     * @apiGroup 车险保单管理
     * @apiName  查询车险保单详情
     * @apiDescription 根据主键id查询车险保单详情
     * @apiParam {String} id 主键id
     * @apiSuccess CarInsurePolicy 车险保单实体对象
     * @apiVersion 1.0.0
     * 
     */
	public CarInsurePolicy getById(String id);
	
	/**
     * @api list 根据车险保单条件查询列表
     * @apiGroup 车险保单管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam CarInsurePolicy carInsurePolicy  实体条件
     * @apiSuccess List<CarInsurePolicy> 车险保单实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<CarInsurePolicy> list(CarInsurePolicy carInsurePolicy);
	

	/**
     * @api list 根据车险保单条件查询列表（含排序）
     * @apiGroup 车险保单管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam CarInsurePolicy} carInsurePolicy  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<CarInsurePolicy> 车险保单实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<CarInsurePolicy> list(CarInsurePolicy carInsurePolicy, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据车险保单条件查询列表（分页）
     * @apiGroup 车险保单管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam CarInsurePolicy} carInsurePolicy  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<CarInsurePolicy> 车险保单实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<CarInsurePolicy> findPageByParam(CarInsurePolicy carInsurePolicy, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据车险保单条件查询列表（分页，含排序）
     * @apiGroup 车险保单管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam CarInsurePolicy} carInsurePolicy  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<CarInsurePolicy> 车险保单实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<CarInsurePolicy> findPageByParam(CarInsurePolicy carInsurePolicy, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据车险保单id删除
     * @apiGroup 车险保单管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

