package restSharing.ClientRestful.controller;


import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import restSharing.ClientRestful.ClientRestfulApplication;
import restSharing.ClientRestful.SecurityConfig.repo.RepoAccount;
import restSharing.ClientRestful.model.*;
import restSharing.ClientRestful.util.FeignServiceUtil;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	FeignServiceUtil fsu;
	
	@PostMapping("/signIn")
    public String signIn(@ModelAttribute User user, @ModelAttribute Account account) {
		
        Map<String, String> jsonObj = new HashMap<  >();
        jsonObj.put("name", user.getName());
        jsonObj.put("username", account.getUsername());
        jsonObj.put("email", account.getEmail());
        jsonObj.put("password", account.getPassword());
        jsonObj.put("surname", user.getSurname());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        jsonObj.put("birthDate", dateFormat.format(user.getBirthDate()));
        jsonObj.put("birthPlace", user.getBirthPlace());
        jsonObj.put("fiscalCode", user.getFiscalCode());
        jsonObj.put("address", user.getAddress());
        jsonObj.put("city", user.getCity());
        jsonObj.put("province", user.getProvince());
        jsonObj.put("zipCode", String.valueOf(user.getZipCode()));
        jsonObj.put("gender", user.getGender());

        return fsu.signIn(jsonObj);
    }
	
	@Autowired
	RepoAccount ra;
	
		
	@GetMapping("/myLogout")
	public String myLogout() {
		ClientRestfulApplication.restart();
		return "redirect:/login";
	}
}
