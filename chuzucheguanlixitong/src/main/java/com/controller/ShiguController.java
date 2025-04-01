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

import com.entity.ShiguEntity;

import com.service.ShiguService;
import com.entity.view.ShiguView;
import com.service.CarService;
import com.entity.CarEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 事故
 * 后端接口
 * @author
 * @email
 * @date 2021-03-23
*/
@RestController
@Controller
@RequestMapping("/shigu")
public class ShiguController {
    private static final Logger logger = LoggerFactory.getLogger(ShiguController.class);

    @Autowired
    private ShiguService shiguService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private CarService carService;


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
        PageUtils page = shiguService.queryPage(params);

        //字典表数据转换
        List<ShiguView> list =(List<ShiguView>)page.getList();
        for(ShiguView c:list){
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
        ShiguEntity shigu = shiguService.selectById(id);
        if(shigu !=null){
            //entity转view
            ShiguView view = new ShiguView();
            BeanUtils.copyProperties( shigu , view );//把实体数据重构到view中

            //级联表
            CarEntity car = carService.selectById(shigu.getCarId());
            if(car != null){
                BeanUtils.copyProperties( car , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setCarId(car.getId());
            }
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
    public R save(@RequestBody ShiguEntity shigu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shigu:{}",this.getClass().getName(),shigu.toString());
        Date date = new Date();
        shigu.setInsertTime(date);
        shigu.setCreateTime(date);
        shiguService.insert(shigu);
        return R.ok();
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShiguEntity shigu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shigu:{}",this.getClass().getName(),shigu.toString());
        shiguService.updateById(shigu);//根据id更新
        return R.ok();
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shiguService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

