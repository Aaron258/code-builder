package com.hzcf.insurancesale.api;

import java.util.List;
import java.util.Map;

import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import com.hzcf.insurancesale.bean.InsureType;

/**
 * @author 
 *
 */
public interface InsureTypeService {
	
	/**
     * @api save 新增险种信息
     * @apiGroup 险种信息管理
     * @apiName  新增险种信息记录
     * @apiDescription 全量插入险种信息记录
     * @apiParam {InsureType} insureType 险种信息对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (InsureType insureType);
	
	/**
     * @api update 修改险种信息
     * @apiGroup 险种信息管理
     * @apiName  修改险种信息记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {InsureType} insureType 险种信息对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(InsureType insureType);
	
	/**
     * @api getById 根据险种信息id查询详情
     * @apiGroup 险种信息管理
     * @apiName  查询险种信息详情
     * @apiDescription 根据主键id查询险种信息详情
     * @apiParam {String} id 主键id
     * @apiSuccess InsureType 险种信息实体对象
     * @apiVersion 1.0.0
     * 
     */
	public InsureType getById(String id);
	
	/**
     * @api list 根据险种信息条件查询列表
     * @apiGroup 险种信息管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam InsureType insureType  实体条件
     * @apiSuccess List<InsureType> 险种信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<InsureType> list(InsureType insureType);
	

	/**
     * @api list 根据险种信息条件查询列表（含排序）
     * @apiGroup 险种信息管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam InsureType} insureType  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<InsureType> 险种信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<InsureType> list(InsureType insureType, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据险种信息条件查询列表（分页）
     * @apiGroup 险种信息管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam InsureType} insureType  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<InsureType> 险种信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<InsureType> findPageByParam(InsureType insureType, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据险种信息条件查询列表（分页，含排序）
     * @apiGroup 险种信息管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam InsureType} insureType  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<InsureType> 险种信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<InsureType> findPageByParam(InsureType insureType, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据险种信息id删除
     * @apiGroup 险种信息管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

