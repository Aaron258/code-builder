package com.hzcf.insurancesale.api;

import java.util.List;
import java.util.Map;

import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import com.hzcf.insurancesale.bean.Car;

/**
 * @author 
 *
 */
public interface CarService {
	
	/**
     * @api save 新增车主车辆信息
     * @apiGroup 车主车辆信息管理
     * @apiName  新增车主车辆信息记录
     * @apiDescription 全量插入车主车辆信息记录
     * @apiParam {Car} car 车主车辆信息对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (Car car);
	
	/**
     * @api update 修改车主车辆信息
     * @apiGroup 车主车辆信息管理
     * @apiName  修改车主车辆信息记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {Car} car 车主车辆信息对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(Car car);
	
	/**
     * @api getById 根据车主车辆信息id查询详情
     * @apiGroup 车主车辆信息管理
     * @apiName  查询车主车辆信息详情
     * @apiDescription 根据主键id查询车主车辆信息详情
     * @apiParam {String} id 主键id
     * @apiSuccess Car 车主车辆信息实体对象
     * @apiVersion 1.0.0
     * 
     */
	public Car getById(String id);
	
	/**
     * @api list 根据车主车辆信息条件查询列表
     * @apiGroup 车主车辆信息管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam Car car  实体条件
     * @apiSuccess List<Car> 车主车辆信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<Car> list(Car car);
	

	/**
     * @api list 根据车主车辆信息条件查询列表（含排序）
     * @apiGroup 车主车辆信息管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam Car} car  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<Car> 车主车辆信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<Car> list(Car car, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据车主车辆信息条件查询列表（分页）
     * @apiGroup 车主车辆信息管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam Car} car  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<Car> 车主车辆信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<Car> findPageByParam(Car car, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据车主车辆信息条件查询列表（分页，含排序）
     * @apiGroup 车主车辆信息管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam Car} car  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<Car> 车主车辆信息实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<Car> findPageByParam(Car car, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据车主车辆信息id删除
     * @apiGroup 车主车辆信息管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

