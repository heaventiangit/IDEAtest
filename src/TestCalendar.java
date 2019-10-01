import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 测试日期类 Calendar 的使用
 * @author heavenTian
 */
public class TestCalendar {
    public static void main(String[] args) {

        Calendar calendar = new GregorianCalendar(2010,2,23,7,34,45);
        System.out.println(calendar);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //星期几
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        System.out.println(year+"年"+month+"月"+day+"日"+" "+hour+"点"+minute+"分"+second+"秒");
        System.out.println("星期" + weekDay);

        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, 5009);
        System.out.println(c);
        c.add(Calendar.YEAR, -5);
        System.out.println(c.get(Calendar.YEAR));

        //时间和日期类的相互转换
        Date d = c.getTime();
        System.out.println(d);
        c.setTime(d);
    }
}
