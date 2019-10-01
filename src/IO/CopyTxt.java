package IO;

import java.io.*;

public class CopyTxt {

    public static void copyTxt(String srcPath, String destPath){

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {

            br = new BufferedReader(new FileReader(srcPath));
            bw = new BufferedWriter(new FileWriter(destPath));
            String line = null;
            while ((line=br.readLine()) != null){
                bw.append(line);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(br, bw);
        }
    }

    public static void close(Closeable ... ios){
        for (Closeable io: ios){
            try {
                if (io != null){
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        copyTxt("abc.txt", "haha.txt");
    }
}
