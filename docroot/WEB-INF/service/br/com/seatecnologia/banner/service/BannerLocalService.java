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

package br.com.seatecnologia.banner.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the banner local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Oney
 * @see BannerLocalServiceUtil
 * @see br.com.seatecnologia.banner.service.base.BannerLocalServiceBaseImpl
 * @see br.com.seatecnologia.banner.service.impl.BannerLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BannerLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BannerLocalServiceUtil} to access the banner local service. Add custom service methods to {@link br.com.seatecnologia.banner.service.impl.BannerLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the banner to the database. Also notifies the appropriate model listeners.
	*
	* @param banner the banner
	* @return the banner that was added
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner addBanner(
		br.com.seatecnologia.banner.model.Banner banner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new banner with the primary key. Does not add the banner to the database.
	*
	* @param bannerId the primary key for the new banner
	* @return the new banner
	*/
	public br.com.seatecnologia.banner.model.Banner createBanner(long bannerId);

	/**
	* Deletes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bannerId the primary key of the banner
	* @throws PortalException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteBanner(long bannerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the banner from the database. Also notifies the appropriate model listeners.
	*
	* @param banner the banner
	* @throws SystemException if a system exception occurred
	*/
	public void deleteBanner(br.com.seatecnologia.banner.model.Banner banner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the banner with the primary key.
	*
	* @param bannerId the primary key of the banner
	* @return the banner
	* @throws PortalException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.seatecnologia.banner.model.Banner getBanner(long bannerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the banners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of banners
	* @param end the upper bound of the range of banners (not inclusive)
	* @return the range of banners
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.seatecnologia.banner.model.Banner> getBanners(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of banners.
	*
	* @return the number of banners
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBannersCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the banner in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param banner the banner
	* @return the banner that was updated
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner updateBanner(
		br.com.seatecnologia.banner.model.Banner banner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the banner in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param banner the banner
	* @param merge whether to merge the banner with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the banner that was updated
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner updateBanner(
		br.com.seatecnologia.banner.model.Banner banner, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.seatecnologia.banner.model.Banner> getBannersByGroupId(
		long groupId, java.lang.String portletId, long plId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.seatecnologia.banner.model.Banner> getBannersByStatusGroupId(
		int status, long groupId, java.lang.String portletId, long plId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<br.com.seatecnologia.banner.model.Banner> getBannersByStatus(
		int status, long groupId, java.lang.String portletId, long plId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public br.com.seatecnologia.banner.model.Banner getBannerByPosition(
		int position, long groupId, java.lang.String portletId, long plId)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBannersByStatusCount(int status, long groupId,
		java.lang.String portletId, long plId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCoutBannersByGroupId(long groupId,
		java.lang.String portletId, long plId)
		throws com.liferay.portal.kernel.exception.SystemException;
}