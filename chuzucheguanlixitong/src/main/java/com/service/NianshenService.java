package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NianshenEntity;
import java.util.Map;

/**
 * 年审 服务类
 * @author 
 * @since 2021-03-23
 */
public interface NianshenService extends IService<NianshenEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}