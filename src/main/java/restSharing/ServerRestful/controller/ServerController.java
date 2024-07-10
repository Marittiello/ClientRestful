package restSharing.ServerRestful.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/server")
public class ServerController {
	
	@GetMapping("/message")
	public String getMessage() {
		return "Messaggio dal rest lato server";
	}
	
	@GetMapping("/takeMessage")
	public String takeMessage(@RequestParam String message) {
		System.out.println(message);
		return "home";
	}
	
	@PostMapping("/datasFromForm")
	public String datasFromForm(@RequestParam String nome, @RequestParam String cognome) {
		System.out.println(nome+" "+cognome);
		return "home";
	}

}
