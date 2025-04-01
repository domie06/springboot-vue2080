package com.entity.model;

import com.entity.ShiguEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 事故
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-23
 */
public class ShiguModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车辆
     */
    private Integer carId;


    /**
     * 事故时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 事故类型
     */
    private Integer shiguTypes;


    /**
     * 事故照片
     */
    private String shiguPhoto;


    /**
     * 是否处理
     */
    private Integer shiguchuliTypes;


    /**
     * 事故备注
     */
    private String shiguContent;


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
	 * 获取：车辆
	 */
    public Integer getCarId() {
        return carId;
    }


    /**
	 * 设置：车辆
	 */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }
    /**
	 * 获取：事故时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：事故时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：事故类型
	 */
    public Integer getShiguTypes() {
        return shiguTypes;
    }


    /**
	 * 设置：事故类型
	 */
    public void setShiguTypes(Integer shiguTypes) {
        this.shiguTypes = shiguTypes;
    }
    /**
	 * 获取：事故照片
	 */
    public String getShiguPhoto() {
        return shiguPhoto;
    }


    /**
	 * 设置：事故照片
	 */
    public void setShiguPhoto(String shiguPhoto) {
        this.shiguPhoto = shiguPhoto;
    }
    /**
	 * 获取：是否处理
	 */
    public Integer getShiguchuliTypes() {
        return shiguchuliTypes;
    }


    /**
	 * 设置：是否处理
	 */
    public void setShiguchuliTypes(Integer shiguchuliTypes) {
        this.shiguchuliTypes = shiguchuliTypes;
    }
    /**
	 * 获取：事故备注
	 */
    public String getShiguContent() {
        return shiguContent;
    }


    /**
	 * 设置：事故备注
	 */
    public void setShiguContent(String shiguContent) {
        this.shiguContent = shiguContent;
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
