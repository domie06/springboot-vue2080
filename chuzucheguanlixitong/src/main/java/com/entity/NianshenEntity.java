package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 年审
 *
 * @author 
 * @email
 * @date 2021-03-23
 */
@TableName("nianshen")
public class NianshenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NianshenEntity() {

	}

	public NianshenEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 车辆
     */
    @TableField(value = "car_id")

    private Integer carId;


    /**
     * 年审日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "nianshen_time",fill = FieldFill.UPDATE)

    private Date nianshenTime;


    /**
     * 年审结果
     */
    @TableField(value = "nianshen_types")

    private Integer nianshenTypes;


    /**
     * 年审费用
     */
    @TableField(value = "nianshen_number")

    private Integer nianshenNumber;


    /**
     * 年审照片
     */
    @TableField(value = "nianshen_photo")

    private String nianshenPhoto;


    /**
     * 年审备注
     */
    @TableField(value = "nianshen_content")

    private String nianshenContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：车辆
	 */
    public Integer getCarId() {
        return carId;
    }


    /**
	 * 获取：车辆
	 */

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
    /**
	 * 设置：年审日期
	 */
    public Date getNianshenTime() {
        return nianshenTime;
    }


    /**
	 * 获取：年审日期
	 */

    public void setNianshenTime(Date nianshenTime) {
        this.nianshenTime = nianshenTime;
    }
    /**
	 * 设置：年审结果
	 */
    public Integer getNianshenTypes() {
        return nianshenTypes;
    }


    /**
	 * 获取：年审结果
	 */

    public void setNianshenTypes(Integer nianshenTypes) {
        this.nianshenTypes = nianshenTypes;
    }
    /**
	 * 设置：年审费用
	 */
    public Integer getNianshenNumber() {
        return nianshenNumber;
    }


    /**
	 * 获取：年审费用
	 */

    public void setNianshenNumber(Integer nianshenNumber) {
        this.nianshenNumber = nianshenNumber;
    }
    /**
	 * 设置：年审照片
	 */
    public String getNianshenPhoto() {
        return nianshenPhoto;
    }


    /**
	 * 获取：年审照片
	 */

    public void setNianshenPhoto(String nianshenPhoto) {
        this.nianshenPhoto = nianshenPhoto;
    }
    /**
	 * 设置：年审备注
	 */
    public String getNianshenContent() {
        return nianshenContent;
    }


    /**
	 * 获取：年审备注
	 */

    public void setNianshenContent(String nianshenContent) {
        this.nianshenContent = nianshenContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Nianshen{" +
            "id=" + id +
            ", carId=" + carId +
            ", nianshenTime=" + nianshenTime +
            ", nianshenTypes=" + nianshenTypes +
            ", nianshenNumber=" + nianshenNumber +
            ", nianshenPhoto=" + nianshenPhoto +
            ", nianshenContent=" + nianshenContent +
            ", createTime=" + createTime +
        "}";
    }
}
