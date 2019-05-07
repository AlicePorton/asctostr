import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AESTest {

    @Test
    void decoding() {
        String key = "Bar12345Bar12345";
        String initVector = "RandomInitVector";
        String value = "Hello World";

        byte[] encrypt = AESCoding.encrypt(key, initVector, value.getBytes());
        assertNotNull(encrypt);
        assertNotEquals("Hello World", new String(encrypt));

        byte[] decrypt = AESCoding.decrypt(key, initVector, encrypt);
        assertNotNull(decrypt);
        assertEquals("Hello World", new String(decrypt));
    }
}
