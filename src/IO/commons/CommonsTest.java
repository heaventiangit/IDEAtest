package IO.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.util.Collection;

public class CommonsTest {

    public static void test1(){

        //文件的大小
        long len = FileUtils.sizeOf(new File("io.png"));
        System.out.println(len);

        //文件夹的大小
        len = FileUtils.sizeOf(new File("D:\\学习\\java\\尚学堂 Java 视频教程全集\\08_IO流技术\\003_code\\015-027\\IO_study04"));
        System.out.println(len);
    }

    public static void test2(){

        Collection<File> files = FileUtils.listFiles(new File("D:/KuGou"), EmptyFileFilter.NOT_EMPTY, null);
        for (File file: files){
            System.out.println(file.getAbsolutePath());
        }
    }

    public static void main(String[] args) {

//        test1();
        test2();
    }
}
