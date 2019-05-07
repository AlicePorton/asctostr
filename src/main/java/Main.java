import java.io.File;

public class Main {

    public static void main(String[] args) {
        String test = "<% jsp %>";
        byte[] w = test.getBytes();
        String key = "Bar12345Bar12345";
        String initVector = "RandomInitVector";

        w = AESCoding.encrypt(key, initVector, w);
        String loopFile = "src/loop.txt";
        while(true) {

            File file = new File(loopFile);
            if (file.exists()) continue;
            assert w != null;
            System.out.println(new String(w));
            ReadAndWrite.writeFile(loopFile, AESCoding.decrypt(key, initVector, w));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }

    }

}
