package cn.tg.wdog.core.entity.goods;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;


import lombok.Data;
import lombok.experimental.Accessors;

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
public class Sku extends Model<Sku> {

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
     * simple_name
     */
    @TableField("simple_name")
    private String simpleName;

    @TableField("sku_detail")
    private String skuDetail;

    /**
     * 售价
     */
    private BigDecimal price;

    private BigDecimal originPrice;

    private BigDecimal originPriceCn;

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
    @TableField("status")
    private Integer status;

    @TableField("create_time")
    private Date createTime;

    @TableField("modify_time")
    private Date modifyTime;

    @TableId("id")
    private String id;

    @TableField("img")
    private String img;

    @TableField("img_small")
    private String imgSmall;

    @TableField("units")
    private String units;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
