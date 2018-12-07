package cn.tg.wdog.core.controller.shop;


import cn.tg.wdog.common.annotation.SysLogs;
import cn.tg.wdog.common.bean.ResponseCode;
import cn.tg.wdog.common.bean.ResponseResult;
import cn.tg.wdog.core.dto.goods.FindSkuDTO;
import cn.tg.wdog.core.dto.goods.SkuAddDTO;
import cn.tg.wdog.core.dto.goods.SkuUpdateDTO;
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
@RequestMapping("/shop/sku")
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

    @PostMapping(value = {"/get/id/{donationId}"})
    @ApiOperation(value = "关闭公益项目")
    @SysLogs("关闭公益项目")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult get(@PathVariable("donationId") @ApiParam(value = "id") String id) {
        return ResponseResult.e(ResponseCode.OK, skuService.findById(id));
    }

    @PostMapping(value = {"/lock/{id}"})
    @ApiOperation(value = "状态关闭")
    @SysLogs("关闭公益项目")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "Token")
    public ResponseResult lock(@PathVariable("id") @ApiParam(value = "id") String id) {
        skuService.statusChange(id, 0);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/unlock/{id}"})
    @ApiOperation(value = "状态开启")
    @SysLogs("解锁用户")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "Token")
    public ResponseResult unlock(@PathVariable("id") @ApiParam(value = "id") String id) {
        skuService.statusChange(id, 1);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/goodsType"})
    @ApiOperation(value = "商品类型")
    @SysLogs("类型")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "Token")
    public ResponseResult goodsType() {
        return null;
    }

    @PostMapping(value = {"/add"})
    @ApiOperation(value = "添加数据")
    @SysLogs("添加一对一捐助")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult add(@RequestBody @Validated @ApiParam(value = "添加数据") SkuAddDTO addDTO) {
        skuService.add(addDTO);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/update/{id}"})
    @ApiOperation(value = "更新用户")
    @SysLogs("更新用户")
    @ApiImplicitParam(paramType = "header", name = "Authorization", value = "身份认证Token")
    public ResponseResult update(@PathVariable("id") @ApiParam(value = "主键") String id,
                                 @RequestBody @Validated @ApiParam(value = "一对一捐款数据") SkuUpdateDTO updateDTO) {
        skuService.update(id, updateDTO);
        return ResponseResult.e(ResponseCode.OK);
    }

}
