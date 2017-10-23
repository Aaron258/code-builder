package ${packageName};

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zgg.common.ServiceConstants;
import com.zgg.common.ServiceResult;
import com.zgg.common.code.ErrCodeEWeb;
import com.zgg.common.page.PageParam;
import com.zgg.common.page.PageResult;
import com.zgg.common.web.action.BaseAction;
import com.zgg.common.web.json.JsonResult;
import ${prefixPackageName}.service.${domainObjectName}ServicePretend;
import ${prefixPackageName}.bean.${domainObjectName};


@Controller
@RequestMapping("/${domainObjectNameLower}")
public class ${domainObjectName}Controller extends BaseAction {

    private final static Logger logger = LoggerFactory.getLogger(${domainObjectName}Controller.class);

    @Resource
    private ${domainObjectName}ServicePretend ${domainObjectNameLower}ServicePretend;

    /**
	 * @api {post} /${domainObjectNameLower}/save 新增${alias}
	 * @apiGroup ${alias}管理
	 * @apiName 新增${alias}记录
	 * @apiDescription 全量插入${alias}记录
	 * @apiParam {${domainObjectName}} ${domainObjectNameLower} ${alias}对象
	 * @apiVersion 1.0.0
	 * @apiSuccessExample {json} Response 200 Example 
	 * HTTP/1.1 200 OK 
	 * {
	 *     "success": true,
	 *     "data": {
	 *         "field1": "值1",
	 *         "field2": "值2"
	 *     },
	 *     "code": "0",	//0：成功，非0：失败，见错误码  
	 *     "message": "ok"
	 * }
	 */
    @RequestMapping("/save")
    @ResponseBody
    public JsonResult<Object> save(${domainObjectName} ${domainObjectNameLower}) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.${domainObjectNameLower}ServicePretend.save(${domainObjectNameLower});
            if (ServiceConstants.RETURN_SUCCESS.equals(sr.getCode())) {
                jr = buildJsonResult(sr.getResult());
            } else {
                jr = buildFailJsonResult(false, sr.getCode(), sr.getErrMsg());
            }
        } catch (Exception e) {
            logger.error("error", e);
            jr = buildFailJsonResult(false, ErrCodeEWeb.NONE);
        }
        return jr;
    }

	/**
	 * @api {post} /${domainObjectNameLower}/update 修改${alias}
	 * @apiGroup ${alias}管理
	 * @apiName 修改${alias}记录
	 * @apiDescription 根据主键id修改${alias}记录
	 * @apiParam {${domainObjectName}} ${domainObjectNameLower} ${alias}对象
	 * @apiVersion 1.0.0
	 * @apiSuccessExample {json} Response 200 Example 
	 * HTTP/1.1 200 OK 
	 * {
	 *     "success": true,
	 *     "data": {
	 *         "field1": "值1",
	 *         "field2": "值2"
	 *     },
	 *     "code": "0",	//0：成功，非0：失败，见错误码  
	 *     "message": "ok"
	 * }
	 */
    @RequestMapping("/update")
    @ResponseBody
    public JsonResult update(${domainObjectName} ${domainObjectNameLower}) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.${domainObjectNameLower}ServicePretend.update(${domainObjectNameLower});
            if (ServiceConstants.RETURN_SUCCESS.equals(sr.getCode())) {
                jr = buildJsonResult(sr.getResult());
            } else {
                jr = buildFailJsonResult(false, sr.getCode(), sr.getErrMsg());
            }
        } catch (Exception e) {
            logger.error("error", e);
            jr = buildFailJsonResult(false, ErrCodeEWeb.NONE);
        }
        return jr;
    }


	/**
	 * @api {get} /${domainObjectNameLower}/show 查询${alias}详情
	 * @apiGroup ${alias}管理
	 * @apiName 查询${alias}详情
	 * @apiDescription 根据主键id查询${alias}详情
	 * @apiParam {String} id ${alias}主键id
	 * @apiVersion 1.0.0
	 * @apiSuccessExample {json} Response 200 Example 
	 * HTTP/1.1 200 OK 
	 * {
	 *     "success": true,
	 *     "data": {
	 *         "field1": "值1",
	 *         "field2": "值2"
	 *     },
	 *     "code": "0",	//0：成功，非0：失败，见错误码  
	 *     "message": "ok"
	 * }
	 */
    @RequestMapping("/show")
    @ResponseBody
    public JsonResult<${domainObjectName}> show(String id) {
        JsonResult<${domainObjectName}> jr = new JsonResult<${domainObjectName}>();
        try {
            ServiceResult<${domainObjectName}> sr = ${domainObjectNameLower}ServicePretend.getById(id);
            if (ServiceConstants.RETURN_SUCCESS.equals(sr.getCode())) {
                jr = buildJsonResult(sr.getResult());
            } else {
                jr = buildFailJsonResult(false, sr.getCode(), sr.getErrMsg());
            }
        } catch (Exception e) {
            logger.error("error", e);
            jr = buildFailJsonResult(false, ErrCodeEWeb.NONE);
        }
        return jr;
    }

    /**
	 * @api {get} /${domainObjectNameLower}/list 查询${alias}列表(不带分页)
	 * @apiGroup ${alias}管理
	 * @apiName 查询${alias}列表(不带分页)
	 * @apiDescription 根据条件查询${alias}列表(不带分页)
	 * @apiParam {${domainObjectName}} ${domainObjectNameLower} ${alias}对象
	 * @apiVersion 1.0.0
	 * @apiSuccessExample {json} Response 200 Example 
	 * HTTP/1.1 200 OK 
	 * {
	 *   "success": true,
	 *   "data": {
	 *       "list": [
	 *           {
	 *              "file1": "值1",
	 *              "file2": "值2"
	 *          }
	 *      ]
	 *  },
	 *  "code": "0",	//0：成功，非0：失败，见错误码  
	 *  "message": "ok"
	 * }
	 */
    @RequestMapping("/list")
    @ResponseBody
    public JsonResult<List<${domainObjectName}>> list(${domainObjectName} ${domainObjectNameLower}) {
        JsonResult<List<${domainObjectName}>> jr = new JsonResult<List<${domainObjectName}>>();
        try {
            ServiceResult<List<${domainObjectName}>> sr = this.${domainObjectNameLower}ServicePretend.list(null);
            if (ServiceConstants.RETURN_SUCCESS.equals(sr.getCode())) {
                jr = buildJsonResult(sr.getResult());
            } else {
                jr = buildFailJsonResult(false, sr.getCode(), sr.getErrMsg());
            }
        } catch (Exception e) {
            logger.error("error", e);
            jr = buildFailJsonResult(false, ErrCodeEWeb.NONE);
        }
        return jr;
    }

	/**
	 * @api {get} /${domainObjectNameLower}/findPageByParam 查询${alias}列表(带分页)
	 * @apiGroup ${alias}管理
	 * @apiName 查询${alias}列表(带分页)
	 * @apiDescription 根据条件查询${alias}列表(带分页)
	 * @apiParam {${domainObjectName}} ${domainObjectNameLower} ${alias}对象
	 * @apiParam {PageParam} pageParam 分页对象
	 * @apiVersion 1.0.0
	 * @apiSuccessExample {json} Response 200 Example 
	 * HTTP/1.1 200 OK 
	 * {
	 *   "success": true,
	 *   "data": {
	 *      "pageSize": 5,
	 *      "pageNo": 1,
	 *      "totalCount": 1,
	 *      "totalPage": 1,
	 *       "list": [
	 *           {
	 *              "file1": "值1",
	 *              "file2": "值2"
	 *          }
	 *      ]
	 *  },
	 *  "code": "0",	//0：成功，非0：失败，见错误码  
	 *  "message": "ok"
	 * }
	 */
    @RequestMapping("/findPageByParam")
    @ResponseBody
    public JsonResult<PageResult<${domainObjectName}>> findPageByParam(${domainObjectName} ${domainObjectNameLower}, PageParam pageParam) {
        JsonResult<PageResult<${domainObjectName}>> jr = new JsonResult<PageResult<${domainObjectName}>>();
        try {
            ServiceResult<PageResult<${domainObjectName}>> sr = this.${domainObjectNameLower}ServicePretend.findPageByParam(${domainObjectNameLower}, pageParam);
            if (ServiceConstants.RETURN_SUCCESS.equals(sr.getCode())) {
                jr = buildJsonResult(sr.getResult());
            } else {
                jr = buildFailJsonResult(false, sr.getCode(), sr.getErrMsg());
            }
        } catch (Exception e) {
            logger.error("error", e);
            jr = buildFailJsonResult(false, ErrCodeEWeb.NONE);
        }

        return jr;
    }

    /**
	 * @api {post} /${domainObjectNameLower}/delete 删除${alias}(物理删除)
	 * @apiGroup ${alias}管理
	 * @apiName 删除${alias}记录(物理删除)
	 * @apiDescription 根据主键id删除${alias}记录(物理删除)
	 * @apiParam {String} id ${alias}主键id
	 * @apiVersion 1.0.0
	 
	 * @apiSuccessExample {json} Response 200 Example 
	 * HTTP/1.1 200 OK 
	 * {
	 *     "success": true,
	 *     "data": {
	 *     },
	 *     "code": "0",	//0：成功，非0：失败，见错误码  
	 *     "message": "ok"
	 * }
	 */
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(String id) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.${domainObjectNameLower}ServicePretend.deleteById(id);
            if (ServiceConstants.RETURN_SUCCESS.equals(sr.getCode())) {
                jr = buildJsonResult(sr.getResult());
            } else {
                jr = buildFailJsonResult(false, sr.getCode(), sr.getErrMsg());
            }
        } catch (Exception e) {
            logger.error("error", e);
            jr = buildFailJsonResult(false, ErrCodeEWeb.NONE);
        }

        return jr;
    }


}
