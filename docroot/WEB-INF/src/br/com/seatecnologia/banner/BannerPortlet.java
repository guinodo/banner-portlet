package br.com.seatecnologia.banner;

import br.com.seatecnologia.banner.model.Banner;
import br.com.seatecnologia.banner.model.impl.BannerImpl;
import br.com.seatecnologia.banner.service.BannerLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.apache.jasper.tagplugins.jstl.core.Param;

/**
 * Portlet implementation class Banner
 */
public class BannerPortlet extends MVCPortlet {
	
	public void addBanner(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{

		Banner banner = bannerFromRequest(actionRequest);
		ArrayList<String> errors = new ArrayList<String>();
		
		if (BannerValidator.validateBanner(banner, errors)){
			banner.setPrimaryKey(CounterLocalServiceUtil.increment(BannerPortlet.class.getName()));
			BannerLocalServiceUtil.addBanner(banner);
			SessionMessages.add(actionRequest, "manufacturer-added");

			sendRedirect(actionRequest, actionResponse);
		} else {
			for (String error : errors) {
				SessionErrors.add(actionRequest, error);
			}

			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			if (banner.getType() == BannerKeys.NEWS) {
				actionResponse.setRenderParameter("jspPage",
						"/html/banner/display/add_banner_news.jsp");
			}else{
					actionResponse.setRenderParameter("jspPage",
					"/html/banner/display/add_banner_image.jsp");
			}
		}
	}
	
	public void updateStatus(ActionRequest request, ActionResponse response) throws SystemException {
		
		long bannerId = ParamUtil.getLong(request, "bannerId");
		int status = ParamUtil.getInteger(request, "status");
		
		try {
			Banner banner = BannerLocalServiceUtil.getBanner(bannerId);
			banner.setStatus(status);
			BannerLocalServiceUtil.updateBanner(banner);
		} catch (Exception e) {
			SessionErrors.add(request, "nao-foi-possivel-atualizar-o-status");
			e.printStackTrace();
		}

//		response.setRenderParameter("jspPage",
//				"/html/banner/list_banners.jsp");
	}
	
	public void updateBanner(ActionRequest request, ActionResponse response) throws SystemException {
		Banner banner = bannerFromRequest(request);
		
		BannerLocalServiceUtil.updateBanner(banner);
	}
	
	
	public void deleteBanner(ActionRequest request,
			ActionResponse response) throws Exception {
		long bannerId = ParamUtil.getLong(request, "bannerId");
			if (Validator.isNotNull(bannerId)) {				
				BannerLocalServiceUtil.deleteBanner(bannerId);
				SessionMessages.add(request, "Banner-deleted");
				sendRedirect(request, response);
			} else {
				SessionErrors.add(request, "error-deleting");
			}
	}
	
	
	private BannerImpl bannerFromRequest(PortletRequest request) throws SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		BannerImpl banner = new BannerImpl();
		
		banner.setName(ParamUtil.getString(request, "name"));
		banner.setTitle(ParamUtil.getString(request, "title"));
		banner.setDescription(ParamUtil.getString(request, "description"));
		banner.setLink(ParamUtil.getString(request, "link"));
		banner.setImage(ParamUtil.getString(request, "image"));
		banner.setPosition(ParamUtil.getInteger(request, "position"));
		banner.setType(ParamUtil.getInteger(request, "type"));
		banner.setGroupId(themeDisplay.getScopeGroupId());
		
		return banner;
	}

}
