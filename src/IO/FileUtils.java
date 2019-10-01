package IO;

import java.io.*;

/**
 * 封装复制文件
 * 封装拷贝文件
 * @heavenTian
 */
public class FileUtils {

    public static void copy(InputStream is, OutputStream os){

        try {

            byte[] temp = new byte[1024];
            int len = -1;
            while ((len=is.read(temp)) != -1){
                //转换成字符串在转换成文件，不能正确转换图片之类的文件
//                String s = new String(temp, 0, len);
//                byte[] data = s.getBytes();
//                os.write(data, 0, data.length);
                os.write(temp, 0, len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            close(is, os);
        }
    }

    /**
     * 释放资源封装
     * @param is
     * @param os
     */
    public static void close(InputStream is, OutputStream os){

        try {
            if (os != null){
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (is != null){
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源（改）
     * 因为输入输出流都实现了 Closeble 接口
     * @param ios
     */
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

        //文件到文件
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("dest.txt"));
            OutputStream os = new BufferedOutputStream(new FileOutputStream("dest2.txt"));
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte [] datas = null;
        //文件到字节数组
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("IO.png"));
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            copy(is, bo);
            datas = bo.toByteArray();
            System.out.println(datas);
            System.out.println(datas.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //字节数组到文件
        try {
            ByteArrayInputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("IO2.png");
            copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
