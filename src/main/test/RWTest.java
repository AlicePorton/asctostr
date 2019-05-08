import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RWTest {

    @Test
    void AESRead() {
        String readFilePath = "src/test.txt";
        byte[] encrypt = ReadAndWrite.readFile(readFilePath, StandardCoding.AES);
        assertNotNull(encrypt);
        assertEquals("Test Success", new String(encrypt));
    }

    @Test
    void AsciiRead() {
        String readFilePath = "src/test_data/asc_test.txt";
        byte[] encrypt = ReadAndWrite.readFile(readFilePath, StandardCoding.ASCII);
        assertNotNull(encrypt);
        assertEquals("Test Success", new String(encrypt));
    }

    @Test
    void AsciiWrite() {
        String value = "Test Success";
        String writeFilePath = "src/test_data/asc_test.txt";
        ReadAndWrite.writeFile(writeFilePath, value.getBytes(), StandardCoding.ASCII);
        byte[] t = ReadAndWrite.readFile(writeFilePath, StandardCoding.ASCII);
        assertNotNull(t);
        assertEquals(value, new String(t));
    }

    @Test
    void AESWrite() {

        String value = "Write test Success";
        byte[] w = value.getBytes();
        String writeFilePath = "src/aes_test.txt";
        ReadAndWrite.writeFile(writeFilePath, w, StandardCoding.AES);
        byte[] t = ReadAndWrite.readFile(writeFilePath, StandardCoding.AES);
        assertNotNull(t);
        assertEquals(value, new String(t));
    }

    @BeforeAll
    static void AESAdd() {
        try {
            OutputStream out = new FileOutputStream("src/test.txt");
            Coding aes = StandardCoding.AES;
            byte[] w = aes.encrypt("Test Success".getBytes(StandardCharsets.UTF_8));
            out.write(w);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterAll
    static void close() {
        boolean delete1 = new File("src/write_test.txt").delete();
        boolean delete = new File("src/aes_test.txt").delete();
        boolean delete3 = new File("src/test.txt").delete();
    }
}
