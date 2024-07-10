package restSharing.ClientRestful.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value="feignDemo", url="http://localhost:8095/server")
public interface FeignServiceUtil {
	
	@GetMapping("/message")
	public String getMessage();
	
	@GetMapping("/takeMessage")
	public String takeMessage(@RequestParam String message);
	
	@PostMapping("/datasFromForm")
	public String datasFromForm(@RequestParam String nome, @RequestParam String cognome);

}
