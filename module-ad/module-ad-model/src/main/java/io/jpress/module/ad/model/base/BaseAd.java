package io.jpress.module.ad.model.base;

import com.jfinal.plugin.activerecord.IBean;
import io.jpress.base.BaseSortOptionsModel;

/**
 * Generated by JPress, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAd<M extends BaseAd<M>> extends BaseSortOptionsModel<M> implements IBean {

    private static final long serialVersionUID = 1L;

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return getLong("id");
	}

    /**
     * 广告名称
     */
	public void setAdTitle(java.lang.String adTitle) {
		set("ad_title", adTitle);
	}

    /**
     * 广告名称
     */
	public java.lang.String getAdTitle() {
		return getStr("ad_title");
	}

    /**
     * 广告图片链接
     */
	public void setAdImg(java.lang.String adImg) {
		set("ad_img", adImg);
	}

    /**
     * 广告图片链接
     */
	public java.lang.String getAdImg() {
		return getStr("ad_img");
	}

    /**
     * 广告跳转链接
     */
	public void setAdTarget(java.lang.String adTarget) {
		set("ad_target", adTarget);
	}

    /**
     * 广告跳转链接
     */
	public java.lang.String getAdTarget() {
		return getStr("ad_target");
	}

    /**
     * 广告创建者
     */
	public void setCreator(java.lang.String creator) {
		set("creator", creator);
	}

    /**
     * 广告创建者
     */
	public java.lang.String getCreator() {
		return getStr("creator");
	}

    /**
     * 广告创建时间
     */
	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

    /**
     * 广告创建时间
     */
	public java.util.Date getCreateTime() {
		return getDate("create_time");
	}

    /**
     * 广告更新时间
     */
	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}

    /**
     * 广告更新时间
     */
	public java.util.Date getUpdateTime() {
		return getDate("update_time");
	}

    /**
     * 广告开始时间
     */
	public void setStartTime(java.util.Date startTime) {
		set("start_time", startTime);
	}

    /**
     * 广告开始时间
     */
	public java.util.Date getStartTime() {
		return getDate("start_time");
	}

    /**
     * 广告截止时间
     */
	public void setEndTime(java.util.Date endTime) {
		set("end_time", endTime);
	}

    /**
     * 广告截止时间
     */
	public java.util.Date getEndTime() {
		return getDate("end_time");
	}

    /**
     * 排序优先级，0最高
     */
	public void setAdIndex(java.lang.Integer adIndex) {
		set("ad_index", adIndex);
	}

    /**
     * 排序优先级，0最高
     */
	public java.lang.Integer getAdIndex() {
		return getInt("ad_index");
	}

}

