package collection;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static void main(String[] args) {

        test01();
    }

    public static void test02(){

    }

    public static void test01(){

        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("dd");
        list1.add("ee");

        System.out.println("list：" + list);
//        list.addAll(list1); //添加
//        list.removeAll(list1); //删除相同
//        list.retainAll(list1); //保留相同
        System.out.println("list：" + list);
    }
}
