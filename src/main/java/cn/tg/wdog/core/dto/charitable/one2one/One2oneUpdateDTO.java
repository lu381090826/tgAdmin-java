package cn.tg.wdog.core.dto.charitable.one2one;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Licoy
 * @version 2018/4/24/16:40
 */
@Data
public class One2oneUpdateDTO {

    @NotBlank(message = "姓名不能为空")
    @Pattern(regexp = "^((\\w)|[\\u4e00-\\u9fa5]){2,16}$", message = "姓名格式不对！")
    private String name;

    @NotNull(message = "年龄不能为空")
    private Integer age;

    @NotNull(message = "状态标识不能为空")
    private Integer status;

    @NotNull(message = "性别不能为空")
    private String sex;

    @NotNull(message = "一对一捐助类型不能为空")
    private Integer one2oneType;

    @NotNull(message = "概述不能为空")
    private String donationBrief;

    @NotNull(message = "捐助详情不能为空")
    private String donationInfo;

    @NotNull(message = "区块地址不能为空")
    private String blAddress;

    @NotNull(message = "省份不能为空")
    private String province;

    @NotNull(message = "城市不能为空")
    private String city;

    private String address;

    private String homeInfo;

    private String dream;

    private String interest;

    @NotNull(message = "小图不能为空")
    private String smallImg;

    @NotNull(message = "大图不能为空")
    private String img;
}
