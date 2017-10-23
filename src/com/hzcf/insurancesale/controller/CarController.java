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
import com.hzcf.insurancesale.service.CarServicePretend;
import com.hzcf.insurancesale.bean.Car;


@Controller
@RequestMapping("/car")
public class CarController extends BaseAction {

    private final static Logger logger = LoggerFactory.getLogger(CarController.class);

    @Resource
    private CarServicePretend carServicePretend;

    /**
	 * @api {post} /car/save 新增车主车辆信息
	 * @apiGroup 车主车辆信息管理
	 * @apiName 新增车主车辆信息记录
	 * @apiDescription 全量插入车主车辆信息记录
	 * @apiParam {Car} car 车主车辆信息对象
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
    public JsonResult<Object> save(Car car) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.carServicePretend.save(car);
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
	 * @api {post} /car/update 修改车主车辆信息
	 * @apiGroup 车主车辆信息管理
	 * @apiName 修改车主车辆信息记录
	 * @apiDescription 根据主键id修改车主车辆信息记录
	 * @apiParam {Car} car 车主车辆信息对象
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
    public JsonResult update(Car car) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.carServicePretend.update(car);
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
	 * @api {get} /car/show 查询车主车辆信息详情
	 * @apiGroup 车主车辆信息管理
	 * @apiName 查询车主车辆信息详情
	 * @apiDescription 根据主键id查询车主车辆信息详情
	 * @apiParam {String} id 车主车辆信息主键id
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
    public JsonResult<Car> show(String id) {
        JsonResult<Car> jr = new JsonResult<Car>();
        try {
            ServiceResult<Car> sr = carServicePretend.getById(id);
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
	 * @api {get} /car/list 查询车主车辆信息列表(不带分页)
	 * @apiGroup 车主车辆信息管理
	 * @apiName 查询车主车辆信息列表(不带分页)
	 * @apiDescription 根据条件查询车主车辆信息列表(不带分页)
	 * @apiParam {Car} car 车主车辆信息对象
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
    public JsonResult<List<Car>> list(Car car) {
        JsonResult<List<Car>> jr = new JsonResult<List<Car>>();
        try {
            ServiceResult<List<Car>> sr = this.carServicePretend.list(null);
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
	 * @api {get} /car/findPageByParam 查询车主车辆信息列表(带分页)
	 * @apiGroup 车主车辆信息管理
	 * @apiName 查询车主车辆信息列表(带分页)
	 * @apiDescription 根据条件查询车主车辆信息列表(带分页)
	 * @apiParam {Car} car 车主车辆信息对象
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
    public JsonResult<PageResult<Car>> findPageByParam(Car car, PageParam pageParam) {
        JsonResult<PageResult<Car>> jr = new JsonResult<PageResult<Car>>();
        try {
            ServiceResult<PageResult<Car>> sr = this.carServicePretend.findPageByParam(car, pageParam);
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
	 * @api {post} /car/delete 删除车主车辆信息(物理删除)
	 * @apiGroup 车主车辆信息管理
	 * @apiName 删除车主车辆信息记录(物理删除)
	 * @apiDescription 根据主键id删除车主车辆信息记录(物理删除)
	 * @apiParam {String} id 车主车辆信息主键id
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
            ServiceResult<Object> sr = this.carServicePretend.deleteById(id);
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
