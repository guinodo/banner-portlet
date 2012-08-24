<%@page import="br.com.seatecnologia.banner.model.Banner"%>
<%@page import="br.com.seatecnologia.banner.service.BannerLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.WindowState"%>
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
String currentURL = PortalUtil.getCurrentURL(request);


List banners = BannerLocalServiceUtil.getBannersByStatus(BannerKeys.ACTIVATED);

if(banners.size()>0){
%>
	<div class="banner_estatico">
	    <div class="banner_interno">
	<%
	for(int i=0; i< banners.size(); i++){
		Banner banner = (Banner) banners.get(i);
	%>
	            <div class="banner_content">
	                <div class="banner_texto">
	                    <h1><%= banner.getTitle() %></h1>
						<p><%= banner.getDescription() %></p>
						<div class="banner_leia_mais"><a href="$Banner.getChildren().get(2).getData()" >Leia Mais...</a></div>
					</div>
					<a href="$Banner.getChildren().get(2).getData()" class="imagem_link">
						<div class="imagem_class" style='background-image:url($Banner.getChildren().get(1).getData()); background-repeat:no-repeat; background-position:0 0;'></div>
					</a>
					 <div style="clear: both;"></div>
				</div>
		
	<%
	}
	%>
		</div>
	</div>
	<div class="final-separator"></div>
<% 
}else{
	
	renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
%>
	<div class="portlet-msg-info">
		<liferay-ui:message key="select-existing-banenr-or-add-some-banner-to-be-displayed-in-this-portlet" />
	</div>
<%
}
%>

<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="addArticleURL">
	<portlet:param name="jspPage" value="/html/banner/add_banner.jsp" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>

<liferay-ui:icon
	image="add_article"
	message="add-banner"
	url="<%= addArticleURL %>"
/>

<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="listBannnerURL">
	<portlet:param name="jspPage" value="/html/banner/list_banners.jsp" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>

<liferay-ui:icon
	cssClass="portlet-configuration"
	image="configuration"
	message="configuration"
	method="get"
	url="<%= portletDisplay.getURLConfiguration() %>"
/>

<%-- <%@ include file="/html/banner/list_banners.jsp"%> --%>