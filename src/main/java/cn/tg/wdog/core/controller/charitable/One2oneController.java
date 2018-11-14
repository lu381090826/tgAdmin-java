package cn.tg.wdog.core.controller.charitable;

import cn.tg.wdog.common.annotation.JwtClaim;
import cn.tg.wdog.common.bean.ResponseResult;
import cn.tg.wdog.common.bean.ResponseCode;
import cn.tg.wdog.common.annotation.SysLogs;
import cn.tg.wdog.core.config.jwt.JwtToken;
import cn.tg.wdog.core.dto.SignInDTO;
import cn.tg.wdog.core.service.system.SysUserService;
import cn.tg.wdog.common.annotation.SysLogs;
import cn.tg.wdog.common.bean.ResponseCode;
import cn.tg.wdog.common.bean.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Licoy
 * @version 2018/4/13/14:02
 */
@RestController
@RequestMapping(value = {"/charitable/one2one"})
@Api(tags = {"一对一捐助管理"})
public class One2oneController {


    @PostMapping(value = {"/list"})
    @ApiOperation(value = "分页获取所有列表")
    @SysLogs("一对一列表")
    public ResponseResult list() {

        return ResponseResult.e(ResponseCode.OK );
    }
}