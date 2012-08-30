/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package br.com.seatecnologia.banner.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import br.com.seatecnologia.banner.NoSuchBannerException;
import br.com.seatecnologia.banner.model.Banner;
import br.com.seatecnologia.banner.service.base.BannerLocalServiceBaseImpl;

/**
 * The implementation of the banner local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.com.seatecnologia.banner.service.BannerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Oney
 * @see br.com.seatecnologia.banner.service.base.BannerLocalServiceBaseImpl
 * @see br.com.seatecnologia.banner.service.BannerLocalServiceUtil
 */
public class BannerLocalServiceImpl extends BannerLocalServiceBaseImpl {
	
	public List<Banner> getBannersByGroupId(long groupId, String portletId, long plId, int start, int end) throws SystemException {
		return bannerPersistence.findByGroupId(groupId, portletId, plId, start, end);
	}
	
	public List<Banner> getBannersByStatusGroupId(int status, long groupId,  String portletId, long plId, int start, int end) throws SystemException {
		return bannerPersistence.findByStatusGroupId(status, groupId, portletId, plId, start, end);
	}
	
	public List<Banner> getBannersByStatus(int status, long groupId, String portletId, long plId) throws SystemException {
		return bannerPersistence.findByStatus(status, groupId, portletId, plId);
	}
	
	public Banner getBannerByPosition(int position, long groupId, String portletId, long plId) throws SystemException, NoSuchBannerException {
		return bannerPersistence.findByPosition(position, groupId, portletId, plId);
	}
	
	public int getBannersByStatusCount(int status, long groupId, String portletId, long plId) throws SystemException {
		return bannerPersistence.countByStatus(status, groupId, portletId, plId);
	}
	
	public int getCoutBannersByGroupId(long groupId, String portletId, long plId) throws SystemException{
		return bannerPersistence.countByGroupId(groupId, portletId, plId);	
	}
}