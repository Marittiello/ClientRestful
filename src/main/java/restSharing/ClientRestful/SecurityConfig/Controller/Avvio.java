package restSharing.ClientRestful.SecurityConfig.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import restSharing.ClientRestful.ClientRestfulApplication;
import restSharing.ClientRestful.SecurityConfig.repo.RepoAccount;



@RequestMapping("/Avvio")
@Controller
public class Avvio {

	@Autowired
	RepoAccount ra;
	
	@GetMapping("/myLogout")
	public String myLogout() {
		ClientRestfulApplication.restart();
		return "/logIn";
	}
}
