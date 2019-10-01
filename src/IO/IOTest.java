package IO;

import java.io.*;

public class IOTest {

    /**
     * 用字节流
     * 一个一个读取文件
     * @param file
     */
    public static void fileRead(File file){

        InputStream is = null;

        //选择流
        try {
            is = new FileInputStream(file);
            //读取操作
//            int data1 = is.read();
//            int data2 = is.read();
//            int data3 = is.read();
//            int data4 = is.read();
//            int data5 = is.read();
//            int data6 = is.read();
//            System.out.println((char)data1);
//            System.out.println((char)data2);
//            System.out.println((char)data3);
//            System.out.println((char)data4);
//            System.out.println((char)data5);
//            System.out.println(data6);

            int temp;
            while ((temp=is.read()) != -1){
                System.out.print((char)temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if (is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 用字节流
     * 一段一段读取文件
     * @param file
     */
    public static String fileRead2(File file){

        InputStream is = null;
        StringBuilder sb = new StringBuilder();

        //选择流
        try {
            is = new FileInputStream(file);
            //分段读取操作

            byte[] temp = new byte[1024]; //缓冲容器
            int len = -1; //接收长度
            while ((len=is.read(temp)) != -1){
                //字节数组转换成字符串
                String s = new String(temp, 0, len);
                sb.append(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if (is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 用字节流
     * 写入文件
     * @param file
     */
    public static void fileWrite(File file){

        OutputStream os = null;
        try {
            //如果文件不存在OutputStream自动创建
//            os = new FileOutputStream(file); //覆盖文件数据
            os = new FileOutputStream(file, true); //在文件末尾追加数据
            //写入操作
            String s = "This is my demo!";
            byte[] datas = s.getBytes();
            os.write(datas, 0, datas.length);
            //刷新一下
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 用字节流
     * 写入文件（传入字符串）
     * @param file 需要写入的目标文件
     * @param s 要写入的字符串
     */
    public static void fileWrite(File file, String s, boolean append){

        OutputStream os = null;
        try {
            //如果文件不存在OutputStream自动创建
//            os = new FileOutputStream(file); //覆盖文件数据
            os = new FileOutputStream(file, append); //在文件末尾追加数据
            //写入操作
            byte[] datas = s.getBytes();
            os.write(datas, 0, datas.length);
            //刷新一下
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 复制文件（把文件 f1 写入 f2）
     * @param f1
     * @param f2
     * @param append 是否向后追加
     */
    public static void fileCopy(File f1, File f2, boolean append){

        //实现1
//        fileWrite(f2, fileRead2(f1));

        //实现2
        InputStream is = null;
        OutputStream os = null;
        try {

            //判断文件夹有没有
//            if (!f2.exists()){
//                System.out.println("hi");
//                f2.mkdirs();
//            }

            is = new FileInputStream(f1);
            os = new FileOutputStream(f2, append);

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
    }

    /**
     * 用字符流读取字符文件（对比用字节流一般不会出现乱码）
     * @param file
     */
    public static void fileReader(File file){

        Reader reader = null;

        try {

            reader = new FileReader(file);
            //分段读取

            char[] flush = new char[1024];
            int len = -1;
            while ((len=reader.read(flush)) != -1){
                String s = new String(flush);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件字符输出流输出文件
     * @param file
     */
    public static void fileWriter(File file){

        Writer writer = null;

        try {

            writer = new FileWriter(file);
            String s = "蒸汽与机械的浪潮中，谁能触及非凡？历史和黑暗的迷雾里，又是谁在耳语？我从诡秘中醒来，睁眼看见这个世界：\n" +
                    "　　枪械，大炮，巨舰，飞空艇，差分机；魔药，占卜，诅咒，倒吊人，封印物……光明依旧照耀，神秘从未远离，这是一段“愚者”的传说。";

            //写法一
//            writer.write(s);

            //写法二
//            char[] data = s.toCharArray();
//            writer.write(data); //字符串 -->字符数组

            //写法三
            writer.append(s).append("\n没想到吧");

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字节数组输入流
     * 资源可以不用关闭
     */
    public static void byteInput(){

        //创建源
        byte[] src = "This is my City".getBytes();

        //选择流
        InputStream is = null;

        try {
            is = new ByteArrayInputStream(src);
            byte[] flush = new byte[5];
            int len = -1;
            while ((len=is.read(flush)) != -1){
                String s = new String(flush, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字节数组输出流
     */
    public static void byteOutput(){

        byte[] src = null;

        ByteArrayOutputStream os = null;

        try {
            os = new ByteArrayOutputStream();
            String s = "This is my City";
            byte[] datas = s.getBytes();
            //写入数据
            os.write(datas, 0, datas.length);
            os.flush();

            //获取数据
            src = os.toByteArray();
            System.out.println(src.length + "-->" + new String(src, 0, src.length));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 图片读取到字节数组中
     */
    public static byte[] fileToByteArray(String filePath){

        File file = new File(filePath);
        byte[] dest = null;

        InputStream is = null;
        ByteArrayOutputStream bo = null;

        try {

            is = new FileInputStream(file);
            bo = new ByteArrayOutputStream();
            byte[] datas = new byte[1024];
            int len = -1;
            while ((len=is.read(datas)) != -1){
                bo.write(datas, 0, len); //写出到字节数组中
            }
            bo.flush();
            return bo.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * 字节数组写出到文件中
     */
    public static void byteArrayToFile(byte[] src, String filePath){

        ByteArrayInputStream bi = null;
        OutputStream os = null;
        File file = new File(filePath);

        try {

            bi = new ByteArrayInputStream(src);
            os = new FileOutputStream(file);
            byte[] flush = new byte[5]; //缓冲容器
            int len = -1;
            while ((len=bi.read(flush)) != -1){
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        File abc = new File("abc.txt");
        File dest = new File("dest.txt");
        File file = new File("IO.png");
        File file2 = new File("C:/Users/lisiy/Desktop/最近/test/IO.png");

//        fileRead(file);
//        fileRead2(file);
//        fileWrite(file);
//        fileCopy(file, file2, false);
//        fileReader(abc);
//        fileWriter(dest);
//        byteInput();
//        byteOutput();
        byte[] datas = fileToByteArray("C:/Users/lisiy/Desktop/最近/test/IO.png");
        System.out.println(datas.length);
        byteArrayToFile(datas, "C:/Users/lisiy/Desktop/最近/test/IO3.png");
    }
}
