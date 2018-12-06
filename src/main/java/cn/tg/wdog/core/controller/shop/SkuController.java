package cn.tg.wdog.core.controller.shop;


import cn.tg.wdog.common.annotation.SysLogs;
import cn.tg.wdog.common.bean.ResponseCode;
import cn.tg.wdog.common.bean.ResponseResult;
import cn.tg.wdog.core.dto.goods.FindSkuDTO;
import cn.tg.wdog.core.service.goods.SkuService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * sku表 前端控制器
 * </p>
 *
 * @author gavinlu
 * @since 2018-12-06
 */
@RestController
@RequestMapping("/goods/sku")
public class SkuController {
    @Autowired
    private SkuService skuService;


    @PostMapping(value = {"/list"})
    @ApiOperation(value = "分页获取数据")
    @SysLogs("分页获取数据")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "Token")
    public ResponseResult get(@RequestBody @Validated @ApiParam(value = "过滤条件") FindSkuDTO findDTO) {
        return ResponseResult.e(ResponseCode.OK, skuService.getAllBySplitPage(findDTO));
    }


    @PostMapping(value = {"/lock/{donationId}"})
    @ApiOperation(value = "状态关闭")
    @SysLogs("关闭公益项目")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "Token")
    public ResponseResult lock(@PathVariable("donationId") @ApiParam(value = "id") String id) {
        skuService.statusChange(id, 0);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/unlock/{donationId}"})
    @ApiOperation(value = "状态开启")
    @SysLogs("解锁用户")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "Token")
    public ResponseResult unlock(@PathVariable("donationId") @ApiParam(value = "id") String id) {
        skuService.statusChange(id, 1);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/goodsType"})
    @ApiOperation(value = "商品类型")
    @SysLogs("类型")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "Token")
    public ResponseResult donationType() {
        return null;
    }

}
