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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Oney
 * @generated
 */
public class BannerSoap implements Serializable {
	public static BannerSoap toSoapModel(Banner model) {
		BannerSoap soapModel = new BannerSoap();

		soapModel.setBannerId(model.getBannerId());
		soapModel.setName(model.getName());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setLink(model.getLink());
		soapModel.setImage(model.getImage());
		soapModel.setPosition(model.getPosition());
		soapModel.setType(model.getType());
		soapModel.setStatus(model.getStatus());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setPlId(model.getPlId());

		return soapModel;
	}

	public static BannerSoap[] toSoapModels(Banner[] models) {
		BannerSoap[] soapModels = new BannerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BannerSoap[][] toSoapModels(Banner[][] models) {
		BannerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BannerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BannerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BannerSoap[] toSoapModels(List<Banner> models) {
		List<BannerSoap> soapModels = new ArrayList<BannerSoap>(models.size());

		for (Banner model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BannerSoap[soapModels.size()]);
	}

	public BannerSoap() {
	}

	public long getPrimaryKey() {
		return _bannerId;
	}

	public void setPrimaryKey(long pk) {
		setBannerId(pk);
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