package collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试 HashSet 基本用法
 * @author heavenTian
 */
public class TestHashSet {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("aa");
        set.add("bb");
        set.add("aa");
        System.out.println(set);
    }
}
