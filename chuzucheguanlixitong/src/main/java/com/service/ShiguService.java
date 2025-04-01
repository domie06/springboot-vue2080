package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShiguEntity;
import java.util.Map;

/**
 * 事故 服务类
 * @author 
 * @since 2021-03-23
 */
public interface ShiguService extends IService<ShiguEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}