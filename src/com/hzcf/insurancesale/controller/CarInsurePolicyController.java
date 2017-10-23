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
import com.hzcf.insurancesale.service.CarInsurePolicyServicePretend;
import com.hzcf.insurancesale.bean.CarInsurePolicy;


@Controller
@RequestMapping("/carInsurePolicy")
public class CarInsurePolicyController extends BaseAction {

    private final static Logger logger = LoggerFactory.getLogger(CarInsurePolicyController.class);

    @Resource
    private CarInsurePolicyServicePretend carInsurePolicyServicePretend;

    /**
	 * @api {post} /carInsurePolicy/save 新增车险保单
	 * @apiGroup 车险保单管理
	 * @apiName 新增车险保单记录
	 * @apiDescription 全量插入车险保单记录
	 * @apiParam {CarInsurePolicy} carInsurePolicy 车险保单对象
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
    public JsonResult<Object> save(CarInsurePolicy carInsurePolicy) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.carInsurePolicyServicePretend.save(carInsurePolicy);
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
	 * @api {post} /carInsurePolicy/update 修改车险保单
	 * @apiGroup 车险保单管理
	 * @apiName 修改车险保单记录
	 * @apiDescription 根据主键id修改车险保单记录
	 * @apiParam {CarInsurePolicy} carInsurePolicy 车险保单对象
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
    public JsonResult update(CarInsurePolicy carInsurePolicy) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.carInsurePolicyServicePretend.update(carInsurePolicy);
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
	 * @api {get} /carInsurePolicy/show 查询车险保单详情
	 * @apiGroup 车险保单管理
	 * @apiName 查询车险保单详情
	 * @apiDescription 根据主键id查询车险保单详情
	 * @apiParam {String} id 车险保单主键id
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
    public JsonResult<CarInsurePolicy> show(String id) {
        JsonResult<CarInsurePolicy> jr = new JsonResult<CarInsurePolicy>();
        try {
            ServiceResult<CarInsurePolicy> sr = carInsurePolicyServicePretend.getById(id);
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
	 * @api {get} /carInsurePolicy/list 查询车险保单列表(不带分页)
	 * @apiGroup 车险保单管理
	 * @apiName 查询车险保单列表(不带分页)
	 * @apiDescription 根据条件查询车险保单列表(不带分页)
	 * @apiParam {CarInsurePolicy} carInsurePolicy 车险保单对象
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
    public JsonResult<List<CarInsurePolicy>> list(CarInsurePolicy carInsurePolicy) {
        JsonResult<List<CarInsurePolicy>> jr = new JsonResult<List<CarInsurePolicy>>();
        try {
            ServiceResult<List<CarInsurePolicy>> sr = this.carInsurePolicyServicePretend.list(null);
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
	 * @api {get} /carInsurePolicy/findPageByParam 查询车险保单列表(带分页)
	 * @apiGroup 车险保单管理
	 * @apiName 查询车险保单列表(带分页)
	 * @apiDescription 根据条件查询车险保单列表(带分页)
	 * @apiParam {CarInsurePolicy} carInsurePolicy 车险保单对象
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
    public JsonResult<PageResult<CarInsurePolicy>> findPageByParam(CarInsurePolicy carInsurePolicy, PageParam pageParam) {
        JsonResult<PageResult<CarInsurePolicy>> jr = new JsonResult<PageResult<CarInsurePolicy>>();
        try {
            ServiceResult<PageResult<CarInsurePolicy>> sr = this.carInsurePolicyServicePretend.findPageByParam(carInsurePolicy, pageParam);
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
	 * @api {post} /carInsurePolicy/delete 删除车险保单(物理删除)
	 * @apiGroup 车险保单管理
	 * @apiName 删除车险保单记录(物理删除)
	 * @apiDescription 根据主键id删除车险保单记录(物理删除)
	 * @apiParam {String} id 车险保单主键id
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
            ServiceResult<Object> sr = this.carInsurePolicyServicePretend.deleteById(id);
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
