package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Collections 辅助类的使用
 * @author heavenTian
 */
public class TestCollections {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            list.add("哈哈" + i);
        }
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        System.out.println(Collections.binarySearch(list, "哈哈4"));
    }
}
