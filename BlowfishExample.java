import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class BlowfishExample{
    public static SecretKey generateKey(int keySize) throws Exception{
      KeyGenerator  keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(keySize);
        return keyGenerator.generateKey();
    }
    public static String encyrpt(String plaintext,SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte [] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    public static String decrypt(String ciphertext , SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte [] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes);
    }
    public static void main(String[] args) {
        try{
            SecretKey secretKey = generateKey(128);
            String plaintext="Hello, World!";
            System.out.println("Original Text:"+plaintext);
            String encryptedText = encyrpt(plaintext, secretKey);
            System.out.println("Decrypted Text:"+encryptedText);
            String decryptedText = decrypt(encryptedText, secretKey);
            System.out.println("DecryptedText:"+decryptedText);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
    







