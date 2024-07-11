package restSharing.ClientRestful.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import restSharing.ClientRestful.ClientRestfulApplication;
import restSharing.ClientRestful.model.*;
import restSharing.ClientRestful.util.FeignServiceUtil;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	FeignServiceUtil fsu;
	
	@GetMapping("/message")
	public String getMessage() {
		System.out.println(fsu.getMessage());
		return "home";
	}
	
	@GetMapping("/takeMessage")
	public String takeMessage(@RequestParam String message) {
		return fsu.takeMessage(message);
	}
	
	@PostMapping("/signIn")
	public String signIn(User user,Account account) {
		System.out.println("Pagina di invio dati raggiunta");
		Map<String,String> jsonObj= new HashMap<String,String>();
		jsonObj.put("username", account.getUsername());
		jsonObj.put("password", account.getPassword());
		jsonObj.put("email", account.getEmail());
		jsonObj.put("name", user.getName());
		jsonObj.put("surname", user.getSurname());
		jsonObj.put("birthDate", ""+user.getBirthDate());
		jsonObj.put("birthPlace", user.getBirthPlace());
		jsonObj.put("gender", user.getGender());
		jsonObj.put("fiscalCode", user.getFiscalCode());
		jsonObj.put("address", user.getAddress());
		jsonObj.put("zipCode", ""+user.getZipCode());
		jsonObj.put("city", user.getCity());
		jsonObj.put("province", user.getProvince());
		String flag=fsu.signIn(jsonObj);
//		ClientRestfulApplication.restart();
		return flag;
	}
	
}
