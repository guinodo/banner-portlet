<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="br.com.seatecnologia.banner.BannerKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<portlet:defineObjects />
<liferay-theme:defineObjects /> 
<portlet:actionURL name="addBanner" var="saveBannerURL" />

<%


int imageType = BannerKeys.IMAGE;
int newsType = BannerKeys.NEWS;

String redirect = ParamUtil.getString(request, "redirect");
String currentURL = PortalUtil.getCurrentURL(request);
	
%>
<liferay-ui:header backURL="<%= redirect %>"
	title="add-banner" />

<aui:form method='POST' name="edit_banner"  action="<%= saveBannerURL %>">
<aui:fieldset>
	
		<portlet:renderURL var="bannerNews">
			<portlet:param name="jspPage"
				value="/html/banner/edit_banner.jsp" />
			<portlet:param name="type" value="<%= String.valueOf(newsType)  %>"/>	
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:renderURL>
		
		<portlet:renderURL var="bannerImage">
			<portlet:param name="jspPage"
				value="/html/banner/edit_banner.jsp" />
			<portlet:param name="type" value="<%= String.valueOf(imageType) %>"/>
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:renderURL>
	
	<aui:select name="type" showEmptyOption="<%= true %>" label="type-banner"  onChange="window.location=this.value;" helpMessage="select-the-type-of-banner" >
			<aui:option value="<%= bannerNews %>" label="news"/>
			<aui:option value="<%= bannerImage%>" label="image"/>
	</aui:select>

</aui:fieldset>
</aui:form>
