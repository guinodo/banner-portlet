/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package br.com.seatecnologia.banner.model;

/**
 * <p>
 * This class is a wrapper for {@link Banner}.
 * </p>
 *
 * @author    Oney
 * @see       Banner
 * @generated
 */
public class BannerWrapper implements Banner {
	public BannerWrapper(Banner banner) {
		_banner = banner;
	}

	public Class<?> getModelClass() {
		return Banner.class;
	}

	public String getModelClassName() {
		return Banner.class.getName();
	}

	/**
	* Gets the primary key of this banner.
	*
	* @return the primary key of this banner
	*/
	public long getPrimaryKey() {
		return _banner.getPrimaryKey();
	}

	/**
	* Sets the primary key of this banner
	*
	* @param primaryKey the primary key of this banner
	*/
	public void setPrimaryKey(long primaryKey) {
		_banner.setPrimaryKey(primaryKey);
	}

	/**
	* Gets the banner ID of this banner.
	*
	* @return the banner ID of this banner
	*/
	public long getBannerId() {
		return _banner.getBannerId();
	}

	/**
	* Sets the banner ID of this banner.
	*
	* @param bannerId the banner ID of this banner
	*/
	public void setBannerId(long bannerId) {
		_banner.setBannerId(bannerId);
	}

	/**
	* Gets the name of this banner.
	*
	* @return the name of this banner
	*/
	public java.lang.String getName() {
		return _banner.getName();
	}

	/**
	* Sets the name of this banner.
	*
	* @param name the name of this banner
	*/
	public void setName(java.lang.String name) {
		_banner.setName(name);
	}

	/**
	* Gets the title of this banner.
	*
	* @return the title of this banner
	*/
	public java.lang.String getTitle() {
		return _banner.getTitle();
	}

	/**
	* Sets the title of this banner.
	*
	* @param title the title of this banner
	*/
	public void setTitle(java.lang.String title) {
		_banner.setTitle(title);
	}

	/**
	* Gets the description of this banner.
	*
	* @return the description of this banner
	*/
	public java.lang.String getDescription() {
		return _banner.getDescription();
	}

	/**
	* Sets the description of this banner.
	*
	* @param description the description of this banner
	*/
	public void setDescription(java.lang.String description) {
		_banner.setDescription(description);
	}

	/**
	* Gets the link of this banner.
	*
	* @return the link of this banner
	*/
	public java.lang.String getLink() {
		return _banner.getLink();
	}

	/**
	* Sets the link of this banner.
	*
	* @param link the link of this banner
	*/
	public void setLink(java.lang.String link) {
		_banner.setLink(link);
	}

	/**
	* Gets the image of this banner.
	*
	* @return the image of this banner
	*/
	public java.lang.String getImage() {
		return _banner.getImage();
	}

	/**
	* Sets the image of this banner.
	*
	* @param image the image of this banner
	*/
	public void setImage(java.lang.String image) {
		_banner.setImage(image);
	}

	/**
	* Gets the position of this banner.
	*
	* @return the position of this banner
	*/
	public int getPosition() {
		return _banner.getPosition();
	}

	/**
	* Sets the position of this banner.
	*
	* @param position the position of this banner
	*/
	public void setPosition(int position) {
		_banner.setPosition(position);
	}

	/**
	* Gets the type of this banner.
	*
	* @return the type of this banner
	*/
	public int getType() {
		return _banner.getType();
	}

	/**
	* Sets the type of this banner.
	*
	* @param type the type of this banner
	*/
	public void setType(int type) {
		_banner.setType(type);
	}

	/**
	* Gets the status of this banner.
	*
	* @return the status of this banner
	*/
	public int getStatus() {
		return _banner.getStatus();
	}

	/**
	* Sets the status of this banner.
	*
	* @param status the status of this banner
	*/
	public void setStatus(int status) {
		_banner.setStatus(status);
	}

	/**
	* Gets the group ID of this banner.
	*
	* @return the group ID of this banner
	*/
	public long getGroupId() {
		return _banner.getGroupId();
	}

	/**
	* Sets the group ID of this banner.
	*
	* @param groupId the group ID of this banner
	*/
	public void setGroupId(long groupId) {
		_banner.setGroupId(groupId);
	}

	/**
	* Gets the portlet ID of this banner.
	*
	* @return the portlet ID of this banner
	*/
	public java.lang.String getPortletId() {
		return _banner.getPortletId();
	}

	/**
	* Sets the portlet ID of this banner.
	*
	* @param portletId the portlet ID of this banner
	*/
	public void setPortletId(java.lang.String portletId) {
		_banner.setPortletId(portletId);
	}

	/**
	* Gets the pl ID of this banner.
	*
	* @return the pl ID of this banner
	*/
	public long getPlId() {
		return _banner.getPlId();
	}

	/**
	* Sets the pl ID of this banner.
	*
	* @param plId the pl ID of this banner
	*/
	public void setPlId(long plId) {
		_banner.setPlId(plId);
	}

	public boolean isNew() {
		return _banner.isNew();
	}

	public void setNew(boolean n) {
		_banner.setNew(n);
	}

	public boolean isCachedModel() {
		return _banner.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_banner.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _banner.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_banner.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _banner.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_banner.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _banner.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_banner.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BannerWrapper((Banner)_banner.clone());
	}

	public int compareTo(br.com.seatecnologia.banner.model.Banner banner) {
		return _banner.compareTo(banner);
	}

	@Override
	public int hashCode() {
		return _banner.hashCode();
	}

	public com.liferay.portal.model.CacheModel<br.com.seatecnologia.banner.model.Banner> toCacheModel() {
		return _banner.toCacheModel();
	}

	public br.com.seatecnologia.banner.model.Banner toEscapedModel() {
		return new BannerWrapper(_banner.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _banner.toString();
	}

	public java.lang.String toXmlString() {
		return _banner.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_banner.persist();
	}

	public Banner getWrappedBanner() {
		return _banner;
	}

	public void resetOriginalValues() {
		_banner.resetOriginalValues();
	}

	private Banner _banner;
}