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

    /**
     * sku编号,唯一
     */
    private String skuNo;

    /**
     * sku名称(冗余spu_name)
     */
    private String skuName;

    /**
     * simpleName
     */
    private String simpleName;

    private String skuDetail;

    /**
     * 售价
     */
    private BigDecimal price;
    private BigDecimal originPrice;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 商铺id,为0表示自营
     */
    private Long shopId;

    /**
     * spu_id
     */
    private Long spuId;

    /**
     * 状态0-关闭 1开启
     */
    private Integer status;

    private Date createTime;

    private Date modifyTime;

    private String id;

    private String img;

    private String units;

    private Integer goodsType;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
