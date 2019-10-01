package IO;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * 打印流：PrintWriter
 */
public class PrintWriterTest {

    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("printWriter.heaven")));
        pw.append("打印流");
        pw.write("哈哈");
        pw.close();
    }
}
