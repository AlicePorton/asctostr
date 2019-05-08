import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AESTest {

    @Test
    void decoding() {
        String key = "Bar12345Bar12345";
        String initVector = "RandomInitVector";
        String value = "Hello World";
        AESCoding aesCoding = new AESCoding(key, initVector);
        assertEquals("AES", aesCoding.toString());

        byte[] encrypt = aesCoding.encrypt(value.getBytes());
        assertNotNull(encrypt);
        assertNotEquals("Hello World", new String(encrypt));

        byte[] decrypt = aesCoding.decrypt(encrypt);
        assertNotNull(decrypt);
        assertEquals("Hello World", new String(decrypt));
    }
}
