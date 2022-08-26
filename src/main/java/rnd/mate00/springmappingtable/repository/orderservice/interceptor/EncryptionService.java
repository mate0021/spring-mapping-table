package rnd.mate00.springmappingtable.repository.orderservice.interceptor;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class EncryptionService {

    public String encrypt(String freeText) {
        return Base64.getEncoder().encodeToString(freeText.getBytes());
    }

    public String decrypt(String encryptedText) {
        return new String(Base64.getDecoder().decode(encryptedText));
    }
}
