package restSharing.ClientRestful.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import restSharing.ClientRestful.SecurityConfig.repo.*;
import restSharing.ClientRestful.model.*;


@Configuration 
public class CheckRecords {

	@Autowired
	RepoAccount ra;

	@Autowired
	RepoRole rr;
	
	@Bean
	@Primary
	String getDefaultUser() {
		System.out.println("Report Check in progress");
		
		if(rr.findAll().size()==0) {
			System.out.println("Report Check in progress");
			Role r= new Role();
			r.setRoleName("ADMIN");
			rr.save(r);
			r=new Role();
			r.setRoleName("USER");
			rr.save(r);
			r=new Role();
			r.setRoleName("BANNED");
			rr.save(r);
			r=new Role();
			r.setRoleName("DELETED");
			rr.save(r);
			
			System.out.println("Default roles succesfully created!");
		}
		else {
			System.out.println("Default roles detected!");
		}
		if(ra.findAll().size()==0) {
			Account a = new Account();
			a.setUsername("root");
			a.setPassword("root");
			a.setEmail("parraasa@gmail.com");
			Role r=new Role();
			r.setId(1);
			a.setRole(r);
			ra.save(a);
			
			System.out.println("Default accounts succesfully created!");
		}
		else {
			System.out.println("Default accounts detected!");
		}
		
		return null;
	}

	
}
