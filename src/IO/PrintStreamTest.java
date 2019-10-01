package IO;

import java.io.*;

/**
 * 打印流：PrintStream
 */
public class PrintStreamTest {

    public static void main(String[] args) throws FileNotFoundException {

        //打印流 System.out获取系统的输出流，打印到控制台
        PrintStream ps = System.out;
        ps.println("哈哈");

        //获取文件的输出流打印到文件中
        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")), true);
        ps.println("这是一个打印流！");
        ps.close();

        //重定向输出端
        System.setOut(ps);
        System.out.print("重定向的内容！");

        //重定向会控制台
        ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true);
        System.setOut(ps);
        System.out.println("这句话会打印到控制台吗？");
    }
}
