package com.controller;


import java.text.DateFormat;
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

import com.entity.NianshenEntity;

import com.service.NianshenService;
import com.entity.view.NianshenView;
import com.service.CarService;
import com.entity.CarEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 年审
 * 后端接口
 * @author
 * @email
 * @date 2021-03-23
*/
@RestController
@Controller
@RequestMapping("/nianshen")
public class NianshenController {
    private static final Logger logger = LoggerFactory.getLogger(NianshenController.class);

    @Autowired
    private NianshenService nianshenService;


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
        PageUtils page = nianshenService.queryPage(params);

        //字典表数据转换
        List<NianshenView> list =(List<NianshenView>)page.getList();
        for(NianshenView c:list){
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
        NianshenEntity nianshen = nianshenService.selectById(id);
        if(nianshen !=null){
            //entity转view
            NianshenView view = new NianshenView();
            BeanUtils.copyProperties( nianshen , view );//把实体数据重构到view中

            //级联表
            CarEntity car = carService.selectById(nianshen.getCarId());
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
    public R save(@RequestBody NianshenEntity nianshen, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,nianshen:{}",this.getClass().getName(),nianshen.toString());
        List<NianshenEntity> lists = nianshenService.selectList(new EntityWrapper<NianshenEntity>().eq("car_id", nianshen.getCarId()));
        boolean flag = true;
        DateFormat format = new SimpleDateFormat("yyyy");
        Date newDate = nianshen.getNianshenTime();
        String newDateString = format.format(newDate);
        for(NianshenEntity l:lists){
            Date nianshenTime = l.getNianshenTime();
            String oldNianshenString = format.format(nianshenTime);
            if(newDateString.equals(oldNianshenString)){
                flag = false;
            }
        }
        if(flag){
            nianshen.setCreateTime(new Date());
            nianshenService.insert(nianshen);
            return R.ok();
        }else {
            return R.error(511,"该车辆"+newDateString+"年已经进行过年审");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NianshenEntity nianshen, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,nianshen:{}",this.getClass().getName(),nianshen.toString());
        //根据字段查询是否有相同数据
        List<NianshenEntity> lists = nianshenService.selectList(new EntityWrapper<NianshenEntity>().notIn("id",nianshen.getId()).andNew().eq("car_id", nianshen.getCarId()));
        boolean flag = true;
        DateFormat format = new SimpleDateFormat("yyyy");
        Date newDate = nianshen.getNianshenTime();
        String newDateString = format.format(newDate);
        for(NianshenEntity l:lists){
            Date nianshenTime = l.getNianshenTime();
            String oldNianshenString = format.format(nianshenTime);
            if(newDateString.equals(oldNianshenString)){
                flag = false;
            }
        }
        if(flag){
            nianshenService.updateById(nianshen);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该车辆"+newDateString+"年已经进行过年审");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        nianshenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

