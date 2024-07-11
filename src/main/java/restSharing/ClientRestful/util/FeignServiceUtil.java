package restSharing.ClientRestful.util;


import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;



@FeignClient(value="feignDemo", url="http://localhost:8095/server")
public interface FeignServiceUtil {
	
	@GetMapping("/message")
	public String getMessage();
	
	@GetMapping("/takeMessage")
	public String takeMessage(@RequestParam String message);
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody Map<String,String> jsonObj);

}
