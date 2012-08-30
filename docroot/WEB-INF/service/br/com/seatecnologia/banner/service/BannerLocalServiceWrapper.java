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

/**
 * <p>
 * This class is a wrapper for {@link BannerLocalService}.
 * </p>
 *
 * @author    Oney
 * @see       BannerLocalService
 * @generated
 */
public class BannerLocalServiceWrapper implements BannerLocalService {
	public BannerLocalServiceWrapper(BannerLocalService bannerLocalService) {
		_bannerLocalService = bannerLocalService;
	}

	/**
	* Adds the banner to the database. Also notifies the appropriate model listeners.
	*
	* @param banner the banner
	* @return the banner that was added
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner addBanner(
		br.com.seatecnologia.banner.model.Banner banner)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.addBanner(banner);
	}

	/**
	* Creates a new banner with the primary key. Does not add the banner to the database.
	*
	* @param bannerId the primary key for the new banner
	* @return the new banner
	*/
	public br.com.seatecnologia.banner.model.Banner createBanner(long bannerId) {
		return _bannerLocalService.createBanner(bannerId);
	}

	/**
	* Deletes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bannerId the primary key of the banner
	* @throws PortalException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteBanner(long bannerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_bannerLocalService.deleteBanner(bannerId);
	}

	/**
	* Deletes the banner from the database. Also notifies the appropriate model listeners.
	*
	* @param banner the banner
	* @throws SystemException if a system exception occurred
	*/
	public void deleteBanner(br.com.seatecnologia.banner.model.Banner banner)
		throws com.liferay.portal.kernel.exception.SystemException {
		_bannerLocalService.deleteBanner(banner);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.dynamicQuery(dynamicQuery);
	}

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
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the banner with the primary key.
	*
	* @param bannerId the primary key of the banner
	* @return the banner
	* @throws PortalException if a banner with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner getBanner(long bannerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.getBanner(bannerId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.getPersistedModel(primaryKeyObj);
	}

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
	public java.util.List<br.com.seatecnologia.banner.model.Banner> getBanners(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.getBanners(start, end);
	}

	/**
	* Returns the number of banners.
	*
	* @return the number of banners
	* @throws SystemException if a system exception occurred
	*/
	public int getBannersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.getBannersCount();
	}

	/**
	* Updates the banner in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param banner the banner
	* @return the banner that was updated
	* @throws SystemException if a system exception occurred
	*/
	public br.com.seatecnologia.banner.model.Banner updateBanner(
		br.com.seatecnologia.banner.model.Banner banner)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.updateBanner(banner);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.updateBanner(banner, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _bannerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bannerLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<br.com.seatecnologia.banner.model.Banner> getBannersByGroupId(
		long groupId, java.lang.String portletId, long plId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.getBannersByGroupId(groupId, portletId,
			plId, start, end);
	}

	public java.util.List<br.com.seatecnologia.banner.model.Banner> getBannersByStatusGroupId(
		int status, long groupId, java.lang.String portletId, long plId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.getBannersByStatusGroupId(status, groupId,
			portletId, plId, start, end);
	}

	public java.util.List<br.com.seatecnologia.banner.model.Banner> getBannersByStatus(
		int status, long groupId, java.lang.String portletId, long plId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.getBannersByStatus(status, groupId,
			portletId, plId);
	}

	public br.com.seatecnologia.banner.model.Banner getBannerByPosition(
		int position, long groupId, java.lang.String portletId, long plId)
		throws br.com.seatecnologia.banner.NoSuchBannerException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.getBannerByPosition(position, groupId,
			portletId, plId);
	}

	public int getBannersByStatusCount(int status, long groupId,
		java.lang.String portletId, long plId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.getBannersByStatusCount(status, groupId,
			portletId, plId);
	}

	public int getCoutBannersByGroupId(long groupId,
		java.lang.String portletId, long plId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bannerLocalService.getCoutBannersByGroupId(groupId, portletId,
			plId);
	}

	public BannerLocalService getWrappedBannerLocalService() {
		return _bannerLocalService;
	}

	public void setWrappedBannerLocalService(
		BannerLocalService bannerLocalService) {
		_bannerLocalService = bannerLocalService;
	}

	private BannerLocalService _bannerLocalService;
}