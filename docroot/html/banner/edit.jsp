<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="org.eclipse.jdt.internal.compiler.lookup.InferenceContext"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<liferay-theme:defineObjects /> 
<portlet:defineObjects />

<%

//recupera a tab, se a tab for null vai setar a primeira tab dos names
String tabs1 = ParamUtil.getString(request, "tabs1", "banners-active");
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("struts_action", "/banner/view");
portletURL.setParameter("tabs1", tabs1);
 
%>


<liferay-ui:tabs 
	names="banners-active,banners-inative" 
	refresh="true" 
	url="<%=portletURL.toString() %>" 
	>
	
	<liferay-ui:section >
		<%@ include file="/html/banner/list_banners_actived.jsp"%>
	</liferay-ui:section>
	<liferay-ui:section >
		<%@ include file="/html/banner/list_banners_inactived.jsp"%>
	</liferay-ui:section>
</liferay-ui:tabs>
