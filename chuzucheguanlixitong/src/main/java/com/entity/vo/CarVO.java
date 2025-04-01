package com.entity.vo;

import com.entity.CarEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车辆
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-23
 */
@TableName("car")
public class CarVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "goumai_time")
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

}
