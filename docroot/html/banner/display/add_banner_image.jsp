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
	
%>

<liferay-ui:header backURL="<%= redirect %>"
	title="add-banner-image" />

<aui:form method='POST' name="edit_banner"  action="<%= saveBannerURL %>">
<aui:fieldset>
	<aui:input name="type" value="<%= BannerKeys.IMAGE %>" type="hidden" />
	<liferay-ui:error key="banner-name-required"
			message="banner-name-required" />
	<aui:input name="name" label="name" size="55" helpMessage="name-off-banner" />
	
	<liferay-ui:error key="banner-title-required"
			message="banner-title-required" />
	<aui:input name="title" label="title" size="50"/>
	
	<liferay-ui:error key="banner-description-required"
			message="banner-description-required" />
	<aui:input name="description" label="description" type="text"/>
	
	<liferay-ui:error key="banner-link-required"
			message="banner-link-required" />
	<aui:input name="link" label="link" size="50"/>
	
	<liferay-ui:error key="banner-image-required"
			message="banner-image-required" />
	<aui:input type="file" name="image" label="image"/>
	
	<aui:input name="position" label="position"/>
	
	<liferay-ui:error key="banner-status-required"
			message="banner-status-required" />
	<aui:input label="reproved" name="status" type="radio" value="1" checked="checked" />
	<aui:input label="approved" name="status" type="radio" value="0" />
	
	<aui:button name="save" type="submit" value="save" />
	<aui:button name="cancel" type="button" value="cancel" onClick="" />
</aui:fieldset>
</aui:form>
