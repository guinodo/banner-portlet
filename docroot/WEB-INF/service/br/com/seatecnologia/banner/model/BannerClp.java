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

import br.com.seatecnologia.banner.service.BannerLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Oney
 */
public class BannerClp extends BaseModelImpl<Banner> implements Banner {
	public BannerClp() {
	}

	public Class<?> getModelClass() {
		return Banner.class;
	}

	public String getModelClassName() {
		return Banner.class.getName();
	}

	public long getPrimaryKey() {
		return _bannerId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBannerId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_bannerId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getBannerId() {
		return _bannerId;
	}

	public void setBannerId(long bannerId) {
		_bannerId = bannerId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_position = position;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public long getPlId() {
		return _plId;
	}

	public void setPlId(long plId) {
		_plId = plId;
	}

	public void persist() throws SystemException {
		BannerLocalServiceUtil.updateBanner(this);
	}

	@Override
	public Banner toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Banner)Proxy.newProxyInstance(Banner.class.getClassLoader(),
				new Class[] { Banner.class }, new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public Object clone() {
		BannerClp clone = new BannerClp();

		clone.setBannerId(getBannerId());
		clone.setName(getName());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setLink(getLink());
		clone.setImage(getImage());
		clone.setPosition(getPosition());
		clone.setType(getType());
		clone.setStatus(getStatus());
		clone.setGroupId(getGroupId());
		clone.setPortletId(getPortletId());
		clone.setPlId(getPlId());

		return clone;
	}

	public int compareTo(Banner banner) {
		int value = 0;

		if (getPosition() < banner.getPosition()) {
			value = -1;
		}
		else if (getPosition() > banner.getPosition()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BannerClp banner = null;

		try {
			banner = (BannerClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = banner.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{bannerId=");
		sb.append(getBannerId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", link=");
		sb.append(getLink());
		sb.append(", image=");
		sb.append(getImage());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", plId=");
		sb.append(getPlId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("br.com.seatecnologia.banner.model.Banner");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bannerId</column-name><column-value><![CDATA[");
		sb.append(getBannerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>link</column-name><column-value><![CDATA[");
		sb.append(getLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>image</column-name><column-value><![CDATA[");
		sb.append(getImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>plId</column-name><column-value><![CDATA[");
		sb.append(getPlId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bannerId;
	private String _name;
	private String _title;
	private String _description;
	private String _link;
	private String _image;
	private int _position;
	private int _type;
	private int _status;
	private long _groupId;
	private String _portletId;
	private long _plId;
}