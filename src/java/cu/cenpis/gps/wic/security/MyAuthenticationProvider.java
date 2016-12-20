package cu.cenpis.gps.wic.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(final Authentication authentication)
			throws AuthenticationException {

		Authentication res = isValid(authentication);
		if (!res.isAuthenticated()) {
			throw new BadCredentialsException("Bad credentials");
		}
		return res;
	}

	private Authentication isValid(final Authentication authentication) {
		Authentication res = authentication;
		System.out.println("Selected method: "
				+ ((MyAuthenticationDetails) authentication.getDetails())
						.getMethod());
		if ("Admin".equals(authentication.getPrincipal())
				&& "Password".equals(authentication.getCredentials())) {
			res = createSuccessAuthentication(authentication);
		}
		return res;
	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	protected Authentication createSuccessAuthentication(
			final Authentication authentication) {
		// Ensure we return the original credentials the user supplied,
		// so subsequent attempts are successful even with encoded passwords.
		// Also ensure we return the original getDetails(), so that future
		// authentication events after cache expiry contain the details
	
		List<GrantedAuthority> AUTHORITIES = new ArrayList<>();
		//AUTHORITIES.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		
		
		final UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
				authentication.getPrincipal(), authentication.getCredentials(),
				AUTHORITIES);
		result.setDetails(authentication.getDetails());

		return result;
	}
}
