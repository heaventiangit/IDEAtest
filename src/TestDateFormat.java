import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间对象和字符串之间的互相转化
 * DateFormat抽象类和SimpleDateFormat实现类的使用
 * @author heavenTian
 */
public class TestDateFormat {

    public static void main(String[] args) {
        //把时间对象按照指定的格式转换成相应的字符串
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");

        String s = df.format(new Date());
        System.out.println(s);

        System.out.println(df.format(new Date(40000000)));

        //把字符串按指定格式转换成时间对象
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");

        try {
            Date date = df2.parse("2019年6月7日 03:23:56");
            System.out.println(df2.format(date));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
