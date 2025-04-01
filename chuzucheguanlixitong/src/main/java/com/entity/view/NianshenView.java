package com.entity.view;

import com.entity.NianshenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 年审
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-23
 */
@TableName("nianshen")
public class NianshenView extends NianshenEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 年审结果的值
		*/
		private String nianshenValue;



		//级联表 car
			/**
			* 驾驶员
			*/
			private Integer jiashiyuanId;
			/**
			* 车牌号
			*/
			private String carNumber;
			/**
			* 车架号
			*/
			private String chejiaNumber;
			/**
			* 购买日期
			*/
			private Date goumaiTime;
			/**
			* 车辆备注
			*/
			private String carContent;

	public NianshenView() {

	}

	public NianshenView(NianshenEntity nianshenEntity) {
		try {
			BeanUtils.copyProperties(this, nianshenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 年审结果的值
			*/
			public String getNianshenValue() {
				return nianshenValue;
			}
			/**
			* 设置： 年审结果的值
			*/
			public void setNianshenValue(String nianshenValue) {
				this.nianshenValue = nianshenValue;
			}




				//级联表的get和set car
					/**
					* 获取： 驾驶员
					*/
					public Integer getJiashiyuanId() {
						return jiashiyuanId;
					}
					/**
					* 设置： 驾驶员
					*/
					public void setJiashiyuanId(Integer jiashiyuanId) {
						this.jiashiyuanId = jiashiyuanId;
					}
					/**
					* 获取： 车牌号
					*/
					public String getCarNumber() {
						return carNumber;
					}
					/**
					* 设置： 车牌号
					*/
					public void setCarNumber(String carNumber) {
						this.carNumber = carNumber;
					}
					/**
					* 获取： 车架号
					*/
					public String getChejiaNumber() {
						return chejiaNumber;
					}
					/**
					* 设置： 车架号
					*/
					public void setChejiaNumber(String chejiaNumber) {
						this.chejiaNumber = chejiaNumber;
					}
					/**
					* 获取： 购买日期
					*/
					public Date getGoumaiTime() {
						return goumaiTime;
					}
					/**
					* 设置： 购买日期
					*/
					public void setGoumaiTime(Date goumaiTime) {
						this.goumaiTime = goumaiTime;
					}
					/**
					* 获取： 车辆备注
					*/
					public String getCarContent() {
						return carContent;
					}
					/**
					* 设置： 车辆备注
					*/
					public void setCarContent(String carContent) {
						this.carContent = carContent;
					}














}
