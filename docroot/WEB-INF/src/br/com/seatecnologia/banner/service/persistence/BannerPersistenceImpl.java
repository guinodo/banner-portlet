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

import br.com.seatecnologia.banner.NoSuchBannerException;
import br.com.seatecnologia.banner.model.Banner;
import br.com.seatecnologia.banner.model.impl.BannerImpl;
import br.com.seatecnologia.banner.model.impl.BannerModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the banner service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Oney
 * @see BannerPersistence
 * @see BannerUtil
 * @generated
 */
public class BannerPersistenceImpl extends BasePersistenceImpl<Banner>
	implements BannerPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = BannerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_STATUSGROUPID = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST, "findByStatusGroupId",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSGROUPID = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByStatusGroupId",
			new String[] { Integer.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_BANNERID = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByBannerId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_BANNERID = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByBannerId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_STATUS = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_POSITION = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPosition",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITION = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByPosition",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, BannerImpl.class,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the banner in the entity cache if it is enabled.
	 *
	 * @param banner the banner to cache
	 */
	public void cacheResult(Banner banner) {
		EntityCacheUtil.putResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerImpl.class, banner.getPrimaryKey(), banner);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BANNERID,
			new Object[] { Long.valueOf(banner.getBannerId()) }, banner);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITION,
			new Object[] { Integer.valueOf(banner.getPosition()) }, banner);

		banner.resetOriginalValues();
	}

	/**
	 * Caches the banners in the entity cache if it is enabled.
	 *
	 * @param banners the banners to cache
	 */
	public void cacheResult(List<Banner> banners) {
		for (Banner banner : banners) {
			if (EntityCacheUtil.getResult(
						BannerModelImpl.ENTITY_CACHE_ENABLED, BannerImpl.class,
						banner.getPrimaryKey(), this) == null) {
				cacheResult(banner);
			}
		}
	}

	/**
	 * Clears the cache for all banners.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BannerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BannerImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the banner.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Banner banner) {
		EntityCacheUtil.removeResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerImpl.class, banner.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BANNERID,
			new Object[] { Long.valueOf(banner.getBannerId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSITION,
			new Object[] { Integer.valueOf(banner.getPosition()) });
	}

	/**
	 * Creates a new banner with the primary key. Does not add the banner to the database.
	 *
	 * @param bannerId the primary key for the new banner
	 * @return the new banner
	 */
	public Banner create(long bannerId) {
		Banner banner = new BannerImpl();

		banner.setNew(true);
		banner.setPrimaryKey(bannerId);

		return banner;
	}

	/**
	 * Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the banner to remove
	 * @return the banner that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the banner with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bannerId the primary key of the banner to remove
	 * @return the banner that was removed
	 * @throws br.com.seatecnologia.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner remove(long bannerId)
		throws NoSuchBannerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Banner banner = (Banner)session.get(BannerImpl.class,
					Long.valueOf(bannerId));

			if (banner == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bannerId);
				}

				throw new NoSuchBannerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					bannerId);
			}

			return bannerPersistence.remove(banner);
		}
		catch (NoSuchBannerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes the banner from the database. Also notifies the appropriate model listeners.
	 *
	 * @param banner the banner to remove
	 * @return the banner that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner remove(Banner banner) throws SystemException {
		return super.remove(banner);
	}

	@Override
	protected Banner removeImpl(Banner banner) throws SystemException {
		banner = toUnwrappedModel(banner);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, banner);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		BannerModelImpl bannerModelImpl = (BannerModelImpl)banner;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BANNERID,
			new Object[] { Long.valueOf(bannerModelImpl.getBannerId()) });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSITION,
			new Object[] { Integer.valueOf(bannerModelImpl.getPosition()) });

		EntityCacheUtil.removeResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerImpl.class, banner.getPrimaryKey());

		return banner;
	}

	@Override
	public Banner updateImpl(br.com.seatecnologia.banner.model.Banner banner,
		boolean merge) throws SystemException {
		banner = toUnwrappedModel(banner);

		boolean isNew = banner.isNew();

		BannerModelImpl bannerModelImpl = (BannerModelImpl)banner;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, banner, merge);

			banner.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
			BannerImpl.class, banner.getPrimaryKey(), banner);

		if (!isNew &&
				(banner.getBannerId() != bannerModelImpl.getOriginalBannerId())) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BANNERID,
				new Object[] { Long.valueOf(
						bannerModelImpl.getOriginalBannerId()) });
		}

		if (isNew ||
				(banner.getBannerId() != bannerModelImpl.getOriginalBannerId())) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BANNERID,
				new Object[] { Long.valueOf(banner.getBannerId()) }, banner);
		}

		if (!isNew &&
				(banner.getPosition() != bannerModelImpl.getOriginalPosition())) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSITION,
				new Object[] {
					Integer.valueOf(bannerModelImpl.getOriginalPosition())
				});
		}

		if (isNew ||
				(banner.getPosition() != bannerModelImpl.getOriginalPosition())) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITION,
				new Object[] { Integer.valueOf(banner.getPosition()) }, banner);
		}

		return banner;
	}

	protected Banner toUnwrappedModel(Banner banner) {
		if (banner instanceof BannerImpl) {
			return banner;
		}

		BannerImpl bannerImpl = new BannerImpl();

		bannerImpl.setNew(banner.isNew());
		bannerImpl.setPrimaryKey(banner.getPrimaryKey());

		bannerImpl.setBannerId(banner.getBannerId());
		bannerImpl.setName(banner.getName());
		bannerImpl.setTitle(banner.getTitle());
		bannerImpl.setDescription(banner.getDescription());
		bannerImpl.setLink(banner.getLink());
		bannerImpl.setImage(banner.getImage());
		bannerImpl.setPosition(banner.getPosition());
		bannerImpl.setType(banner.getType());
		bannerImpl.setStatus(banner.getStatus());
		bannerImpl.setGroupId(banner.getGroupId());

		return bannerImpl;
	}

	/**
	 * Finds the banner with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the banner to find
	 * @return the banner
	 * @throws com.liferay.portal.NoSuchModelException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the banner with the primary key or throws a {@link br.com.seatecnologia.banner.NoSuchBannerException} if it could not be found.
	 *
	 * @param bannerId the primary key of the banner to find
	 * @return the banner
	 * @throws br.com.seatecnologia.banner.NoSuchBannerException if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner findByPrimaryKey(long bannerId)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByPrimaryKey(bannerId);

		if (banner == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bannerId);
			}

			throw new NoSuchBannerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bannerId);
		}

		return banner;
	}

	/**
	 * Finds the banner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the banner to find
	 * @return the banner, or <code>null</code> if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Banner fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the banner with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bannerId the primary key of the banner to find
	 * @return the banner, or <code>null</code> if a banner with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByPrimaryKey(long bannerId) throws SystemException {
		Banner banner = (Banner)EntityCacheUtil.getResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
				BannerImpl.class, bannerId, this);

		if (banner == _nullBanner) {
			return null;
		}

		if (banner == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				banner = (Banner)session.get(BannerImpl.class,
						Long.valueOf(bannerId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (banner != null) {
					cacheResult(banner);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BannerModelImpl.ENTITY_CACHE_ENABLED,
						BannerImpl.class, bannerId, _nullBanner);
				}

				closeSession(session);
			}
		}

		return banner;
	}

	/**
	 * Finds all the banners where groupId = &#63;.
	 *
	 * @param groupId the group ID to search with
	 * @return the matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Banner> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	public List<Banner> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Banner> list = (List<Banner>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BannerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Banner>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Banner findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		List<Banner> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBannerException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Banner findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		int count = countByGroupId(groupId);

		List<Banner> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBannerException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Banner[] findByGroupId_PrevAndNext(long bannerId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = findByPrimaryKey(bannerId);

		Session session = null;

		try {
			session = openSession();

			Banner[] array = new BannerImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, banner, groupId,
					orderByComparator, true);

			array[1] = banner;

			array[2] = getByGroupId_PrevAndNext(session, banner, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Banner getByGroupId_PrevAndNext(Session session, Banner banner,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BANNER_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(BannerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(banner);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Banner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the banners where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status to search with
	 * @param groupId the group ID to search with
	 * @return the matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByStatusGroupId(int status, long groupId)
		throws SystemException {
		return findByStatusGroupId(status, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Banner> findByStatusGroupId(int status, long groupId,
		int start, int end) throws SystemException {
		return findByStatusGroupId(status, groupId, start, end, null);
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
	public List<Banner> findByStatusGroupId(int status, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				status, groupId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Banner> list = (List<Banner>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATUSGROUPID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_STATUSGROUPID_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BannerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(groupId);

				list = (List<Banner>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_STATUSGROUPID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATUSGROUPID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Banner findByStatusGroupId_First(int status, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		List<Banner> list = findByStatusGroupId(status, groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBannerException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Banner findByStatusGroupId_Last(int status, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		int count = countByStatusGroupId(status, groupId);

		List<Banner> list = findByStatusGroupId(status, groupId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBannerException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Banner[] findByStatusGroupId_PrevAndNext(long bannerId, int status,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = findByPrimaryKey(bannerId);

		Session session = null;

		try {
			session = openSession();

			Banner[] array = new BannerImpl[3];

			array[0] = getByStatusGroupId_PrevAndNext(session, banner, status,
					groupId, orderByComparator, true);

			array[1] = banner;

			array[2] = getByStatusGroupId_PrevAndNext(session, banner, status,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Banner getByStatusGroupId_PrevAndNext(Session session,
		Banner banner, int status, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BANNER_WHERE);

		query.append(_FINDER_COLUMN_STATUSGROUPID_STATUS_2);

		query.append(_FINDER_COLUMN_STATUSGROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(BannerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(banner);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Banner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the banner where bannerId = &#63; or throws a {@link br.com.seatecnologia.banner.NoSuchBannerException} if it could not be found.
	 *
	 * @param bannerId the banner ID to search with
	 * @return the matching banner
	 * @throws br.com.seatecnologia.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner findByBannerId(long bannerId)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByBannerId(bannerId);

		if (banner == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("bannerId=");
			msg.append(bannerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBannerException(msg.toString());
		}

		return banner;
	}

	/**
	 * Finds the banner where bannerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param bannerId the banner ID to search with
	 * @return the matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByBannerId(long bannerId) throws SystemException {
		return fetchByBannerId(bannerId, true);
	}

	/**
	 * Finds the banner where bannerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param bannerId the banner ID to search with
	 * @return the matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByBannerId(long bannerId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { bannerId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BANNERID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_BANNERID_BANNERID_2);

			query.append(BannerModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bannerId);

				List<Banner> list = q.list();

				result = list;

				Banner banner = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BANNERID,
						finderArgs, list);
				}
				else {
					banner = list.get(0);

					cacheResult(banner);

					if ((banner.getBannerId() != bannerId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BANNERID,
							finderArgs, banner);
					}
				}

				return banner;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BANNERID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Banner)result;
			}
		}
	}

	/**
	 * Finds all the banners where status = &#63;.
	 *
	 * @param status the status to search with
	 * @return the matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findByStatus(int status) throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Banner> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
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
	public List<Banner> findByStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				status,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Banner> list = (List<Banner>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATUS,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BannerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<Banner>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_STATUS,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATUS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Banner findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		List<Banner> list = findByStatus(status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBannerException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Banner findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		int count = countByStatus(status);

		List<Banner> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBannerException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Banner[] findByStatus_PrevAndNext(long bannerId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchBannerException, SystemException {
		Banner banner = findByPrimaryKey(bannerId);

		Session session = null;

		try {
			session = openSession();

			Banner[] array = new BannerImpl[3];

			array[0] = getByStatus_PrevAndNext(session, banner, status,
					orderByComparator, true);

			array[1] = banner;

			array[2] = getByStatus_PrevAndNext(session, banner, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Banner getByStatus_PrevAndNext(Session session, Banner banner,
		int status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BANNER_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(BannerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(banner);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Banner> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the banner where position = &#63; or throws a {@link br.com.seatecnologia.banner.NoSuchBannerException} if it could not be found.
	 *
	 * @param position the position to search with
	 * @return the matching banner
	 * @throws br.com.seatecnologia.banner.NoSuchBannerException if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner findByPosition(int position)
		throws NoSuchBannerException, SystemException {
		Banner banner = fetchByPosition(position);

		if (banner == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("position=");
			msg.append(position);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBannerException(msg.toString());
		}

		return banner;
	}

	/**
	 * Finds the banner where position = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param position the position to search with
	 * @return the matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByPosition(int position) throws SystemException {
		return fetchByPosition(position, true);
	}

	/**
	 * Finds the banner where position = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param position the position to search with
	 * @return the matching banner, or <code>null</code> if a matching banner could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Banner fetchByPosition(int position, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { position };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_POSITION,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_POSITION_POSITION_2);

			query.append(BannerModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(position);

				List<Banner> list = q.list();

				result = list;

				Banner banner = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITION,
						finderArgs, list);
				}
				else {
					banner = list.get(0);

					cacheResult(banner);

					if ((banner.getPosition() != position)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_POSITION,
							finderArgs, banner);
					}
				}

				return banner;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_POSITION,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Banner)result;
			}
		}
	}

	/**
	 * Finds all the banners.
	 *
	 * @return the banners
	 * @throws SystemException if a system exception occurred
	 */
	public List<Banner> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Banner> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Banner> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Banner> list = (List<Banner>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BANNER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BANNER.concat(BannerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Banner>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Banner>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the banners where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Banner banner : findByGroupId(groupId)) {
			bannerPersistence.remove(banner);
		}
	}

	/**
	 * Removes all the banners where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status to search with
	 * @param groupId the group ID to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatusGroupId(int status, long groupId)
		throws SystemException {
		for (Banner banner : findByStatusGroupId(status, groupId)) {
			bannerPersistence.remove(banner);
		}
	}

	/**
	 * Removes the banner where bannerId = &#63; from the database.
	 *
	 * @param bannerId the banner ID to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBannerId(long bannerId)
		throws NoSuchBannerException, SystemException {
		Banner banner = findByBannerId(bannerId);

		bannerPersistence.remove(banner);
	}

	/**
	 * Removes all the banners where status = &#63; from the database.
	 *
	 * @param status the status to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatus(int status) throws SystemException {
		for (Banner banner : findByStatus(status)) {
			bannerPersistence.remove(banner);
		}
	}

	/**
	 * Removes the banner where position = &#63; from the database.
	 *
	 * @param position the position to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPosition(int position)
		throws NoSuchBannerException, SystemException {
		Banner banner = findByPosition(position);

		bannerPersistence.remove(banner);
	}

	/**
	 * Removes all the banners from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Banner banner : findAll()) {
			bannerPersistence.remove(banner);
		}
	}

	/**
	 * Counts all the banners where groupId = &#63;.
	 *
	 * @param groupId the group ID to search with
	 * @return the number of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the banners where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status to search with
	 * @param groupId the group ID to search with
	 * @return the number of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatusGroupId(int status, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { status, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUSGROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_STATUSGROUPID_STATUS_2);

			query.append(_FINDER_COLUMN_STATUSGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUSGROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the banners where bannerId = &#63;.
	 *
	 * @param bannerId the banner ID to search with
	 * @return the number of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBannerId(long bannerId) throws SystemException {
		Object[] finderArgs = new Object[] { bannerId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BANNERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_BANNERID_BANNERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bannerId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BANNERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the banners where status = &#63;.
	 *
	 * @param status the status to search with
	 * @return the number of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatus(int status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the banners where position = &#63;.
	 *
	 * @param position the position to search with
	 * @return the number of matching banners
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPosition(int position) throws SystemException {
		Object[] finderArgs = new Object[] { position };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_POSITION,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BANNER_WHERE);

			query.append(_FINDER_COLUMN_POSITION_POSITION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(position);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POSITION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the banners.
	 *
	 * @return the number of banners
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BANNER);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the banner persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.br.com.seatecnologia.banner.model.Banner")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Banner>> listenersList = new ArrayList<ModelListener<Banner>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Banner>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BannerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = BannerPersistence.class)
	protected BannerPersistence bannerPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_BANNER = "SELECT banner FROM Banner banner";
	private static final String _SQL_SELECT_BANNER_WHERE = "SELECT banner FROM Banner banner WHERE ";
	private static final String _SQL_COUNT_BANNER = "SELECT COUNT(banner) FROM Banner banner";
	private static final String _SQL_COUNT_BANNER_WHERE = "SELECT COUNT(banner) FROM Banner banner WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "banner.groupId = ?";
	private static final String _FINDER_COLUMN_STATUSGROUPID_STATUS_2 = "banner.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSGROUPID_GROUPID_2 = "banner.groupId = ?";
	private static final String _FINDER_COLUMN_BANNERID_BANNERID_2 = "banner.bannerId = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "banner.status = ?";
	private static final String _FINDER_COLUMN_POSITION_POSITION_2 = "banner.position = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "banner.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Banner exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Banner exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BannerPersistenceImpl.class);
	private static Banner _nullBanner = new BannerImpl() {
			public Object clone() {
				return this;
			}

			public CacheModel<Banner> toCacheModel() {
				return _nullBannerCacheModel;
			}
		};

	private static CacheModel<Banner> _nullBannerCacheModel = new CacheModel<Banner>() {
			public Banner toEntityModel() {
				return _nullBanner;
			}
		};
}