package com.entity.model;

import com.entity.JiashiyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 驾驶员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-23
 */
public class JiashiyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 驾驶证号
     */
    private String cardNumber;


    /**
     * 姓名
     */
    private String name;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 身份证号
     */
    private String idNumber;


    /**
     * 手机号
     */
    private String phone;


    /**
     * 照片
     */
    private String jiashiyuanPhoto;


    /**
     * 年龄
     */
    private Integer age;


    /**
     * 政治面貌
     */
    private Integer politicsTypes;


    /**
     * 家庭住址
     */
    private String address;


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
	 * 获取：驾驶证号
	 */
    public String getCardNumber() {
        return cardNumber;
    }


    /**
	 * 设置：驾驶证号
	 */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    /**
	 * 获取：姓名
	 */
    public String getName() {
        return name;
    }


    /**
	 * 设置：姓名
	 */
    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：身份证号
	 */
    public String getIdNumber() {
        return idNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    /**
	 * 获取：手机号
	 */
    public String getPhone() {
        return phone;
    }


    /**
	 * 设置：手机号
	 */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
	 * 获取：照片
	 */
    public String getJiashiyuanPhoto() {
        return jiashiyuanPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setJiashiyuanPhoto(String jiashiyuanPhoto) {
        this.jiashiyuanPhoto = jiashiyuanPhoto;
    }
    /**
	 * 获取：年龄
	 */
    public Integer getAge() {
        return age;
    }


    /**
	 * 设置：年龄
	 */
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
	 * 获取：政治面貌
	 */
    public Integer getPoliticsTypes() {
        return politicsTypes;
    }


    /**
	 * 设置：政治面貌
	 */
    public void setPoliticsTypes(Integer politicsTypes) {
        this.politicsTypes = politicsTypes;
    }
    /**
	 * 获取：家庭住址
	 */
    public String getAddress() {
        return address;
    }


    /**
	 * 设置：家庭住址
	 */
    public void setAddress(String address) {
        this.address = address;
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
