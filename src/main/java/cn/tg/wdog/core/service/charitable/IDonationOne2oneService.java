package cn.tg.wdog.core.service.charitable;

import cn.tg.wdog.core.dto.charitable.one2one.FindOne2oneDTO;
import cn.tg.wdog.core.dto.charitable.one2one.One2oneAddDTO;
import cn.tg.wdog.core.dto.charitable.one2one.One2oneUpdateDTO;
import cn.tg.wdog.core.entity.charitable.DonationOne2one;
import cn.tg.wdog.core.vo.system.DonationOne2oneVO;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gavinlu
 * @since 2018-11-14
 */
public interface IDonationOne2oneService extends IService<DonationOne2one> {
    /**
     * 获取所有一对一（分页）
     *
     * @param findOne2OneDTO 过滤条件
     * @return RequestResult
     */
    Page<DonationOne2oneVO> getAllUserBySplitPage(FindOne2oneDTO findOne2OneDTO);

    /**
     * 状态改变
     *
     * @param donationId 序号
     * @param status     状态码
     */
    void statusChange(String donationId, Integer status);

    void add(One2oneAddDTO addDTO);

    DonationOne2one findById(String donationId);

    void update(String donationId, One2oneUpdateDTO updateDTO);

}
