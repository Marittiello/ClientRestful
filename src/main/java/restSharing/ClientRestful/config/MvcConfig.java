package restSharing.ClientRestful.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/form").setViewName("form");
		registry.addViewController("/homeAdmin").setViewName("homeAdmin");
		registry.addViewController("/table").setViewName("table");
//		registry.addViewController("/server/signIn").setViewName("home");
	}

}
