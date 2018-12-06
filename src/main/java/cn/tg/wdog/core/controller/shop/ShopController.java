package cn.tg.wdog.core.controller.shop;


import cn.tg.wdog.common.annotation.SysLogs;
import cn.tg.wdog.common.bean.DonationOne2OneType;
import cn.tg.wdog.common.bean.ResponseCode;
import cn.tg.wdog.common.bean.ResponseResult;
import cn.tg.wdog.core.dto.charitable.FindDonationOne2oneDTO;
import cn.tg.wdog.core.service.charitable.IDonationOne2oneService;
import cn.tg.wdog.core.service.charitable.IGoodsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
public class ShopController {

    @Autowired
    private IGoodsService iGoodsService;


    @PostMapping(value = {"/list"})
    @ApiOperation(value = "分页获取捐款数据")
    @SysLogs("分页获取捐款数据")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult get(@RequestBody @Validated @ApiParam(value = "用户获取过滤条件") FindDonationOne2oneDTO findDonationOne2oneDTO) {
        return ResponseResult.e(ResponseCode.OK, iGoodsService.getAllBySplitPage(findDonationOne2oneDTO));
    }


    @PostMapping(value = {"/lock/{donationId}"})
    @ApiOperation(value = "关闭公益项目")
    @SysLogs("关闭公益项目")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult lock(@PathVariable("donationId") @ApiParam(value = "公益id") String donationId) {
        iGoodsService.statusChange(donationId, 0);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/unlock/{donationId}"})
    @ApiOperation(value = "解锁用户")
    @SysLogs("解锁用户")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult unlock(@PathVariable("donationId") @ApiParam(value = "公益id") String donationId) {
        iGoodsService.statusChange(donationId, 1);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/donationType"})
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

}
