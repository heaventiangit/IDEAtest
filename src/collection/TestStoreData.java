package collection;

import java.util.*;

/**
 * 测试表格数据的存储
 * @author heavenTian
 */
public class TestStoreData {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        map.put("id", 1234);
        map.put("name", "张三");
        map.put("salary", 3000);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", 12345);
        map1.put("name", "张四");
        map1.put("salary", 30000);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 1834);
        map2.put("name", "张五");
        map2.put("salary", 8000);

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map2);
        for (Map<String, Object> temp: list){
            Set<String> key = temp.keySet();
            for (String k: key){
                System.out.print(k + "：" + temp.get(k) + "\t");
            }
            System.out.println();
        }
    }
}
