package cn.tg.wdog.core.entity.charitable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gavinlu
 * @since 2018-11-14
 */
@Data
@Accessors(chain = true)
@TableName("donation_one2one")
public class DonationOne2one extends Model<DonationOne2one> {

    @TableId("donation_id")
    private String donationId;

    /**
     * 受捐人姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 捐助类型
     */
    @TableField("donation_type")
    private Integer donationType;

    /**
     * 一对一类型
     */
    @TableField("one2one_type")
    private Integer one2oneType;

    /**
     * 概述
     */
    @TableField("donation_brief")
    private String donationBrief;

    /**
     * 捐助详情
     */
    @TableField("donation_info")
    private String donationInfo;

    /**
     * 区块地址
     */
    @TableField("bl_address")
    private String blAddress;

    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 住址
     */
    private String address;

    /**
     * 家庭情况
     */
    @TableField("home_info")
    private String homeInfo;

    /**
     * 心愿
     */
    private String dream;

    /**
     * 兴趣
     */
    private String interest;

    /**
     * 小图
     */
    @TableField("small_img")
    private String smallImg;

    /**
     * 大图路径
     */
    private String img;

    private Integer status;

    private String operator;

    @TableField("create_time")
    private Date createTime;

    @TableField("modify_time")
    private Date modifyTime;


    @Override
    protected Serializable pkVal() {
        return this.donationId;
    }

}
