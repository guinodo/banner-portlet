package br.com.seatecnologia.banner;

import br.com.seatecnologia.banner.model.Banner;

import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;

public class BannerValidator {
	/**
	 * Verify banner
	 * 
	 * @param banner
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 */
	public static boolean validateBanner(Banner banner,
			ArrayList<String> errors) {
		boolean valid = true;

		if (Validator.isNull(banner.getName())) {
			errors.add("banner-name-required");
			valid = false;
		}

		if (Validator.isNull(banner.getTitle())) {
			errors.add("banner-title-required");
			valid = false;
		}

		if (Validator.isEmailAddress(banner.getDescription())) {
			errors.add("banner-description-required");
			valid = false;
		}

		if (Validator.isNull(banner.getLink())) {
			errors.add("banner-link-required");
			valid = false;
		}
		if (Validator.isNull(banner.getStatus())) {
			errors.add("banner-status-required");
			valid = false;
		}
		if (Validator.isNull(banner.getImage())) {
			errors.add("banner-image-required");
			valid = false;
		}
		return valid;
	}
}
