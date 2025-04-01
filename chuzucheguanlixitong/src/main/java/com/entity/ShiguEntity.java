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
 * 事故
 *
 * @author 
 * @email
 * @date 2021-03-23
 */
@TableName("shigu")
public class ShiguEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShiguEntity() {

	}

	public ShiguEntity(T t) {
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
     * 事故时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 事故类型
     */
    @TableField(value = "shigu_types")

    private Integer shiguTypes;


    /**
     * 事故照片
     */
    @TableField(value = "shigu_photo")

    private String shiguPhoto;


    /**
     * 是否处理
     */
    @TableField(value = "shiguchuli_types")

    private Integer shiguchuliTypes;


    /**
     * 事故备注
     */
    @TableField(value = "shigu_content")

    private String shiguContent;


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
	 * 设置：事故时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：事故时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：事故类型
	 */
    public Integer getShiguTypes() {
        return shiguTypes;
    }


    /**
	 * 获取：事故类型
	 */

    public void setShiguTypes(Integer shiguTypes) {
        this.shiguTypes = shiguTypes;
    }
    /**
	 * 设置：事故照片
	 */
    public String getShiguPhoto() {
        return shiguPhoto;
    }


    /**
	 * 获取：事故照片
	 */

    public void setShiguPhoto(String shiguPhoto) {
        this.shiguPhoto = shiguPhoto;
    }
    /**
	 * 设置：是否处理
	 */
    public Integer getShiguchuliTypes() {
        return shiguchuliTypes;
    }


    /**
	 * 获取：是否处理
	 */

    public void setShiguchuliTypes(Integer shiguchuliTypes) {
        this.shiguchuliTypes = shiguchuliTypes;
    }
    /**
	 * 设置：事故备注
	 */
    public String getShiguContent() {
        return shiguContent;
    }


    /**
	 * 获取：事故备注
	 */

    public void setShiguContent(String shiguContent) {
        this.shiguContent = shiguContent;
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
        return "Shigu{" +
            "id=" + id +
            ", carId=" + carId +
            ", insertTime=" + insertTime +
            ", shiguTypes=" + shiguTypes +
            ", shiguPhoto=" + shiguPhoto +
            ", shiguchuliTypes=" + shiguchuliTypes +
            ", shiguContent=" + shiguContent +
            ", createTime=" + createTime +
        "}";
    }
}
