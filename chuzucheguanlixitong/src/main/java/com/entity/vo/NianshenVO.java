package com.entity.vo;

import com.entity.NianshenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 年审
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-23
 */
@TableName("nianshen")
public class NianshenVO implements Serializable {
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
     * 年审日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "nianshen_time")
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

}
