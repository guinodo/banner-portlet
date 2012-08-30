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

package br.com.seatecnologia.banner.model.impl;

import br.com.seatecnologia.banner.model.Banner;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

/**
 * The cache model class for representing Banner in entity cache.
 *
 * @author Oney
 * @see Banner
 * @generated
 */
public class BannerCacheModel implements CacheModel<Banner> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{bannerId=");
		sb.append(bannerId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", link=");
		sb.append(link);
		sb.append(", image=");
		sb.append(image);
		sb.append(", position=");
		sb.append(position);
		sb.append(", type=");
		sb.append(type);
		sb.append(", status=");
		sb.append(status);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", plId=");
		sb.append(plId);
		sb.append("}");

		return sb.toString();
	}

	public Banner toEntityModel() {
		BannerImpl bannerImpl = new BannerImpl();

		bannerImpl.setBannerId(bannerId);

		if (name == null) {
			bannerImpl.setName(StringPool.BLANK);
		}
		else {
			bannerImpl.setName(name);
		}

		if (title == null) {
			bannerImpl.setTitle(StringPool.BLANK);
		}
		else {
			bannerImpl.setTitle(title);
		}

		if (description == null) {
			bannerImpl.setDescription(StringPool.BLANK);
		}
		else {
			bannerImpl.setDescription(description);
		}

		if (link == null) {
			bannerImpl.setLink(StringPool.BLANK);
		}
		else {
			bannerImpl.setLink(link);
		}

		if (image == null) {
			bannerImpl.setImage(StringPool.BLANK);
		}
		else {
			bannerImpl.setImage(image);
		}

		bannerImpl.setPosition(position);
		bannerImpl.setType(type);
		bannerImpl.setStatus(status);
		bannerImpl.setGroupId(groupId);

		if (portletId == null) {
			bannerImpl.setPortletId(StringPool.BLANK);
		}
		else {
			bannerImpl.setPortletId(portletId);
		}

		bannerImpl.setPlId(plId);

		bannerImpl.resetOriginalValues();

		return bannerImpl;
	}

	public long bannerId;
	public String name;
	public String title;
	public String description;
	public String link;
	public String image;
	public int position;
	public int type;
	public int status;
	public long groupId;
	public String portletId;
	public long plId;
}