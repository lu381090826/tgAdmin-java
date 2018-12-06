package cn.tg.wdog.core.vo.system;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * <p>
 * sku表
 * </p>
 *
 * @author gavinlu
 * @since 2018-12-06
 */
@Data
@Accessors(chain = true)
@TableName("goods_sku")
public class SkuVO extends Model<SkuVO> {

    private static final long serialVersionUID = 1L;

    /**
     * sku编号,唯一
     */
    @TableField("sku_no")
    private String skuNo;

    /**
     * sku名称(冗余spu_name)
     */
    @TableField("sku_name")
    private String skuName;

    /**
     * 售价
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 商铺id,为0表示自营
     */
    @TableField("shop_id")
    private Long shopId;

    /**
     * spu_id
     */
    @TableField("spu_id")
    private Long spuId;

    /**
     * 状态0-关闭 1开启
     */
    private String status;

    @TableField("create_time")
    private Date createTime;

    @TableField("modify_time")
    private Date modifyTime;

    private BigInteger id;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
