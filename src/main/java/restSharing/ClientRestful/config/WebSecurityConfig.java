package restSharing.ClientRestful.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import restSharing.ClientRestful.SecurityConfig.repo.RepoAccount;
import restSharing.ClientRestful.model.Account;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	private final CustomAuthenticationSuccessHandler successHandler;

    public WebSecurityConfig(CustomAuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }
	
	@Autowired
	RepoAccount ra;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				
				.requestMatchers("/homeAdmin").hasRole("ADMIN")
				.requestMatchers("/home").hasRole("USER")
				.requestMatchers("/","login","form", "client/signIn").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form 
				.loginPage("/login")
				.successHandler(successHandler)
				.permitAll()
			)	
			.logout((logout) -> logout
			    .permitAll()
			);

		return http.build();
	}

    @SuppressWarnings("deprecation")
	@Bean
    UserDetailsService userDetailsService() {
		List<UserDetails> usersAuth = new ArrayList<UserDetails>();
		List<Account> users = ra.findAll();
//		Role r= new Role();
		for(Account u:users) {
			
//			r=u.getRole();
			
			//Vengono caricati tutti gli utenti registrati per
			//autorizzarli all'accesso
			UserDetails user = User.withDefaultPasswordEncoder()
					.username(u.getUsername())
					.password(u.getPassword())
					.roles(u.getRole().getRoleName())
					.build();
			usersAuth.add(user);
		}

		return new InMemoryUserDetailsManager(usersAuth);
	}

	
}