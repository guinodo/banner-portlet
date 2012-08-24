<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="br.com.seatecnologia.banner.service.BannerLocalServiceUtil"%>
<%@page import="br.com.seatecnologia.banner.BannerKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%
	String redirect = PortalUtil.getCurrentURL(request);
	long bannersCount = BannerLocalServiceUtil
			.getBannersByStatusCount(BannerKeys.ACTIVATED);
%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="addBannerURL">
	<portlet:param name="jspPage" value="/html/banner/add_banner.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<aui:button value="add-banner" onClick="<%= addBannerURL.toString() %>" />

<liferay-ui:search-container
	emptyResultsMessage="banner-active-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= BannerLocalServiceUtil.getBannersByStatusGroupId(BannerKeys.ACTIVATED, scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= BannerLocalServiceUtil.getBannersByStatusCount(BannerKeys.ACTIVATED) %>" />

	<liferay-ui:search-container-row
		className="br.com.seatecnologia.banner.model.Banner"
		keyProperty="bannerId" modelVar="banner">
		<liferay-ui:search-container-column-text name="name"
			value="<%= banner.getName() %>" />

		<liferay-ui:search-container-column-text name="title" property="title" />

		<liferay-ui:search-container-column-text name="description"
			property="description" />

		<liferay-ui:search-container-column-text name="type">
			<%=(banner.getType() == 2) ? "news" : "image"%>

		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="status">
			<liferay-ui:message key="actived" />
			<liferay-ui:icon
				image='<%= (banner.getStatus() == 1) ? "checked" : "close" %>' />
		</liferay-ui:search-container-column-text>

		<portlet:actionURL name="updatePosition" var="upBannerURL">
			<portlet:param name="bannerId"
				value="<%= String.valueOf(banner.getBannerId()) %>" />
			<portlet:param name="position"
				value="<%= String.valueOf(banner.getPosition()) %>" />
			<portlet:param name="position2"
				value="<%= String.valueOf(banner.getPosition()-1) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>
		<portlet:actionURL name="updatePosition" var="downBannerURL">
			<portlet:param name="bannerId"
				value="<%= String.valueOf(banner.getBannerId()) %>" />
			<portlet:param name="position"
				value="<%= String.valueOf(banner.getPosition()) %>" />
			<portlet:param name="position2"
				value="<%= String.valueOf(banner.getPosition()+1) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>

		<liferay-ui:search-container-column-text name="position">
			<%=banner.getPosition()%>

			<c:choose>
				<c:when	test="<%= banner.getPosition()==1 %>">
					<liferay-ui:icon image="checked" url="<%= downBannerURL %>" />
				</c:when>
				<c:when test="<%= banner.getPosition()==bannersCount %>">
					<liferay-ui:icon image="top" url="<%= upBannerURL %>" target="subir" />
				</c:when>
				<c:otherwise>
					<liferay-ui:icon image="top" url="<%= upBannerURL %>" />
					<liferay-ui:icon image="checked" url="<%= downBannerURL %>" />
				</c:otherwise>
			</c:choose>


		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-jsp align="right"
			path="/html/banner/banner_actions.jsp" />
		</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>