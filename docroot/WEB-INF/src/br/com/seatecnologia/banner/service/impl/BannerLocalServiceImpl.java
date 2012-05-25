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
	
	public List<Banner> getBannersByGroupId(long groupId, int start, int end) throws SystemException {
		return bannerPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<Banner> getBannersByStatus(int status) throws SystemException {
		return bannerPersistence.findByStatus(status);
	}
	
	public int getCoutBannersByGroupId(long groupId) throws SystemException{
		return bannerPersistence.countByGroupId(groupId);
		
	}
}