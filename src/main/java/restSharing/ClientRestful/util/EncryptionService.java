package restSharing.ClientRestful.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.stereotype.Component;

@Component
public class EncryptionService {
	
	
	public String encrypt(String data) {
	StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setPassword("Biagino");        
    String encryptedText = encryptor.encrypt(data);
    return encryptedText;
	}
	public String decrypt(String encryptedText) {
    StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
    decryptor.setPassword("Biagino");  
    String decryptedText = decryptor.decrypt(encryptedText);
    return decryptedText;
    }
}
