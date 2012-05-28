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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the banner service. This utility wraps {@link BannerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Oney
 * @see BannerPersistence
 * @see BannerPersistenceImpl
 * @generated
 */
public class BannerUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Banner banner) {
		getPersistence().clearCache(banner);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Banner> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Banner> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Banner> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Banner remove(Banner banner) throws SystemException {
		return getPersistence().remove(banner);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Banner update(Banner banner, boolean merge)
		throws SystemException {
		return getPersistence().update(banner, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Banner update(Banner banner, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(banner, merge, serviceContext);
	}

	/**
	* Caches the banner in the entity cache if it is enabled.
	*
	* @param banner the banner to cache
	*/
	public static void cacheResult(
		br.com.seatecnologia.banner.model.Banner banner) {
		getPersistence().cacheResult(banner);
	}

	/**
	* Caches the banners in the entity cache if it is enabled.
	*
	* @param banners the banners to cache
	*/
	public static void cacheResult(
		java.util.List<br.com.seatecnologia.banner.model.Banner> banners) {
		getPersistence().cacheResult(banners);
	}

	/**
	* Creates a new banner with the primary key. Does not add the banner to the database.
	*
	* @param bannerId the primary key for the new banner
	* @return the new banner
	*/
	public static br.com.seatecnologia.banner.model.Banner create(long bannerId) {
		return getPersistence().create(bannerId);
	}

	/**
	* Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bannerId the primary key of the banner to remove
	* @return the banner that was removed
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner remove(long bannerId)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(bannerId);
	}

	public static br.com.seatecnologia.banner.model.Banner updateImpl(
		br.com.seatecnologia.banner.model.Banner banner, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(banner, merge);
	}

	/**
	* Finds the banner with the primary key or throws a {@link br.com.seatecnologia.banner.NoSuchBannerException} if it could not be found.
	*
	* @param bannerId the primary key of the banner to find
	* @return the banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner findByPrimaryKey(
		long bannerId)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(bannerId);
	}

	/**
	* Finds the banner with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bannerId the primary key of the banner to find
	* @return the banner, or <code>null</code> if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner fetchByPrimaryKey(
		long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bannerId);
	}

	/**
	* Finds all the banners where groupId = &#63;.
	*
	* @param groupId the group ID to search with
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static br.com.seatecnologia.banner.model.Banner findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

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
	public static br.com.seatecnologia.banner.model.Banner findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

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
	public static br.com.seatecnologia.banner.model.Banner[] findByGroupId_PrevAndNext(
		long bannerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(bannerId, groupId,
			orderByComparator);
	}

	/**
	* Finds all the banners where status = &#63; and groupId = &#63;.
	*
	* @param status the status to search with
	* @param groupId the group ID to search with
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findByStatusGroupId(
		int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusGroupId(status, groupId);
	}

	/**
	* Finds a range of all the banners where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status to search with
	* @param groupId the group ID to search with
	* @param start the lower bound of the range of banners to return
	* @param end the upper bound of the range of banners to return (not inclusive)
	* @return the range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findByStatusGroupId(
		int status, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusGroupId(status, groupId, start, end);
	}

	/**
	* Finds an ordered range of all the banners where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status to search with
	* @param groupId the group ID to search with
	* @param start the lower bound of the range of banners to return
	* @param end the upper bound of the range of banners to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findByStatusGroupId(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusGroupId(status, groupId, start, end,
			orderByComparator);
	}

	/**
	* Finds the first banner in the ordered set where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status to search with
	* @param groupId the group ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner findByStatusGroupId_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusGroupId_First(status, groupId, orderByComparator);
	}

	/**
	* Finds the last banner in the ordered set where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status to search with
	* @param groupId the group ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner findByStatusGroupId_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusGroupId_Last(status, groupId, orderByComparator);
	}

	/**
	* Finds the banners before and after the current banner in the ordered set where status = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bannerId the primary key of the current banner
	* @param status the status to search with
	* @param groupId the group ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner[] findByStatusGroupId_PrevAndNext(
		long bannerId, int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusGroupId_PrevAndNext(bannerId, status, groupId,
			orderByComparator);
	}

	/**
	* Finds the banner where bannerId = &#63; or throws a {@link br.com.seatecnologia.banner.NoSuchBannerException} if it could not be found.
	*
	* @param bannerId the banner ID to search with
	* @return the matching banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner findByBannerId(
		long bannerId)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBannerId(bannerId);
	}

	/**
	* Finds the banner where bannerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param bannerId the banner ID to search with
	* @return the matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner fetchByBannerId(
		long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBannerId(bannerId);
	}

	/**
	* Finds the banner where bannerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param bannerId the banner ID to search with
	* @return the matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner fetchByBannerId(
		long bannerId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBannerId(bannerId, retrieveFromCache);
	}

	/**
	* Finds all the banners where status = &#63;.
	*
	* @param status the status to search with
	* @return the matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

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
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

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
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

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
	public static br.com.seatecnologia.banner.model.Banner findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

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
	public static br.com.seatecnologia.banner.model.Banner findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

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
	public static br.com.seatecnologia.banner.model.Banner[] findByStatus_PrevAndNext(
		long bannerId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus_PrevAndNext(bannerId, status, orderByComparator);
	}

	/**
	* Finds the banner where position = &#63; or throws a {@link br.com.seatecnologia.banner.NoSuchBannerException} if it could not be found.
	*
	* @param position the position to search with
	* @return the matching banner
	* @throws br.com.seatecnologia.banner.NoSuchBannerException if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner findByPosition(
		int position)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPosition(position);
	}

	/**
	* Finds the banner where position = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param position the position to search with
	* @return the matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner fetchByPosition(
		int position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPosition(position);
	}

	/**
	* Finds the banner where position = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param position the position to search with
	* @return the matching banner, or <code>null</code> if a matching banner could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static br.com.seatecnologia.banner.model.Banner fetchByPosition(
		int position, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPosition(position, retrieveFromCache);
	}

	/**
	* Finds all the banners.
	*
	* @return the banners
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<br.com.seatecnologia.banner.model.Banner> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the banners where groupId = &#63; from the database.
	*
	* @param groupId the group ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the banners where status = &#63; and groupId = &#63; from the database.
	*
	* @param status the status to search with
	* @param groupId the group ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusGroupId(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusGroupId(status, groupId);
	}

	/**
	* Removes the banner where bannerId = &#63; from the database.
	*
	* @param bannerId the banner ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBannerId(long bannerId)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBannerId(bannerId);
	}

	/**
	* Removes all the banners where status = &#63; from the database.
	*
	* @param status the status to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Removes the banner where position = &#63; from the database.
	*
	* @param position the position to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPosition(int position)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPosition(position);
	}

	/**
	* Removes all the banners from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the banners where groupId = &#63;.
	*
	* @param groupId the group ID to search with
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Counts all the banners where status = &#63; and groupId = &#63;.
	*
	* @param status the status to search with
	* @param groupId the group ID to search with
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusGroupId(int status, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusGroupId(status, groupId);
	}

	/**
	* Counts all the banners where bannerId = &#63;.
	*
	* @param bannerId the banner ID to search with
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBannerId(long bannerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBannerId(bannerId);
	}

	/**
	* Counts all the banners where status = &#63;.
	*
	* @param status the status to search with
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Counts all the banners where position = &#63;.
	*
	* @param position the position to search with
	* @return the number of matching banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPosition(int position)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPosition(position);
	}

	/**
	* Counts all the banners.
	*
	* @return the number of banners
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BannerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BannerPersistence)PortletBeanLocatorUtil.locate(br.com.seatecnologia.banner.service.ClpSerializer.getServletContextName(),
					BannerPersistence.class.getName());

			ReferenceRegistry.registerReference(BannerUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(BannerPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(BannerUtil.class, "_persistence");
	}

	private static BannerPersistence _persistence;
}