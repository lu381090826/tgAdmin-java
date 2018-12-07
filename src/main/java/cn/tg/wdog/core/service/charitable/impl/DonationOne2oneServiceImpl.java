package cn.tg.wdog.core.service.charitable.impl;

import cn.tg.wdog.common.bean.DonationType;
import cn.tg.wdog.common.exception.RequestException;
import cn.tg.wdog.core.dto.charitable.one2one.FindOne2oneDTO;
import cn.tg.wdog.core.dto.charitable.one2one.One2oneAddDTO;
import cn.tg.wdog.core.dto.charitable.one2one.One2oneUpdateDTO;
import cn.tg.wdog.core.entity.charitable.DonationOne2one;
import cn.tg.wdog.core.mapper.charitable.DonationOne2oneMapper;
import cn.tg.wdog.core.service.charitable.IDonationOne2oneService;
import cn.tg.wdog.core.vo.system.DonationOne2oneVO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

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
     * @param findOne2OneDTO 过滤条件
     * @return RequestResult
     */
    @Override
    public Page<DonationOne2oneVO> getAllUserBySplitPage(FindOne2oneDTO findOne2OneDTO) {
        EntityWrapper<DonationOne2one> wrapper = new EntityWrapper<>();
        wrapper.orderBy("create_time", findOne2OneDTO.getAsc());
        Page<DonationOne2one> donationOne2onePage = this.selectPage(new Page<>(findOne2OneDTO.getPage(),
                findOne2OneDTO.getPageSize()), wrapper);
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

    @Override
    public void add(One2oneAddDTO addDTO) {

        try {
            DonationOne2one donationOne2one = new DonationOne2one();
            BeanUtils.copyProperties(addDTO, donationOne2one);
            donationOne2one.setCreateTime(new Date());
            donationOne2one.setModifyTime(new Date());
            donationOne2one.setDonationType(DonationType.DONATION_ONE_2_ONE.getCode());

            this.insert(donationOne2one);

        } catch (Exception e) {
            throw RequestException.fail("添加用户失败", e);
        }
    }

    @Override
    public DonationOne2one findById(String donationId) {
        DonationOne2one donationOne2one = this.selectById(donationId);
        if (donationOne2one == null) {
            return null;
        }
        return donationOne2one;
    }

    @Override
    public void update(String donationId, One2oneUpdateDTO updateDTO) {
        DonationOne2one donationOne2one = this.selectById(donationId);
        if (donationOne2one == null) {
            throw RequestException.fail(
                    String.format("更新失败，不存在ID为 %s 的捐款项目", donationId));
        }
        BeanUtils.copyProperties(updateDTO, donationOne2one);
        try {
            this.updateById(donationOne2one);
        } catch (RequestException e) {
            throw RequestException.fail(e.getMsg(), e);
        } catch (Exception e) {
            throw RequestException.fail("捐款信息更新失败", e);
        }

    }
}
