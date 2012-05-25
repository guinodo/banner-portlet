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

package br.com.seatecnologia.banner.service;

import br.com.seatecnologia.banner.model.BannerClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"banner-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to locate deployment context from portlet properties",
						t);
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"banner-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isWarnEnabled()) {
						_log.warn("Unable to locate deployment context from portal properties",
							t);
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "banner-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(BannerClp.class.getName())) {
			return translateInputBanner(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputBanner(BaseModel<?> oldModel) {
		BannerClp oldCplModel = (BannerClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("br.com.seatecnologia.banner.model.impl.BannerImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setBannerId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getBannerId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setName",
						new Class[] { String.class });

				String value1 = oldCplModel.getName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setTitle",
						new Class[] { String.class });

				String value2 = oldCplModel.getTitle();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value3 = oldCplModel.getDescription();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setLink",
						new Class[] { String.class });

				String value4 = oldCplModel.getLink();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setImage",
						new Class[] { String.class });

				String value5 = oldCplModel.getImage();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setPosition",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getPosition());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setType",
						new Class[] { Integer.TYPE });

				Integer value7 = new Integer(oldCplModel.getType());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getStatus());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setGroupId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getGroupId());

				method9.invoke(newModel, value9);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"br.com.seatecnologia.banner.model.impl.BannerImpl")) {
			return translateOutputBanner(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputBanner(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				BannerClp newModel = new BannerClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getBannerId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setBannerId(value0);

				Method method1 = oldModelClass.getMethod("getName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setName(value1);

				Method method2 = oldModelClass.getMethod("getTitle");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setTitle(value2);

				Method method3 = oldModelClass.getMethod("getDescription");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setDescription(value3);

				Method method4 = oldModelClass.getMethod("getLink");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setLink(value4);

				Method method5 = oldModelClass.getMethod("getImage");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setImage(value5);

				Method method6 = oldModelClass.getMethod("getPosition");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setPosition(value6);

				Method method7 = oldModelClass.getMethod("getType");

				Integer value7 = (Integer)method7.invoke(oldModel,
						(Object[])null);

				newModel.setType(value7);

				Method method8 = oldModelClass.getMethod("getStatus");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value8);

				Method method9 = oldModelClass.getMethod("getGroupId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setGroupId(value9);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}