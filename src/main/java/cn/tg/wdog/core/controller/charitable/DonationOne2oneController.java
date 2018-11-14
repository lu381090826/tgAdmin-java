package cn.tg.wdog.core.controller.charitable;


import cn.tg.wdog.common.annotation.SysLogs;
import cn.tg.wdog.common.bean.ResponseCode;
import cn.tg.wdog.common.bean.ResponseResult;
import cn.tg.wdog.core.dto.charitable.FindDonationOne2oneDTO;
import cn.tg.wdog.core.service.charitable.IDonationOne2oneService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author gavinlu
 * @since 2018-11-14
 */
@RestController
@RequestMapping("/charitable/one2one")
public class DonationOne2oneController {

    @Autowired
    private IDonationOne2oneService iDonationOne2oneService;


    @PostMapping(value = {"/list"})
    @ApiOperation(value = "分页获取捐款数据")
    @SysLogs("分页获取捐款数据")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult get(@RequestBody @Validated @ApiParam(value = "用户获取过滤条件") FindDonationOne2oneDTO findDonationOne2oneDTO) {
        return ResponseResult.e(ResponseCode.OK, iDonationOne2oneService.getAllUserBySplitPage(findDonationOne2oneDTO));
    }
//
//
//    @PostMapping(value = {"/lock/{id}"})
//    @ApiOperation(value = "锁定")
//    @SysLogs("锁定用户")
//    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
//    public ResponseResult lock(@PathVariable("id") @ApiParam(value = "用户标识ID") String id) {
//        userService.statusChange(id, 0);
//        return ResponseResult.e(ResponseCode.OK);
//    }

}
