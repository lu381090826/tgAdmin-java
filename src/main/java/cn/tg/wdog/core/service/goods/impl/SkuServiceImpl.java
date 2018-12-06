package cn.tg.wdog.core.service.goods.impl;

import cn.tg.wdog.common.exception.RequestException;
import cn.tg.wdog.core.dto.goods.FindSkuDTO;
import cn.tg.wdog.core.entity.goods.Sku;
import cn.tg.wdog.core.mapper.goods.SkuMapper;
import cn.tg.wdog.core.service.goods.SkuService;
import cn.tg.wdog.core.vo.system.SkuVO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sku表 服务实现类
 * </p>
 *
 * @author gavinlu
 * @since 2018-12-06
 */
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {
    /**
     * 获取所有用户（分页）
     *
     * @param findSkuDTO 过滤条件
     * @return RequestResult
     */
    @Override
    public Page<SkuVO> getAllBySplitPage(FindSkuDTO findSkuDTO) {
        EntityWrapper<Sku> wrapper = new EntityWrapper<>();
        wrapper.orderBy("create_time", findSkuDTO.getAsc());
        Page<Sku> donationOne2onePage = this.selectPage(new Page<>(findSkuDTO.getPage(),
                findSkuDTO.getPageSize()), wrapper);
        Page<SkuVO> skuVOPage = new Page<>();
        BeanUtils.copyProperties(donationOne2onePage, skuVOPage);

        return skuVOPage;
    }

    /**
     * 状态改变
     *
     * @param id 序号
     * @param status     状态码
     */
    @Override
    public void statusChange(String id, Integer status) {
        Sku sku = this.selectById(id);
        if (sku == null) {
            throw RequestException.fail("该公益项目不存在");
        }
        sku.setStatus(String.valueOf(status));
        try {
            this.updateById(sku);
        } catch (Exception e) {
            throw RequestException.fail("操作失败", e);
        }

    }

}
