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

package br.com.seatecnologia.banner.service.persistence;

import br.com.seatecnologia.banner.model.Banner;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the banner service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Oney
 * @see BannerPersistenceImpl
 * @see BannerUtil
 * @generated
 */
public interface BannerPersistence extends BasePersistence<Banner> {
	/**
	* Caches the banner in the entity cache if it is enabled.
	*
	* @param banner the banner to cache
	*/
	public void cacheResult(br.com.seatecnologia.banner.model.Banner banner);

	/**
	* Caches the banners in the entity cache if it is enabled.
	*
	* @param banners the banners to cache
	*/
	public void cacheResult(
		java.util.List<br.com.seatecnologia.banner.model.Banner> banners);

	/**
	* Creates a new banner with the primary key. Does not add the banner to the database.
	*
	* @param bannerId the primary key for the new banner
	* @return the new banner
	*/
	public br.com.seatecnologia.banner.model.Banner create(long bannerId);

	/**
	* Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bannerId the primary key of the banner to remove
	* @return the banner that was removed
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner remove(long bannerId)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException;

	public br.com.seatecnologia.banner.model.Banner updateImpl(
		br.com.seatecnologia.banner.model.Banner banner, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the banner with the primary key or throws a {@link br.com.seatecnologia.banner.NoSuchBannerException} if it could not be found.
	*
	* @param bannerId the primary key of the banner to find
	* @return the banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner findByPrimaryKey(
		long bannerId)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the banner with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bannerId the primary key of the banner to find
	* @return the banner, or <code>null</code> if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner fetchByPrimaryKey(
		long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the banners where groupId = &#63;.
	*
	* @param groupId the group ID to search with
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.banner.model.Banner> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the banners where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID to search with
	* @param start the lower bound of the range of banners to return
	* @param end the upper bound of the range of banners to return (not inclusive)
	* @return the range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.banner.model.Banner> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the banners where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID to search with
	* @param start the lower bound of the range of banners to return
	* @param end the upper bound of the range of banners to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.banner.model.Banner> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first banner in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last banner in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the banners before and after the current banner in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bannerId the primary key of the current banner
	* @param groupId the group ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner[] findByGroupId_PrevAndNext(
		long bannerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the banner where bannerId = &#63; or throws a {@link br.com.seatecnologia.banner.NoSuchBannerException} if it could not be found.
	*
	* @param bannerId the banner ID to search with
	* @return the matching banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner findByBannerId(
		long bannerId)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the banner where bannerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param bannerId the banner ID to search with
	* @return the matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner fetchByBannerId(
		long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the banner where bannerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param bannerId the banner ID to search with
	* @return the matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner fetchByBannerId(
		long bannerId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the banners where status = &#63;.
	*
	* @param status the status to search with
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.banner.model.Banner> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the banners where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status to search with
	* @param start the lower bound of the range of banners to return
	* @param end the upper bound of the range of banners to return (not inclusive)
	* @return the range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.banner.model.Banner> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the banners where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status to search with
	* @param start the lower bound of the range of banners to return
	* @param end the upper bound of the range of banners to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.banner.model.Banner> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first banner in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last banner in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the banners before and after the current banner in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bannerId the primary key of the current banner
	* @param status the status to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner[] findByStatus_PrevAndNext(
		long bannerId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the banners.
	*
	* @return the banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.banner.model.Banner> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the banners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of banners to return
	* @param end the upper bound of the range of banners to return (not inclusive)
	* @return the range of banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.banner.model.Banner> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the banners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of banners to return
	* @param end the upper bound of the range of banners to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of banners
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<br.com.seatecnologia.banner.model.Banner> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banners where groupId = &#63; from the database.
	*
	* @param groupId the group ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the banner where bannerId = &#63; from the database.
	*
	* @param bannerId the banner ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBannerId(long bannerId)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banners where status = &#63; from the database.
	*
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the banners from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the banners where groupId = &#63;.
	*
	* @param groupId the group ID to search with
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the banners where bannerId = &#63;.
	*
	* @param bannerId the banner ID to search with
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public int countByBannerId(long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the banners where status = &#63;.
	*
	* @param status the status to search with
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the banners.
	*
	* @return the number of banners
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public Banner remove(Banner banner) throws SystemException;
}