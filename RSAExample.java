import java.math.BigInteger; import java.security.KeyFactory; import java.security.KeyPair;
import java.security.KeyPairGenerator; import java.security.PrivateKey; import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec; import java.security.spec.RSAPublicKeySpec; import javax.crypto.Cipher;
public class RSAExample {
     public static void main(String[] args) {
        try{
            KeyPairGenerator keypairGenerator = KeyPairGenerator.getInstance("RSA");
            keypairGenerator.initialize(2048);
            KeyPair keyPair = keypairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            printKeyDetails(publicKey,privateKey);
            String plainText = "Hello,RSA";
            System.out.println("Original Text:"+plainText);
            byte [] encryptedText = encrypt(plainText,publicKey);
            System.out.println("Encrypted Text:"+new String(encryptedText));
            String decryptedText = decrypt(encryptedText,privateKey);
            System.out.println("Decrypted Text:"+decryptedText);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     }
     public static byte[] encrypt(String plaintext,PublicKey publicKey) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return cipher.doFinal(plaintext.getBytes());
     }
     public static String decrypt(byte[] ciphertext,PrivateKey privateKey) throws Exception
     {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decryptedBytes = cipher.doFinal(ciphertext);
        return new String(decryptedBytes);
     }
     public static void printKeyDetails(PublicKey publicKey , PrivateKey privateKey) throws Exception{
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
        RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

        System.out.println("Public Key Modulus: " + publicKeySpec.getModulus());
        System.out.println("Public Key Exponent:"+publicKeySpec.getPublicExponent());
      System.out.println("Private Key Modulus: " + privateKeySpec.getModulus());
       System.out.println("Private Key Exponent: " + privateKeySpec.getPrivateExponent());
     }
    
}
