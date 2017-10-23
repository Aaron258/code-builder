package com.hzcf.insurancesale.api;

import java.util.List;
import java.util.Map;

import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import com.hzcf.insurancesale.bean.BusinessInsure;

/**
 * @author 
 *
 */
public interface BusinessInsureService {
	
	/**
     * @api save 新增商业险
     * @apiGroup 商业险管理
     * @apiName  新增商业险记录
     * @apiDescription 全量插入商业险记录
     * @apiParam {BusinessInsure} businessInsure 商业险对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (BusinessInsure businessInsure);
	
	/**
     * @api update 修改商业险
     * @apiGroup 商业险管理
     * @apiName  修改商业险记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {BusinessInsure} businessInsure 商业险对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(BusinessInsure businessInsure);
	
	/**
     * @api getById 根据商业险id查询详情
     * @apiGroup 商业险管理
     * @apiName  查询商业险详情
     * @apiDescription 根据主键id查询商业险详情
     * @apiParam {String} id 主键id
     * @apiSuccess BusinessInsure 商业险实体对象
     * @apiVersion 1.0.0
     * 
     */
	public BusinessInsure getById(String id);
	
	/**
     * @api list 根据商业险条件查询列表
     * @apiGroup 商业险管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam BusinessInsure businessInsure  实体条件
     * @apiSuccess List<BusinessInsure> 商业险实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<BusinessInsure> list(BusinessInsure businessInsure);
	

	/**
     * @api list 根据商业险条件查询列表（含排序）
     * @apiGroup 商业险管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam BusinessInsure} businessInsure  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<BusinessInsure> 商业险实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<BusinessInsure> list(BusinessInsure businessInsure, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据商业险条件查询列表（分页）
     * @apiGroup 商业险管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam BusinessInsure} businessInsure  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<BusinessInsure> 商业险实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<BusinessInsure> findPageByParam(BusinessInsure businessInsure, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据商业险条件查询列表（分页，含排序）
     * @apiGroup 商业险管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam BusinessInsure} businessInsure  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<BusinessInsure> 商业险实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<BusinessInsure> findPageByParam(BusinessInsure businessInsure, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据商业险id删除
     * @apiGroup 商业险管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

