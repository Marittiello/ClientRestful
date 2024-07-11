package restSharing.ClientRestful.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import restSharing.ClientRestful.SecurityConfig.repo.RepoAccount;
import restSharing.ClientRestful.model.Account;


@Configuration 
public class CheckRecords {

	@Autowired
	RepoAccount ra;

	@Bean
	@Primary
	String getDefaultUser() {
		System.out.println("Check in corso controllo records");
		if(ra.findAll().size()==0) {
			Account a = new Account();
			a.setUsername("root");
			a.setPassword("root");
			a.setEmail("admin@gmail.com");
			ra.save(a);
			System.out.println("Creazione users di default eseguita!");
		}
		else {
			System.out.println("Account di default rilevato!");
		}
		return null;
	}

}
