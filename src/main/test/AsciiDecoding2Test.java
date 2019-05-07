import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AsciiDecoding2Test {

    @Test
    void decoding() {
        assertEquals("abc", AsciiDecoding.decode("97;98;99", ";"));
        assertEquals("abc", AsciiDecoding.decode("97;98;99"));
        assertEquals("",  AsciiDecoding.decode("", ""));
    }


}
