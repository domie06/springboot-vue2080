package com.entity.vo;

import com.entity.ShiguEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 事故
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-23
 */
@TableName("shigu")
public class ShiguVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
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

    @TableField(value = "create_time")
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

}
