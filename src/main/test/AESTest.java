import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AESTest {

    @Test
    void decoding() {
        String key = "Bar12345Bar12345";
        String initVector = "RandomInitVector";
        String value = "Hello World";
        String encrypt = AESCoding.encrypt(key, initVector, value);
        assertNotEquals("Hello World", encrypt);
        String decrypt = AESCoding.decrypt(key, initVector, encrypt);
        assertEquals("Hello World", decrypt);
    }
}
