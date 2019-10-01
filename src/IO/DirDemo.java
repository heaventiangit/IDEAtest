package IO;

import java.io.File;

/**
 * 创建目录
 * @author heavenTian
 */
public class DirDemo {

    public static void main(String[] args) {

        File src = new File("E:/IntelliJ IDEA/test");

        printName(src, 1);
    }

    public static void printName(File file, int deep){
        for (int i = 1; i <= deep; i++){
            System.out.print("-");
        }

        System.out.println(file.getName());
        if (file==null || !file.exists()){
            return;
        }else {
            if (file.isDirectory()){
                for (File f: file.listFiles()){
                    printName(f, deep+1);
                }
            }
        }
    }
}
