package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JiashiyuanEntity;

import com.service.JiashiyuanService;
import com.entity.view.JiashiyuanView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 驾驶员
 * 后端接口
 * @author
 * @email
 * @date 2021-03-23
*/
@RestController
@Controller
@RequestMapping("/jiashiyuan")
public class JiashiyuanController {
    private static final Logger logger = LoggerFactory.getLogger(JiashiyuanController.class);

    @Autowired
    private JiashiyuanService jiashiyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = jiashiyuanService.queryPage(params);

        //字典表数据转换
        List<JiashiyuanView> list =(List<JiashiyuanView>)page.getList();
        for(JiashiyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiashiyuanEntity jiashiyuan = jiashiyuanService.selectById(id);
        if(jiashiyuan !=null){
            //entity转view
            JiashiyuanView view = new JiashiyuanView();
            BeanUtils.copyProperties( jiashiyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiashiyuanEntity jiashiyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiashiyuan:{}",this.getClass().getName(),jiashiyuan.toString());
        Wrapper<JiashiyuanEntity> queryWrapper = new EntityWrapper<JiashiyuanEntity>()
            .eq("card_number", jiashiyuan.getCardNumber())
            .or()
            .eq("id_number", jiashiyuan.getIdNumber())
            .or()
            .eq("phone", jiashiyuan.getPhone());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiashiyuanEntity jiashiyuanEntity = jiashiyuanService.selectOne(queryWrapper);
        if(jiashiyuanEntity==null){
            jiashiyuan.setCreateTime(new Date());
            jiashiyuanService.insert(jiashiyuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiashiyuanEntity jiashiyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiashiyuan:{}",this.getClass().getName(),jiashiyuan.toString());
        //根据字段查询是否有相同数据
        Wrapper<JiashiyuanEntity> queryWrapper = new EntityWrapper<JiashiyuanEntity>()
            .notIn("id",jiashiyuan.getId())
            .andNew()
            .eq("card_number", jiashiyuan.getCardNumber())
            .or()
            .eq("id_number", jiashiyuan.getIdNumber())
            .or()
            .eq("phone", jiashiyuan.getPhone());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiashiyuanEntity jiashiyuanEntity = jiashiyuanService.selectOne(queryWrapper);
        if("".equals(jiashiyuan.getJiashiyuanPhoto()) || "null".equals(jiashiyuan.getJiashiyuanPhoto())){
                jiashiyuan.setJiashiyuanPhoto(null);
        }
        if(jiashiyuanEntity==null){
            jiashiyuanService.updateById(jiashiyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiashiyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

