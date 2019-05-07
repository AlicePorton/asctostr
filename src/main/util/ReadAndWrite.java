
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadAndWrite {
    public static void writeFile(String path, byte[] w) {
        File f = new File(path);
        try{
            OutputStream out = new FileOutputStream(f);
            out.write(w);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    static byte[] readFile(String path) {
        try {
            InputStream in = new FileInputStream(path);
            int size = in.available();
            byte[] w = new byte[size];

            for(int i = 0; i < size; i++) {
                w[i] = (byte)in.read();
            }
            return w;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
