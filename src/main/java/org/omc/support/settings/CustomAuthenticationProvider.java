package org.omc.support.settings;

import org.omc.model.UserEntity;
import org.omc.model.repositories.IUserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Named
public class CustomAuthenticationProvider implements AuthenticationProvider {

    public CustomAuthenticationProvider() {
        super();
    }

    @Inject
    private IUserRepository userRepository;

    private HttpSession session;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserEntity user = this.userRepository.findByUsernameAndPassword(username, password);

        if (user != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

            UserDetails userDetails = new User(username, password, grantedAuthorities);

            return new UsernamePasswordAuthenticationToken(userDetails, password, grantedAuthorities);
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
