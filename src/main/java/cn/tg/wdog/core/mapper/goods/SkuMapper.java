package cn.tg.wdog.core.mapper.goods;

import cn.tg.wdog.core.entity.goods.Sku;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * sku表 Mapper 接口
 * </p>
 *
 * @author gavinlu
 * @since 2018-12-06
 */
@Mapper
@Repository
public interface SkuMapper extends BaseMapper<Sku> {

}
