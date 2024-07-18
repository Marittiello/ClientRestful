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
import restSharing.ClientRestful.SecurityConfig.repo.RepoAccount;
import restSharing.ClientRestful.model.Account;
import restSharing.ClientRestful.util.EncryptionService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	private final CustomAuthenticationSuccessHandler successHandler;

    public WebSecurityConfig(CustomAuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }
	
	@Autowired
	RepoAccount ra;

	@Autowired
	EncryptionService es;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				
				.requestMatchers("/homeAdmin","table").hasRole("ADMIN")
				.requestMatchers("/home").hasRole("USER")
				.requestMatchers("/","login","form", "client/signIn","client/myLogout").permitAll()
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


	
	@Bean
    UserDetailsService userDetailsService() {
		List<UserDetails> usersAuth = new ArrayList<UserDetails>();
		List<Account> users = ra.findAll();
		for(Account u:users) {
			//Vengono caricati tutti gli utenti registrati per
			//autorizzarli all'accesso
			UserDetails user = 
					User.withDefaultPasswordEncoder()
					.username(u.getUsername())
					.password(es.decrypt(u.getPassword()))
					.roles(u.getRole().getRoleName())
					.build();
			usersAuth.add(user);
		}

		return new InMemoryUserDetailsManager(usersAuth);
	}
	
	
}