package cn.tg.wdog.core.service.goods.impl;

import cn.tg.wdog.common.bean.GoodsType;
import cn.tg.wdog.common.exception.RequestException;
import cn.tg.wdog.core.dto.goods.FindSkuDTO;
import cn.tg.wdog.core.dto.goods.SkuAddDTO;
import cn.tg.wdog.core.dto.goods.SkuUpdateDTO;
import cn.tg.wdog.core.entity.goods.Sku;
import cn.tg.wdog.core.mapper.goods.SkuMapper;
import cn.tg.wdog.core.service.goods.SkuService;
import cn.tg.wdog.core.vo.system.SkuVO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * sku表 服务实现类
 * </p>
 *
 * @author gavinlu
 * @since 2018-12-06
 */
@Service
@Slf4j
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
        Page<Sku> skuPage = this.selectPage(new Page<>(findSkuDTO.getPage(),
                findSkuDTO.getPageSize()), wrapper);
        Page<SkuVO> skuVOPage = new Page<>();
        BeanUtils.copyProperties(skuPage, skuVOPage);

        return skuVOPage;
    }

    /**
     * 状态改变
     *
     * @param id     序号
     * @param status 状态码
     */
    @Override
    public void statusChange(String id, Integer status) {
        Sku sku = this.selectById(id);
        if (sku == null) {
            throw RequestException.fail("该公益项目不存在");
        }
        sku.setStatus(status);
        try {
            this.updateById(sku);
        } catch (Exception e) {
            log.error("Exception", e);
            throw RequestException.fail("操作失败", e);
        }

    }

    @Override
    public void add(SkuAddDTO addDTO) {
        try {
            Sku sku = new Sku();
            BeanUtils.copyProperties(addDTO, sku);
            sku.setCreateTime(new Date());
            sku.setModifyTime(new Date());
            sku.setShopId(0L);
            sku.setSpuId(0L);
            sku.setSpuId((long) GoodsType.GOODS_TYPE_BOOK.getCode());

            this.insert(sku);

        } catch (Exception e) {
            log.error("Exception", e);
            throw RequestException.fail("添加失败", e);
        }
    }

    @Override
    public void update(String id, SkuUpdateDTO updateDTO) {

    }

    @Override
    public Object findById(String id) {
        try {
            Sku sku = this.selectById(id);
            if (sku == null) {
                return null;
            }

            SkuVO skuVO = new SkuVO();
            BeanUtils.copyProperties(sku, skuVO);
            skuVO.setGoodsType(GoodsType.GOODS_TYPE_BOOK.getCode());
            return skuVO;
        } catch (Exception e) {
            log.error("Exception", e);
            throw RequestException.fail("查询失败", e);
        }

    }

}
