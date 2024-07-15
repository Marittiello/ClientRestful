package restSharing.ClientRestful.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		String redirectUrl = null;

		for (GrantedAuthority authority : authentication.getAuthorities()) {
			if (authority.getAuthority().equals("ROLE_ADMIN")) {
				redirectUrl = "/homeAdmin";
				break;
			} else if (authority.getAuthority().equals("ROLE_USER")) {
				redirectUrl = "/home";
				break;
			}
		}

		if (redirectUrl == null) {
			throw new IllegalStateException();
		}
		response.sendRedirect(redirectUrl);
		}
	}
