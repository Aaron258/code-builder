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
import com.zgg.demo.user.service.${domainObjectName}ServicePretend;
import com.zgg.service.demo.user.bean.${domainObjectName};


@Controller
@RequestMapping("/${domainObjectNameLower}")
public class ${domainObjectName}Controller extends BaseAction {

    private final static Logger logger = LoggerFactory.getLogger(${domainObjectName}Controller.class);

    @Resource
    private ${domainObjectName}ServicePretend ${domainObjectNameLower}ServicePretend;

    //添加
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

    //修改
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

    //列表
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

    //删除
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(String id) {
        JsonResult<Object> jr = new JsonResult<Object>();
        try {
            ServiceResult<Object> sr = this.${domainObjectNameLower}vicePretend.deleteById(id);
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
