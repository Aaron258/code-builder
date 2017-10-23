package com.hzcf.insurancesale.controller;

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
import com.hzcf.insurancesale.service.ForceInsureServicePretend;
import com.hzcf.insurancesale.bean.ForceInsure;


@Controller
@RequestMapping("/forceInsure")
public class ForceInsureController extends BaseAction {

    private final static Logger logger = LoggerFactory.getLogger(ForceInsureController.class);

    @Resource
    private ForceInsureServicePretend forceInsureServicePretend;

    /**
	 * @api {post} /forceInsure/save 新增交强险,车船税
	 * @apiGroup 交强险,车船税管理
	 * @apiName 新增交强险,车船税记录
	 * @apiDescription 全量插入交强险,车船税记录
	 * @apiParam {ForceInsure} forceInsure 交强险,车船税对象
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
    public JsonResult<Object> save(ForceInsure forceInsure) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.forceInsureServicePretend.save(forceInsure);
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
	 * @api {post} /forceInsure/update 修改交强险,车船税
	 * @apiGroup 交强险,车船税管理
	 * @apiName 修改交强险,车船税记录
	 * @apiDescription 根据主键id修改交强险,车船税记录
	 * @apiParam {ForceInsure} forceInsure 交强险,车船税对象
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
    public JsonResult update(ForceInsure forceInsure) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.forceInsureServicePretend.update(forceInsure);
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
	 * @api {get} /forceInsure/show 查询交强险,车船税详情
	 * @apiGroup 交强险,车船税管理
	 * @apiName 查询交强险,车船税详情
	 * @apiDescription 根据主键id查询交强险,车船税详情
	 * @apiParam {String} id 交强险,车船税主键id
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
    public JsonResult<ForceInsure> show(String id) {
        JsonResult<ForceInsure> jr = new JsonResult<ForceInsure>();
        try {
            ServiceResult<ForceInsure> sr = forceInsureServicePretend.getById(id);
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
	 * @api {get} /forceInsure/list 查询交强险,车船税列表(不带分页)
	 * @apiGroup 交强险,车船税管理
	 * @apiName 查询交强险,车船税列表(不带分页)
	 * @apiDescription 根据条件查询交强险,车船税列表(不带分页)
	 * @apiParam {ForceInsure} forceInsure 交强险,车船税对象
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
    public JsonResult<List<ForceInsure>> list(ForceInsure forceInsure) {
        JsonResult<List<ForceInsure>> jr = new JsonResult<List<ForceInsure>>();
        try {
            ServiceResult<List<ForceInsure>> sr = this.forceInsureServicePretend.list(null);
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
	 * @api {get} /forceInsure/findPageByParam 查询交强险,车船税列表(带分页)
	 * @apiGroup 交强险,车船税管理
	 * @apiName 查询交强险,车船税列表(带分页)
	 * @apiDescription 根据条件查询交强险,车船税列表(带分页)
	 * @apiParam {ForceInsure} forceInsure 交强险,车船税对象
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
    public JsonResult<PageResult<ForceInsure>> findPageByParam(ForceInsure forceInsure, PageParam pageParam) {
        JsonResult<PageResult<ForceInsure>> jr = new JsonResult<PageResult<ForceInsure>>();
        try {
            ServiceResult<PageResult<ForceInsure>> sr = this.forceInsureServicePretend.findPageByParam(forceInsure, pageParam);
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
	 * @api {post} /forceInsure/delete 删除交强险,车船税(物理删除)
	 * @apiGroup 交强险,车船税管理
	 * @apiName 删除交强险,车船税记录(物理删除)
	 * @apiDescription 根据主键id删除交强险,车船税记录(物理删除)
	 * @apiParam {String} id 交强险,车船税主键id
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
            ServiceResult<Object> sr = this.forceInsureServicePretend.deleteById(id);
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
