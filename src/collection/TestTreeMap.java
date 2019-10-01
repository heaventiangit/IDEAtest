package collection;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {

    public static void main(String[] args) {

        Map<Integer, String> m = new TreeMap<>();
        m.put(20, "aa");
        m.put(6, "bb");
        m.put(2, "cc");

        for (Integer i: m.keySet()){
            System.out.println(i);
        }

        Map<Employee, String> m2 = new TreeMap<>();
        m2.put(new Employee(300, "张三", 20000), "我是张三");
        m2.put(new Employee(200, "李四", 20000), "我是李四");
        m2.put(new Employee(300, "王麻子", 3000), "我是王麻子");

        for (Employee employee: m2.keySet()){
            System.out.println(employee);
        }
    }
}
