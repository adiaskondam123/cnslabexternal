import javax.crypto.Cipher;
import javax.crypto.KeyGenerator; import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec; import java.util.Base64;

public class Rijndael{
    public static SecretKey generateKey(int n) throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        return keyGenerator.generateKey();
    }
    public static String encrypt(String plainText, SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte [] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    public static String decrypt(String ciphertext,SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE
        ,key);
        byte [] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes);
    }
    public static void main(String[] args) {
        try{
            SecretKey secretKey = generateKey(128);
            String plainText = "Hello, World!";
            System.out.println("Original Text:"+plainText);
            String encryptedText = encrypt(plainText, secretKey);
            System.out.println("Encrypted Text:"+encryptedText);
            String decryptedText = decrypt(encryptedText, secretKey);
            System.out.println("Decrypted Text:"+decryptedText);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

