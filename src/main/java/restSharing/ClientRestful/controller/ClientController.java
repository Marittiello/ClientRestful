package restSharing.ClientRestful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
	
	@PostMapping("/datasFromForm")
	public String datasFromForm(@RequestParam String nome, @RequestParam String cognome) {
		return fsu.datasFromForm(nome, cognome);
	}
	
}
