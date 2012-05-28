<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="br.com.seatecnologia.banner.service.BannerLocalServiceUtil"%>
<%@page import="br.com.seatecnologia.banner.BannerKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%

String redirect = PortalUtil.getCurrentURL(request);

%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:renderURL var="addBannerURL">
		<portlet:param name="jspPage"
			value="/html/banner/add_banner.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<aui:button value="add-banner"
			onClick="<%= addBannerURL.toString() %>" /> 

<liferay-ui:search-container
	emptyResultsMessage="banner-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= BannerLocalServiceUtil.getBannersByStatusGroupId(BannerKeys.INACTIVE, scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= BannerLocalServiceUtil.getBannersByStatusCount(BannerKeys.INACTIVE) %>" />

	<liferay-ui:search-container-row
		className="br.com.seatecnologia.banner.model.Banner"
		keyProperty="bannerId" modelVar="banner">
		<liferay-ui:search-container-column-text name="name"
			value="<%= banner.getName() %>" />

		<liferay-ui:search-container-column-text name="title"
			property="title" />

		<liferay-ui:search-container-column-text name="description"
			property="description" />

		<liferay-ui:search-container-column-text name="type">
			<%= (banner.getType() == 2) ? "news" : "image" %>
		
		 </liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text name="status">
			<liferay-ui:message key="inactived"/>
			<liferay-ui:icon image="close" /> 
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-jsp align="right"
			path="/html/banner/banner_actions.jsp" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>