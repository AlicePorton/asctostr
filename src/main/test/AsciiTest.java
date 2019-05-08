import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

class AsciiTest {


    @Test
    void derypt() {
        String value = "546573742053756363657373";
        byte[] w = StandardCoding.ASCII.decrypt(value.getBytes());
        assertEquals("Test Success", new String(w));
    }

    @Test
    void encrypt() {
        String value = "Test Success";
        byte[] w = StandardCoding.ASCII.encrypt(value.getBytes(StandardCharsets.US_ASCII));
        assertEquals("546573742053756363657373", new String(w));
    }


}
