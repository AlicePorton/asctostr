import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StandardTest {

    @Test
    void AES() {
        Coding AES = StandardCoding.AES;
        String value = "Hello World";
        byte[] encrypt = AES.encrypt(value.getBytes());
        assertNotNull(encrypt);
        assertNotEquals("Hello World", new String(encrypt));

        byte[] decrypt = AES.decrypt(encrypt);
        assertNotNull(decrypt);
        assertEquals("Hello World", new String(decrypt));
    }

    @Test
    void Empty() {
        Coding emptyCoding = StandardCoding.Empty;
        String value = "Hello World";
        byte[] encrypt = emptyCoding.encrypt(value.getBytes());
        assertNotNull(encrypt);
        assertEquals("Hello World", new String(encrypt));

        byte[] decrypt = emptyCoding.decrypt(encrypt);
        assertNotNull(decrypt);
        assertEquals("Hello World", new String(decrypt));
    }

    @Test
    void Ascii() {
        Coding asciiCoding = StandardCoding.ASCII;
        String value = "Hello World";
        String ascValue = "48656c6c6f20576f726c64";
        byte[] encrypt = asciiCoding.encrypt(value.getBytes());
        assertNotNull(encrypt);
        assertEquals(ascValue, new String(encrypt));

        byte[] decrypt = asciiCoding.decrypt(encrypt);
        assertNotNull(decrypt);
        assertEquals("Hello World", new String(decrypt));
    }


}
