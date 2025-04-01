package com.entity.view;

import com.entity.CarEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-23
 */
@TableName("car")
public class CarView extends CarEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 jiashiyuan
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
				* 性别的值
				*/
				private String sexValue;
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
				* 政治面貌的值
				*/
				private String politicsValue;
			/**
			* 家庭住址
			*/
			private String address;

	public CarView() {

	}

	public CarView(CarEntity carEntity) {
		try {
			BeanUtils.copyProperties(this, carEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}











				//级联表的get和set jiashiyuan
					/**
					* 获取： 驾驶证号
					*/
					public String getCardNumber() {
						return cardNumber;
					}
					/**
					* 设置： 驾驶证号
					*/
					public void setCardNumber(String cardNumber) {
						this.cardNumber = cardNumber;
					}
					/**
					* 获取： 姓名
					*/
					public String getName() {
						return name;
					}
					/**
					* 设置： 姓名
					*/
					public void setName(String name) {
						this.name = name;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 身份证号
					*/
					public String getIdNumber() {
						return idNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setIdNumber(String idNumber) {
						this.idNumber = idNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getPhone() {
						return phone;
					}
					/**
					* 设置： 手机号
					*/
					public void setPhone(String phone) {
						this.phone = phone;
					}
					/**
					* 获取： 照片
					*/
					public String getJiashiyuanPhoto() {
						return jiashiyuanPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setJiashiyuanPhoto(String jiashiyuanPhoto) {
						this.jiashiyuanPhoto = jiashiyuanPhoto;
					}
					/**
					* 获取： 年龄
					*/
					public Integer getAge() {
						return age;
					}
					/**
					* 设置： 年龄
					*/
					public void setAge(Integer age) {
						this.age = age;
					}
					/**
					* 获取： 政治面貌
					*/
					public Integer getPoliticsTypes() {
						return politicsTypes;
					}
					/**
					* 设置： 政治面貌
					*/
					public void setPoliticsTypes(Integer politicsTypes) {
						this.politicsTypes = politicsTypes;
					}


						/**
						* 获取： 政治面貌的值
						*/
						public String getPoliticsValue() {
							return politicsValue;
						}
						/**
						* 设置： 政治面貌的值
						*/
						public void setPoliticsValue(String politicsValue) {
							this.politicsValue = politicsValue;
						}
					/**
					* 获取： 家庭住址
					*/
					public String getAddress() {
						return address;
					}
					/**
					* 设置： 家庭住址
					*/
					public void setAddress(String address) {
						this.address = address;
					}










}
