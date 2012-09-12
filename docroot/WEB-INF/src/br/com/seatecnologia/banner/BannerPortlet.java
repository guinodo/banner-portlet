package br.com.seatecnologia.banner;

import br.com.seatecnologia.banner.model.Banner;
import br.com.seatecnologia.banner.model.impl.BannerImpl;
import br.com.seatecnologia.banner.service.BannerLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

/**
 * Portlet implementation class Banner
 */
public class BannerPortlet extends MVCPortlet {
	
	public void addBanner(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		
		Banner banner = new BannerImpl();
		banner.setPrimaryKey(CounterLocalServiceUtil.increment(BannerPortlet.class.getName()));
		
		banner = bannerFromRequest(actionRequest, banner);
		ArrayList<String> errors = new ArrayList<String>();
		
		if (BannerValidator.validateBanner(banner, errors)){
			BannerLocalServiceUtil.addBanner(banner);
			SessionMessages.add(actionRequest, "manufacturer-added");

			sendRedirect(actionRequest, actionResponse);
		} else {
			for (String error : errors) {
				SessionErrors.add(actionRequest, error);
			}

			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			actionResponse.setRenderParameter("jspPage",
						"/html/banner/edit_banner.jsp");

		}
	}
	
	public void updateStatus(ActionRequest request, ActionResponse response) throws SystemException {
		
		long bannerId = ParamUtil.getLong(request, "bannerId");
		int status = ParamUtil.getInteger(request, "status");
		
		try {
			Banner banner = BannerLocalServiceUtil.getBanner(bannerId);
			banner.setStatus(status);
				if (status==BannerKeys.INACTIVE)
					banner.setPosition(0);
//				else
//					banner.setPosition(BannerLocalServiceUtil.getBannersByStatusCount(BannerKeys.ACTIVATED)+1);		

				BannerLocalServiceUtil.updateBanner(banner);
		} catch (Exception e) {
			SessionErrors.add(request, "nao-foi-possivel-atualizar-o-status");
			e.printStackTrace();
		}

		response.setRenderParameter("jspPage",
				"/html/banner/edit.jsp");
	}
	
	public void updateBanner(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		long bannerId = ParamUtil.getLong(request, "bannerId");
		Banner banner = BannerLocalServiceUtil.getBanner(bannerId);
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
	
	public void updatePosition (ActionRequest request, ActionResponse response) throws Exception  {
		
//		int position = ParamUtil.getInteger(request, "position");
//		int position2 = ParamUtil.getInteger(request, "position2");
//				
//		Banner actualBannerPos = BannerLocalServiceUtil.getBannerByPosition(position);
//		Banner modiffiBannerPos = BannerLocalServiceUtil.getBannerByPosition(position2);	
//		
//		actualBannerPos.setPosition(position2);
//		modiffiBannerPos.setPosition(position);
//		
//		BannerLocalServiceUtil.updateBanner(actualBannerPos);
//		BannerLocalServiceUtil.updateBanner(modiffiBannerPos);
//		
//		System.out.println("position "+position);
		
		
//		System.out.println("bannerlist "+banners.size());
	}
	
	
	private Banner bannerFromRequest(PortletRequest request, Banner banner) throws SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
		
		System.out.println("portletId>>"+portletId);
		
		banner.setName(ParamUtil.getString(request, "name"));
		banner.setTitle(ParamUtil.getString(request, "title"));
		banner.setDescription(ParamUtil.getString(request, "description"));
		banner.setLink(ParamUtil.getString(request, "link"));
		banner.setImage(ParamUtil.getString(request, "image"));
		banner.setPosition(BannerLocalServiceUtil.getBannersCount()+1);
		banner.setType(ParamUtil.getInteger(request, "type"));
		banner.setGroupId(themeDisplay.getScopeGroupId());
		banner.setPortletId(portletId);
		banner.setPlId(themeDisplay.getPlid());
		
		return banner;
	}

}
