package cn.tg.wdog.core.controller.charitable;


import cn.tg.wdog.common.annotation.SysLogs;
import cn.tg.wdog.common.bean.DonationOne2OneType;
import cn.tg.wdog.common.bean.ResponseCode;
import cn.tg.wdog.common.bean.ResponseResult;
import cn.tg.wdog.core.dto.charitable.one2one.FindOne2oneDTO;
import cn.tg.wdog.core.dto.charitable.one2one.One2oneAddDTO;
import cn.tg.wdog.core.dto.charitable.one2one.One2oneUpdateDTO;
import cn.tg.wdog.core.service.charitable.IDonationOne2oneService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public ResponseResult get(@RequestBody @Validated @ApiParam(value = "用户获取过滤条件") FindOne2oneDTO findOne2OneDTO) {
        return ResponseResult.e(ResponseCode.OK, iDonationOne2oneService.getAllUserBySplitPage(findOne2OneDTO));
    }


    @PostMapping(value = {"/get/id/{donationId}"})
    @ApiOperation(value = "关闭公益项目")
    @SysLogs("关闭公益项目")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult get(@PathVariable("donationId") @ApiParam(value = "公益id") String donationId) {
        return ResponseResult.e(ResponseCode.OK, iDonationOne2oneService.findById(donationId));
    }

    @PostMapping(value = {"/lock/{donationId}"})
    @ApiOperation(value = "关闭公益项目")
    @SysLogs("关闭公益项目")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult lock(@PathVariable("donationId") @ApiParam(value = "公益id") String donationId) {
        iDonationOne2oneService.statusChange(donationId, 0);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/unlock/{donationId}"})
    @ApiOperation(value = "解锁用户")
    @SysLogs("解锁用户")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult unlock(@PathVariable("donationId") @ApiParam(value = "公益id") String donationId) {
        iDonationOne2oneService.statusChange(donationId, 1);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/one2oneType"})
    @ApiOperation(value = "公益类型")
    @SysLogs("公益类型")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult donationType() {
        Set<Map<String, String>> mapList = new HashSet<>();
        for (DonationOne2OneType donationOne2OneType : DonationOne2OneType.values()) {
            Map<String, String> map = new HashMap<>();
            map.put("code", String.valueOf(donationOne2OneType.getCode()));
            map.put("desc", donationOne2OneType.getMsg());
            mapList.add(map);
        }
        return ResponseResult.e(ResponseCode.OK, mapList);
    }

    @PostMapping(value = {"/add"})
    @ApiOperation(value = "添加一对一捐助")
    @SysLogs("添加一对一捐助")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult add(@RequestBody @Validated @ApiParam(value = "一对一捐助数据") One2oneAddDTO addDTO) {
        iDonationOne2oneService.add(addDTO);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/update/{id}"})
    @ApiOperation(value = "更新用户")
    @SysLogs("更新用户")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult update(@PathVariable("id") @ApiParam(value = "捐款项目ID") String donationId,
                                 @RequestBody @Validated @ApiParam(value = "一对一捐款数据") One2oneUpdateDTO updateDTO) {
        iDonationOne2oneService.update(donationId, updateDTO);
        return ResponseResult.e(ResponseCode.OK);
    }

}
