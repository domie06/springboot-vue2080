package com.entity.model;

import com.entity.CarEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车辆
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-23
 */
public class CarModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 驾驶员
     */
    private Integer jiashiyuanId;


    /**
     * 车牌号
     */
    private String carNumber;


    /**
     * 车架号
     */
    private String chejiaNumber;


    /**
     * 购买日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date goumaiTime;


    /**
     * 车辆备注
     */
    private String carContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：驾驶员
	 */
    public Integer getJiashiyuanId() {
        return jiashiyuanId;
    }


    /**
	 * 设置：驾驶员
	 */
    public void setJiashiyuanId(Integer jiashiyuanId) {
        this.jiashiyuanId = jiashiyuanId;
    }
    /**
	 * 获取：车牌号
	 */
    public String getCarNumber() {
        return carNumber;
    }


    /**
	 * 设置：车牌号
	 */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    /**
	 * 获取：车架号
	 */
    public String getChejiaNumber() {
        return chejiaNumber;
    }


    /**
	 * 设置：车架号
	 */
    public void setChejiaNumber(String chejiaNumber) {
        this.chejiaNumber = chejiaNumber;
    }
    /**
	 * 获取：购买日期
	 */
    public Date getGoumaiTime() {
        return goumaiTime;
    }


    /**
	 * 设置：购买日期
	 */
    public void setGoumaiTime(Date goumaiTime) {
        this.goumaiTime = goumaiTime;
    }
    /**
	 * 获取：车辆备注
	 */
    public String getCarContent() {
        return carContent;
    }


    /**
	 * 设置：车辆备注
	 */
    public void setCarContent(String carContent) {
        this.carContent = carContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
