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
 * 车辆
 *
 * @author 
 * @email
 * @date 2021-03-23
 */
@TableName("car")
public class CarEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CarEntity() {

	}

	public CarEntity(T t) {
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
     * 驾驶员
     */
    @TableField(value = "jiashiyuan_id")

    private Integer jiashiyuanId;


    /**
     * 车牌号
     */
    @TableField(value = "car_number")

    private String carNumber;


    /**
     * 车架号
     */
    @TableField(value = "chejia_number")

    private String chejiaNumber;


    /**
     * 购买日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "goumai_time",fill = FieldFill.UPDATE)

    private Date goumaiTime;


    /**
     * 车辆备注
     */
    @TableField(value = "car_content")

    private String carContent;


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
	 * 设置：驾驶员
	 */
    public Integer getJiashiyuanId() {
        return jiashiyuanId;
    }


    /**
	 * 获取：驾驶员
	 */

    public void setJiashiyuanId(Integer jiashiyuanId) {
        this.jiashiyuanId = jiashiyuanId;
    }
    /**
	 * 设置：车牌号
	 */
    public String getCarNumber() {
        return carNumber;
    }


    /**
	 * 获取：车牌号
	 */

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    /**
	 * 设置：车架号
	 */
    public String getChejiaNumber() {
        return chejiaNumber;
    }


    /**
	 * 获取：车架号
	 */

    public void setChejiaNumber(String chejiaNumber) {
        this.chejiaNumber = chejiaNumber;
    }
    /**
	 * 设置：购买日期
	 */
    public Date getGoumaiTime() {
        return goumaiTime;
    }


    /**
	 * 获取：购买日期
	 */

    public void setGoumaiTime(Date goumaiTime) {
        this.goumaiTime = goumaiTime;
    }
    /**
	 * 设置：车辆备注
	 */
    public String getCarContent() {
        return carContent;
    }


    /**
	 * 获取：车辆备注
	 */

    public void setCarContent(String carContent) {
        this.carContent = carContent;
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
        return "Car{" +
            "id=" + id +
            ", jiashiyuanId=" + jiashiyuanId +
            ", carNumber=" + carNumber +
            ", chejiaNumber=" + chejiaNumber +
            ", goumaiTime=" + goumaiTime +
            ", carContent=" + carContent +
            ", createTime=" + createTime +
        "}";
    }
}
