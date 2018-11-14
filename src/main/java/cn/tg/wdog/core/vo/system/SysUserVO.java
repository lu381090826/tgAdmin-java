package cn.tg.wdog.core.vo.system;

import cn.tg.wdog.core.entity.system.SysResource;
import cn.tg.wdog.core.entity.system.SysRole;
import cn.tg.wdog.core.entity.system.SysResource;
import cn.tg.wdog.core.entity.system.SysRole;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Licoy
 * @version 2018/4/18/11:34
 */
@Data
public class SysUserVO {

    private String id;
    private String username;
    private Integer age;
    private Integer status;
    private List<SysRole> roles;
    private Date createDate;
    private List<SysResource> resources;

}
