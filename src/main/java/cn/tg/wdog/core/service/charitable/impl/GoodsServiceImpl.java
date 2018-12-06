package cn.tg.wdog.core.service.charitable.impl;

import cn.tg.wdog.common.exception.RequestException;
import cn.tg.wdog.core.dto.charitable.FindDonationOne2oneDTO;
import cn.tg.wdog.core.entity.charitable.DonationOne2one;
import cn.tg.wdog.core.mapper.charitable.DonationOne2oneMapper;
import cn.tg.wdog.core.service.charitable.IDonationOne2oneService;
import cn.tg.wdog.core.vo.system.DonationOne2oneVO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gavinlu
 * @since 2018-11-14
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<DonationOne2oneMapper, DonationOne2one> implements IDonationOne2oneService {

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

    /**
     * 状态改变
     *
     * @param donationId 序号
     * @param status     状态码
     */
    @Override
    public void statusChange(String donationId, Integer status) {
        DonationOne2one donationOne2one = this.selectById(donationId);
        if (donationOne2one == null) {
            throw RequestException.fail("该公益项目不存在");
        }
        donationOne2one.setStatus(status);
        try {
            this.updateById(donationOne2one);
        } catch (Exception e) {
            throw RequestException.fail("操作失败", e);
        }

    }
}
