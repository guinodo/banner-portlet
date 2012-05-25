

<%@page import="br.com.seatecnologia.banner.BannerKeys"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="br.com.seatecnologia.banner.model.Banner"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>


<portlet:defineObjects />
<liferay-theme:defineObjects /> 
<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Banner banner = (Banner) row.getObject();

	long groupId = banner.getGroupId();
	String name = banner.getClass().getName();
	long bannerId = banner.getBannerId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
%>

<liferay-ui:icon-menu>
		<portlet:actionURL name="updateStatus" var="desactivateURL">
			<portlet:param name="bannerId"
				value="<%= String.valueOf(bannerId) %>" />
			<portlet:param name="status" value="<%= String.valueOf(BannerKeys.INACTIVE) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>

		<portlet:actionURL name="updateStatus" var="activeURL">
			<portlet:param name="bannerId"
				value="<%= String.valueOf(bannerId) %>" />
			<portlet:param name="status" value="<%= String.valueOf(BannerKeys.ACTIVATED) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>

		<portlet:renderURL var="editURL">
			<portlet:param name="jspPage"
				value="/html/banner/edit_banner.jsp" />
			<portlet:param name="bannerId"
				value="<%= String.valueOf(bannerId) %>" />
			<portlet:param name="type"
				value="<%= String.valueOf(banner.getStatus()) %>" />	
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:renderURL>


		<portlet:actionURL name="deleteBanner" var="deleteURL">
			<portlet:param name="bannerId"
				value="<%= String.valueOf(bannerId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>
	<% if(banner.getStatus()==1){ %>
		<liferay-ui:icon image="close" message="desactivate"  url="<%= desactivateURL %>" /> 
		<% }else{ %>
		<liferay-ui:icon image="top" message="activate"  url="<%= activeURL %>" /> 
	<%}%>	
		<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />
		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" confirmation="sure-you-want-to-delete-this-banner" />
</liferay-ui:icon-menu>