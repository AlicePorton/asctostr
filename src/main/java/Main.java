import java.io.File;

public class Main {

    public static void main(String[] args) {
        String test = "<% jsp %>";
        byte[] w = test.getBytes();
        String loopFile = "src/loop.txt";
        while(true) {

            File file = new File(loopFile);
            if (file.exists()) continue;
            ReadAndWrite.writeFile(loopFile, w);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }

    }

}
