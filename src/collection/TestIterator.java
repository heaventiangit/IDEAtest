package collection;

import java.util.*;

/**
 * 测试迭代器遍历 List、Set、Map
 * @author heavenTian
 */
public class TestIterator {

    public static void main(String[] args) {

//        testIteratorList();

//        testIteratorSet();

        testIteratorMap();
    }

    public static void testIteratorList(){

        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        for (Iterator<String> iter = list.iterator(); iter.hasNext();){

            String temp = iter.next();
            System.out.println(temp);
        }
    }

    public static void testIteratorSet(){

        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");

        for (Iterator<String> iter = set.iterator(); iter.hasNext();){

            String temp = iter.next();
            System.out.println(temp);
        }
    }

    public static void testIteratorMap(){

        Map<Integer, String> map = new HashMap<>();
        map.put(124, "哈哈");
        map.put(164, "呵呵");
        map.put(724, "嘻嘻");

        //第一种遍历 Map 的方式
        Set<Map.Entry<Integer, String>> ss = map.entrySet();
        for (Iterator<Map.Entry<Integer, String>> iter = ss.iterator(); iter.hasNext();){

            Map.Entry<Integer, String> kv = iter.next();
            System.out.println(kv.getKey() + "：" + kv.getValue());
        }

        //第二种遍历 Map 的方式
        Set<Integer> s = map.keySet();
        for (Iterator<Integer> iter = s.iterator(); iter.hasNext();){

            Integer temp = iter.next();
            System.out.println(temp + "：" + map.get(temp));
        }
    }
}
