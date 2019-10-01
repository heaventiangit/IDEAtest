import java.io.File;
import java.io.IOException;

/**
 * File 类的基本用法
 * @author heavenTian
 */
public class TestFile {

    public static void main(String[] args) throws IOException {

        File f = new File("C:\\Users\\lisiy\\Desktop\\最近/测试.txt");
//        System.out.println(f);
//
//        //改名字
//        f.renameTo(new File("C:\\Users\\lisiy\\Desktop\\最近/测试3.txt"));
//
//        //获取项目所在空间
//        System.out.println(System.getProperty("user.dir"));
//
//        File f2 = new File("haha.txt");
//        f2.createNewFile();

        System.out.println(f.getName());
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.length());
    }
}
