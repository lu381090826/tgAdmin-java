package cn.tg.wdog.core.mapper.charitable;

import cn.tg.wdog.core.entity.charitable.DonationOne2one;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gavinlu
 * @since 2018-11-14
 */
@Mapper
@Repository
public interface DonationOne2oneMapper extends BaseMapper<DonationOne2one> {

}
