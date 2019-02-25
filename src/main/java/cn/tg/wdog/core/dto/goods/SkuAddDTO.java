package cn.tg.wdog.core.dto.goods;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @author Licoy
 * @version 2018/4/24/16:40
 */
@Data
public class SkuAddDTO {

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

    @NotNull(message = "skuDetail不能为空")
    private String skuDetail;

    /**
     * simpleName
     */
    @NotNull(message = "simpleName不能为空")
    private String simpleName;

    /**
     * 售价
     */
    @NotNull(message = "price不能为空")
    private BigDecimal price;
    /**
     * 售价
     */
    @NotNull(message = "price不能为空")
    private BigDecimal originPrice;
    /**
     * 售价
     */
    @NotNull(message = "units不能为空")
    private String units;

    /**
     * 库存
     */
    @NotNull(message = "stock不能为空")
    private Integer stock;
    /**
     * 库存
     */
    @NotNull(message = "img不能为空")
    private String img;

    /**
     * 商铺id,为0表示自营
     */
//    @NotNull(message = "shopId不能为空")
    private Long shopId;

    /**
     * spu_id
     */
//    @NotNull(message = "spuId不能为空")
    private Long spuId;

    /**
     * 状态0-关闭 1开启
     */
    @NotNull(message = "status不能为空")
    private String status;

}
