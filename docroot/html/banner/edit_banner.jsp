<%@page import="br.com.seatecnologia.banner.model.impl.BannerImpl"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="br.com.seatecnologia.banner.service.BannerLocalServiceUtil"%>
<%@page import="br.com.seatecnologia.banner.model.Banner"%>
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
Banner banner = new BannerImpl();
long bannerId = ParamUtil.getLong(request, "bannerId");

if (bannerId > 0) {
	banner = BannerLocalServiceUtil.getBanner(bannerId);
}

String redirect = ParamUtil.getString(request, "redirect");
int imageType = BannerKeys.IMAGE;
int newsType = BannerKeys.NEWS;

String type = ParamUtil.getString(request, "type");

long groupId = ParamUtil.getLong(request, "groupId", scopeGroupId);
%>


<liferay-ui:header backURL="<%= redirect %>"
	title='<%= banner != null ? banner.getName() : "add-banner" %>' />

<aui:model-context bean="<%= banner %>" model="<%= Banner.class %>" />

	<liferay-ui:error key="banner-name-required" message="banner-name-required" />
	<liferay-ui:error key="banner-title-required" message="banner-description-required" />
	<liferay-ui:error key="banner-link-required" message="banner-link-required" />
	<liferay-ui:error key="banner-status-required" message="banner-status-required" />
	<liferay-ui:error key="banner-description-required" message="banner-title-required" />
	<liferay-ui:error key="banner-image-required" message="banner-image-required" />


<aui:form method='POST' name="edit_banner"  action="<%= saveBannerURL %>">
<aui:fieldset>
	<aui:input type="hidden" name="bannerId" />
	
	<aui:input name="type" value='<%= type %>' type="hidden" />
	<aui:input name="name" label="name" size="55" helpMessage="name-off-banner" />
	<aui:input name="title" label="title" size="50"	/>
	<aui:input name="description" label="description" type="textarea" style="height: 105px; width: 500px;"	/>
	<aui:input name="link" label="link" size="50" />
	
	<div dataType="image_gallery">
			<aui:input cssClass="lfr-input-text-container" inlineField="<%= true %>" label="" name="image" size="55" type="text" />

			<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" var="selectIGURL">
				<portlet:param name="struts_action" value="/moderacaoportlet/add_banner" />
				<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" /> 
			</portlet:renderURL>

			<%
			Map<String,Object> data = new HashMap<String,Object>();

			data.put("ImagegalleryUrl", selectIGURL);
			%>

			<aui:button cssClass="journal-imagegallery-button" value="select" />
	</div>
			
	<aui:input label="approved" name="status" type="radio" checked="<%= BannerKeys.ACTIVATED == banner.getStatus() %>" />
	<aui:input label="reproved" name="status" type="radio" checked="<%= BannerKeys.INACTIVE == banner.getStatus() %>" />
	
	<aui:button name="save" type="submit" value="save" />
	<aui:button name="cancel" type="button" value="cancel" onClick="<%= redirect %>" />
</aui:fieldset>
</aui:form>



<%-- <aui:script>
	var <portlet:namespace />documentLibraryInput = null;
	var <portlet:namespace />imageGalleryInput = null;
	var <portlet:namespace />contentChangedFlag = false;

	function <portlet:namespace />selectImageGallery(url) {
		document.getElementById(<portlet:namespace />imageGalleryInput).value = url;
	}

</aui:script> --%>

	<%-- <liferay-ui:error key="banner-image-required"
			message="banner-image-required" />
	<aui:input type="file" name="image" label="image"
		value='<%= banner == null ? "" : banner.getImage() %>'
	/>
	
	<aui:input name="position" label="position"
		value='<%= banner == null ? "" : banner.getPosition() %>'
	/> --%>
		
 	