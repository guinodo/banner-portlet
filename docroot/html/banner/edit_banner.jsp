<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
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

Group group = GroupLocalServiceUtil.getGroup(groupId);

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("jspPage", "/html/banner/select_image_gallery.jsp");
portletURL.setParameter("groupId", String.valueOf(groupId));
portletURL.setWindowState(LiferayWindowState.POP_UP);

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
			
	<aui:input label="approved" name="status" type="radio" checked="<%= BannerKeys.ACTIVATED == banner.getStatus() %>" />
	<aui:input label="reproved" name="status" type="radio" checked="<%= BannerKeys.INACTIVE == banner.getStatus() %>" />
	
	
	<aui:input id="journal_imagegallery_button" inlineField="<%= true %>" label="image" name="journalImagegallery" size="55" type="text" />

	<aui:button  value="select" onClick="showPopup()" />
	
	
	<aui:button name="save" type="submit" value="save" />
	<aui:button name="cancel" type="button" value="cancel" onClick="<%= redirect %>" />
</aui:fieldset>
</aui:form>

<aui:script>

	Liferay.Util.focusFormField(<portlet:namespace />journal_imagegallery_button);

	var url = "asdasd";
	
	document.getElementById(<portlet:namespace />journal_imagegallery_button).value = url;
	
	function showPopup() {
		AUI().ready('aui-dialog','aui-dialog-iframe','liferay-portlet-url', function(A) {
	         window.myDialog = new A.Dialog(             
	         	{                 
	         		title: 'Galeria de imagens',                 
	         		width: 640,                 
	         		centered: true             
	         	}         
	         	).plug(
	         		A.Plugin.DialogIframe,             
	         		{                 
	         			uri: '<%= portletURL.toString() %>',                 
	         			iframeCssClass: 'dialog-iframe'             
	         		}         
	         	).render();     
		}); 
	}
	
	

</aui:script>
