import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RWTest {

    @Test
    void read() {
        String readFilePath = "src/test.txt";
        byte[] w = ReadAndWrite.readFile(readFilePath);
        assertNotNull(w);
        assertEquals("Test Success", new String(w));
    }

    @Test
    void write() {

        String value = "Write test Success";
        byte[] w = value.getBytes();
        String writeFilePath = "src/test.txt";
        ReadAndWrite.writeFile(writeFilePath, w);
        byte[] t = ReadAndWrite.readFile(writeFilePath);
        assertNotNull(t);
        assertEquals(value, new String(t));
    }


    @AfterAll
    static void close() {
        new File("src/write_test.txt").delete();
    }
}
