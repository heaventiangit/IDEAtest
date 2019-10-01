package IO;

import java.io.File;
import java.io.IOException;

public class PathDemo {

    public static void main(String[] args) throws IOException {

        String path = "E:/IntelliJ IDEA/test/IO.png";

        File src = new File("E:/IntelliJ IDEA/test/haha.txt");
        boolean flag = src.createNewFile();
        System.out.println(flag);
        System.out.println(src.delete());

    }
}
