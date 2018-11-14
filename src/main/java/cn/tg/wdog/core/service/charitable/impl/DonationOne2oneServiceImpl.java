package cn.tg.wdog.core.service.charitable.impl;

import cn.tg.wdog.core.dto.charitable.FindDonationOne2oneDTO;
import cn.tg.wdog.core.entity.charitable.DonationOne2one;
import cn.tg.wdog.core.mapper.charitable.DonationOne2oneMapper;
import cn.tg.wdog.core.service.charitable.IDonationOne2oneService;
import cn.tg.wdog.core.vo.system.DonationOne2oneVO;
import cn.tg.wdog.core.vo.system.SysUserVO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gavinlu
 * @since 2018-11-14
 */
@Service
public class DonationOne2oneServiceImpl extends ServiceImpl<DonationOne2oneMapper, DonationOne2one> implements IDonationOne2oneService {

    /**
     * 获取所有用户（分页）
     *
     * @param findDonationOne2oneDTO 过滤条件
     * @return RequestResult
     */
    @Override
    public Page<DonationOne2oneVO> getAllUserBySplitPage(FindDonationOne2oneDTO findDonationOne2oneDTO) {
        EntityWrapper<DonationOne2one> wrapper = new EntityWrapper<>();
        wrapper.orderBy("create_time", findDonationOne2oneDTO.getAsc());
        Page<DonationOne2one> donationOne2onePage = this.selectPage(new Page<>(findDonationOne2oneDTO.getPage(),
                findDonationOne2oneDTO.getPageSize()), wrapper);
        Page<DonationOne2oneVO> one2oneVOPage = new Page<>();
        BeanUtils.copyProperties(donationOne2onePage, one2oneVOPage);

        return one2oneVOPage;
    }
}
