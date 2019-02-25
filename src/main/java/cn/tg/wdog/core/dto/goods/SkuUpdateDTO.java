package cn.tg.wdog.core.dto.goods;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Licoy
 * @version 2018/4/24/16:40
 */
@Data
public class SkuUpdateDTO {

    /**
     * sku编号,唯一
     */
    @NotNull(message = "skuNo不能为空")
    private String skuNo;

    /**
     * sku名称(冗余spu_name)
     */
    @NotNull(message = "skuName不能为空")
    private String skuName;

    /**
     * simpleName
     */
    @NotNull(message = "simpleName不能为空")
    private String simpleName;

    @NotNull(message = "skuDetail不能为空")
    private String skuDetail;
    /**
     * 售价
     */
    @NotNull(message = "price不能为空")
    private BigDecimal price;

    @NotNull(message = "price不能为空")
    private BigDecimal originPrice;

    /**
     * 库存
     */
    @NotNull(message = "stock不能为空")
    private Integer stock;

    /**
     * 商铺id,为0表示自营
     */
    @NotNull(message = "shopId不能为空")
    private Long shopId;

    /**
     * spu_id
     */
    @NotNull(message = "spuId不能为空")
    private Long spuId;

    /**
     * 状态0-关闭 1开启
     */
    @NotNull(message = "status不能为空")
    private String status;
    /**
     * img
     */
    @NotNull(message = "img不能为空")
    private String img;

    @NotNull(message = "createTime不能为空")
    private Date createTime;

    @NotNull(message = "modifyTime不能为空")
    private Date modifyTime;

}
