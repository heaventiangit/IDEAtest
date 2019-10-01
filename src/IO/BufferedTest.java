package IO;

import java.io.*;

/**
 * 测试字节输入输出包装类 BufferedInputStream BufferedOutputStream
 *      InputStream is = new BufferedInputStream(new FileInputStream("dest.txt"));
 *      OutputStream os = new BufferedOutputStream(new FileOutputStream("dest2.txt"));
 * 和字符输入输出包装类 BufferedReader BufferedWriter
 *      BufferedReader br = new BufferedReader(new FileReader(srcPath));
 *      BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));
 */
public class BufferedTest {

    /**
     * 字符输入包装类，可以逐行读取
     * @param reader
     */
    public static void fileReader(Reader reader){

        BufferedReader br = null;

        try {
            br = new BufferedReader(reader);
            String line = null;
            while ((line=br.readLine()) != null){ //逐行读取
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字符输出包装类，可以逐行输出。
     * @param writer
     */
    public static void fileWriter(Writer writer){

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(writer);
            bw.write("伯克伦德街160号，目送伦纳德单手拽着“海之言”手杖飞出这“隐秘”的世界后，克莱恩将注意力放回了周围。");
            bw.newLine();
            bw.append("伯克伦德街160号，目送伦纳德单手拽着“海之言”手杖飞出这“隐秘”的世界后，克莱恩将注意力放回了周围。");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        try {
            Reader reader = new FileReader("dest.txt");
            fileReader(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Writer writer = new FileWriter("haha.txt");
            fileWriter(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
