
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class ReadAndWrite {

    static void writeFile(String path, byte[] w, Coding type) {

        File f = new File(path);
        w = type.encrypt(w);
        try{
            OutputStream out = new FileOutputStream(f);
            out.write(w);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void writeFile(String path, byte[] w) {
        writeFile(path, w, StandardCoding.Empty);
    }

    static byte[] readFile(String path, Coding type) {
        try {
            InputStream in = new FileInputStream(path);
            int size = in.available();
            byte[] w = new byte[size];

            for(int i = 0; i < size; i++) {
                w[i] = (byte)in.read();
            }

            return type.decrypt(w);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static byte[] readFile(String path) {
        return readFile(path, StandardCoding.Empty);
    }
}
