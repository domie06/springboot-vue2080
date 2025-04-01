package com.entity.model;

import com.entity.NianshenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 年审
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-23
 */
public class NianshenModel implements Serializable {
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
     * 年审日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date nianshenTime;


    /**
     * 年审结果
     */
    private Integer nianshenTypes;


    /**
     * 年审费用
     */
    private Integer nianshenNumber;


    /**
     * 年审照片
     */
    private String nianshenPhoto;


    /**
     * 年审备注
     */
    private String nianshenContent;


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
	 * 获取：年审日期
	 */
    public Date getNianshenTime() {
        return nianshenTime;
    }


    /**
	 * 设置：年审日期
	 */
    public void setNianshenTime(Date nianshenTime) {
        this.nianshenTime = nianshenTime;
    }
    /**
	 * 获取：年审结果
	 */
    public Integer getNianshenTypes() {
        return nianshenTypes;
    }


    /**
	 * 设置：年审结果
	 */
    public void setNianshenTypes(Integer nianshenTypes) {
        this.nianshenTypes = nianshenTypes;
    }
    /**
	 * 获取：年审费用
	 */
    public Integer getNianshenNumber() {
        return nianshenNumber;
    }


    /**
	 * 设置：年审费用
	 */
    public void setNianshenNumber(Integer nianshenNumber) {
        this.nianshenNumber = nianshenNumber;
    }
    /**
	 * 获取：年审照片
	 */
    public String getNianshenPhoto() {
        return nianshenPhoto;
    }


    /**
	 * 设置：年审照片
	 */
    public void setNianshenPhoto(String nianshenPhoto) {
        this.nianshenPhoto = nianshenPhoto;
    }
    /**
	 * 获取：年审备注
	 */
    public String getNianshenContent() {
        return nianshenContent;
    }


    /**
	 * 设置：年审备注
	 */
    public void setNianshenContent(String nianshenContent) {
        this.nianshenContent = nianshenContent;
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
