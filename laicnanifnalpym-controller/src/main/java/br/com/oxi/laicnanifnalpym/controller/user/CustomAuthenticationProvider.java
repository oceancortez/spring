package br.com.oxi.laicnanifnalpym.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import br.com.oxi.laicnanifnalpym.middleware.service.user.UserService;
import br.com.oxi.laicnanifnalpym.repository.domain.UserEntity;
import br.com.oxi.laicnanifnalpym.utils.enums.Message;
import br.com.oxi.laicnanifnalpym.utils.enums.Route;
import br.com.oxi.laicnanifnalpym.utils.exceptions.UserNotFoundException;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final static Logger LOGGER = Logger.getLogger(CustomAuthenticationProvider.class);

	public CustomAuthenticationProvider() {
		super();
	}

	@Autowired
	private UserService userService;

	private HttpSession session;

	@Override
	@Transactional
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String email = authentication.getName();
		String password = authentication.getCredentials().toString();
		UserEntity user = this.userService.findUserByEmailAndPassword(email, password);
		ModelAndView modelAndView = new ModelAndView();
		if (user != null) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

			UserDetails userDetails = new User(email, password, grantedAuthorities);
			
			modelAndView.setViewName(Route.USER_HOME.toString());
			return new UsernamePasswordAuthenticationToken(userDetails, password, grantedAuthorities);

		} else {			
			 throw new BadCredentialsException(Message.USER_NOT_FOUND.toString());
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
