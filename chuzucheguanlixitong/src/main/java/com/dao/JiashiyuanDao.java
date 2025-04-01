package com.dao;

import com.entity.JiashiyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiashiyuanView;

/**
 * 驾驶员 Dao 接口
 *
 * @author 
 * @since 2021-03-23
 */
public interface JiashiyuanDao extends BaseMapper<JiashiyuanEntity> {

   List<JiashiyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
