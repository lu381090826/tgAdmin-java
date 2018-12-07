package cn.tg.wdog.core.service.goods;

import cn.tg.wdog.core.dto.goods.FindSkuDTO;
import cn.tg.wdog.core.dto.goods.SkuAddDTO;
import cn.tg.wdog.core.dto.goods.SkuUpdateDTO;
import cn.tg.wdog.core.entity.goods.Sku;
import cn.tg.wdog.core.vo.system.SkuVO;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * sku表 服务类
 * </p>
 *
 * @author gavinlu
 * @since 2018-12-06
 */
public interface SkuService extends IService<Sku> {
    /**
     * 获取（分页）数据
     *
     * @param findSkuDTO 过滤条件
     * @return RequestResult
     */
    Page<SkuVO> getAllBySplitPage(FindSkuDTO findSkuDTO);

    /**
     * 状态改变
     *
     * @param id     序号
     * @param status 状态码
     */
    void statusChange(String id, Integer status);

    void add(SkuAddDTO addDTO);

    void update(String id, SkuUpdateDTO updateDTO);

    Object findById(String id);

}
