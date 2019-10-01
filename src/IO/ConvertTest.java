package IO;

import java.io.*;
import java.net.URL;

/**
 * 转换流：InputStreamReader OutputStreamWriter
 * 1、以字符流的形式操作字节流（纯文本才可以，不然会破坏文件）
 * 2、可以指定字符集
 */
public class ConvertTest {

    /**
     * 在控制台输入输出，碰到 exit 退出
     */
    public static void inOut(){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String line = "";
            while (!line.equals("exit")){
                line = br.readLine();
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 输入网址、新文件名、和指定字符集
     * @param web 要下载的网址
     * @param newWeb 需要保存的文件名及地址
     * @param charset 指定下载的字符集
     */
    public static void downloadWeb(String web,String newWeb, String charset){

        //操作网络流，下载百度的源代码
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(web).openStream(), charset));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newWeb), charset))) {

            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                writer.append(line);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        downloadWeb("https://www.baidu.com/", "baidu.html", "UTF-8");
    }
}
