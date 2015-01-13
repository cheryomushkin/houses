package houses.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;

class CustomUserDetailsService implements UserDetailsService {

    public static final String ROLE_ADMIN = "ADMIN";
//    public static final String ROLE_USER = "USER";

    List<UserDetails> details = Arrays.<UserDetails>asList(
            new SimpleUserDetails("admin", "password", ROLE_ADMIN),
            new SimpleUserDetails("neo", "password",  ROLE_ADMIN));

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (UserDetails details : this.details)
            if (details.getUsername().equalsIgnoreCase(username))
                return details;
        return null;
    }
}