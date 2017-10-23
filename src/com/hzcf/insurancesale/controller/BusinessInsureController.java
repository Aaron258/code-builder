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
import com.hzcf.insurancesale.service.BusinessInsureServicePretend;
import com.hzcf.insurancesale.bean.BusinessInsure;


@Controller
@RequestMapping("/businessInsure")
public class BusinessInsureController extends BaseAction {

    private final static Logger logger = LoggerFactory.getLogger(BusinessInsureController.class);

    @Resource
    private BusinessInsureServicePretend businessInsureServicePretend;

    /**
	 * @api {post} /businessInsure/save 新增商业险
	 * @apiGroup 商业险管理
	 * @apiName 新增商业险记录
	 * @apiDescription 全量插入商业险记录
	 * @apiParam {BusinessInsure} businessInsure 商业险对象
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
    public JsonResult<Object> save(BusinessInsure businessInsure) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.businessInsureServicePretend.save(businessInsure);
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
	 * @api {post} /businessInsure/update 修改商业险
	 * @apiGroup 商业险管理
	 * @apiName 修改商业险记录
	 * @apiDescription 根据主键id修改商业险记录
	 * @apiParam {BusinessInsure} businessInsure 商业险对象
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
    public JsonResult update(BusinessInsure businessInsure) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.businessInsureServicePretend.update(businessInsure);
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
	 * @api {get} /businessInsure/show 查询商业险详情
	 * @apiGroup 商业险管理
	 * @apiName 查询商业险详情
	 * @apiDescription 根据主键id查询商业险详情
	 * @apiParam {String} id 商业险主键id
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
    public JsonResult<BusinessInsure> show(String id) {
        JsonResult<BusinessInsure> jr = new JsonResult<BusinessInsure>();
        try {
            ServiceResult<BusinessInsure> sr = businessInsureServicePretend.getById(id);
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
	 * @api {get} /businessInsure/list 查询商业险列表(不带分页)
	 * @apiGroup 商业险管理
	 * @apiName 查询商业险列表(不带分页)
	 * @apiDescription 根据条件查询商业险列表(不带分页)
	 * @apiParam {BusinessInsure} businessInsure 商业险对象
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
    public JsonResult<List<BusinessInsure>> list(BusinessInsure businessInsure) {
        JsonResult<List<BusinessInsure>> jr = new JsonResult<List<BusinessInsure>>();
        try {
            ServiceResult<List<BusinessInsure>> sr = this.businessInsureServicePretend.list(null);
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
	 * @api {get} /businessInsure/findPageByParam 查询商业险列表(带分页)
	 * @apiGroup 商业险管理
	 * @apiName 查询商业险列表(带分页)
	 * @apiDescription 根据条件查询商业险列表(带分页)
	 * @apiParam {BusinessInsure} businessInsure 商业险对象
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
    public JsonResult<PageResult<BusinessInsure>> findPageByParam(BusinessInsure businessInsure, PageParam pageParam) {
        JsonResult<PageResult<BusinessInsure>> jr = new JsonResult<PageResult<BusinessInsure>>();
        try {
            ServiceResult<PageResult<BusinessInsure>> sr = this.businessInsureServicePretend.findPageByParam(businessInsure, pageParam);
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
	 * @api {post} /businessInsure/delete 删除商业险(物理删除)
	 * @apiGroup 商业险管理
	 * @apiName 删除商业险记录(物理删除)
	 * @apiDescription 根据主键id删除商业险记录(物理删除)
	 * @apiParam {String} id 商业险主键id
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
            ServiceResult<Object> sr = this.businessInsureServicePretend.deleteById(id);
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
