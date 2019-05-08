import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

class AESCoding extends Coding {
    AESCoding(String key, String initVector) {
        super("AES", key, initVector);
    }
    static final AESCoding INSTANCE = new AESCoding("Bar12345Bar12345", "RandomInitVector");

    byte[] encrypt(String key, String initVector, byte[] value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value);

            return Base64.getEncoder().encode(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    byte[] decrypt(String key, String initVector, byte[] encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
            
            
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            String test = new String(encrypted);
            byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(encrypted));
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
