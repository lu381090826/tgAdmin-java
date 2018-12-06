package cn.tg.wdog.core.service.charitable;

import cn.tg.wdog.core.dto.charitable.FindDonationOne2oneDTO;
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
@Service
public interface IDonationOne2oneService extends IService<DonationOne2one> {
    /**
     * 获取所有一对一（分页）
     *
     * @param findDonationOne2oneDTO 过滤条件
     * @return RequestResult
     */
    Page<DonationOne2oneVO> getAllUserBySplitPage(FindDonationOne2oneDTO findDonationOne2oneDTO);

    /**
     * 状态改变
     * @param donationId 序号
     * @param status 状态码
     */
    void statusChange(String donationId, Integer status);

}
