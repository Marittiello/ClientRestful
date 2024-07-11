package restSharing.ServerRestful.controller;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import restSharing.ServerRestful.model.*;
import restSharing.ServerRestful.service.ServerRestService;

@RestController
@RequestMapping("/server")
public class ServerController {
	
	@Autowired
	ServerRestService userService;
	
//	@PostMapping("/signIn")
//	public String signIn(User user, Account account) {
//		Account account= new Account();
//		User user= new User();

		
//		account.setUsername(jsonObj.get("username"));
//		account.setEmail(jsonObj.get("email"));
//		account.setPassword(jsonObj.get("password"));
//		user.setName(jsonObj.get("name"));
//		user.setSurname(jsonObj.get("surname"));
//		user.setBirthDate(Date.valueOf(jsonObj.get("birthDate")));
//		user.setBirthPlace(jsonObj.get("birthPlace"));
//		user.setGender(jsonObj.get("gender"));
//		user.setFiscalCode(jsonObj.get("fiscalCode"));
//		user.setAddress(jsonObj.get("address"));
//		user.setZipCode(Integer.parseInt(jsonObj.get("zipCode")));
//		user.setCity(jsonObj.get("city"));
//		user.setProvince(jsonObj.get("province"));
//		user.setUserCode(generateUserCode(user));
//		account.setUser(user);
//		user.setAccount(account);
//		return userService.insert(user);
		
//	}
	public String generateUserCode(User user) {
		
		String uc="MAT000";
		int rc=0;
		do {
			for(int i=0;i<5;i++) {
				rc= (int) (Math.random() *10);
				uc+=rc;
				
			}
		}while(getByUserCode(uc)!=null);
		
		return uc;
	}
	
	public User getByUserCode(String userCode) {
		return userService.getByUserCode(userCode);
	}
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody Map<String,String> jsonObj) {
		Account account= new Account();
		User user= new User();

		System.out.println("Pagina di invio file2 raggiunta");
		account.setUsername(jsonObj.get("username"));
		account.setEmail(jsonObj.get("email"));
		account.setPassword(jsonObj.get("password"));
		user.setName(jsonObj.get("name"));
		user.setSurname(jsonObj.get("surname"));
		user.setBirthDate(Date.valueOf(jsonObj.get("birthDate")));
		user.setBirthPlace(jsonObj.get("birthPlace"));
		user.setGender(jsonObj.get("gender"));
		user.setFiscalCode(jsonObj.get("fiscalCode"));
		user.setAddress(jsonObj.get("address"));
		user.setZipCode(Integer.parseInt(jsonObj.get("zipCode")));
		user.setCity(jsonObj.get("city"));
		user.setProvince(jsonObj.get("province"));
		user.setUserCode(generateUserCode(user));
		account.setUser(user);
		user.setAccount(account);
		userService.insert(user);
		return "/home";
	}
}
