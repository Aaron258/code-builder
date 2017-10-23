package ${packageName};

import java.util.List;
import java.util.Map;

import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import ${prefixPackageName}.bean.${domainObjectName};

/**
 * @author 
 *
 */
public interface ${domainObjectName}Service {
	
	/**
     * @api save 新增${alias}
     * @apiGroup ${alias}管理
     * @apiName  新增${alias}记录
     * @apiDescription 全量插入${alias}记录
     * @apiParam {${domainObjectName}} ${domainObjectNameLower} ${alias}对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (${domainObjectName} ${domainObjectNameLower});
	
	/**
     * @api update 修改${alias}
     * @apiGroup ${alias}管理
     * @apiName  修改${alias}记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {${domainObjectName}} ${domainObjectNameLower} ${alias}对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(${domainObjectName} ${domainObjectNameLower});
	
	/**
     * @api getById 根据${alias}id查询详情
     * @apiGroup ${alias}管理
     * @apiName  查询${alias}详情
     * @apiDescription 根据主键id查询${alias}详情
     * @apiParam {String} id 主键id
     * @apiSuccess ${domainObjectName} ${alias}实体对象
     * @apiVersion 1.0.0
     * 
     */
	public ${domainObjectName} getById(String id);
	
	/**
     * @api list 根据${alias}条件查询列表
     * @apiGroup ${alias}管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam ${domainObjectName} ${domainObjectNameLower}  实体条件
     * @apiSuccess List<${domainObjectName}> ${alias}实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<${domainObjectName}> list(${domainObjectName} ${domainObjectNameLower});
	

	/**
     * @api list 根据${alias}条件查询列表（含排序）
     * @apiGroup ${alias}管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam ${domainObjectName}} ${domainObjectNameLower}  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<${domainObjectName}> ${alias}实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<${domainObjectName}> list(${domainObjectName} ${domainObjectNameLower}, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据${alias}条件查询列表（分页）
     * @apiGroup ${alias}管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam ${domainObjectName}} ${domainObjectNameLower}  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<${domainObjectName}> ${alias}实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<${domainObjectName}> findPageByParam(${domainObjectName} ${domainObjectNameLower}, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据${alias}条件查询列表（分页，含排序）
     * @apiGroup ${alias}管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam ${domainObjectName}} ${domainObjectNameLower}  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<${domainObjectName}> ${alias}实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<${domainObjectName}> findPageByParam(${domainObjectName} ${domainObjectNameLower}, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据${alias}id删除
     * @apiGroup ${alias}管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

