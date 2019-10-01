package collection;

import java.util.HashMap;

/**
 * 自定义 HashSet 类
 * @author heavenTian
 */
public class MyHashSet<E> {

    private HashMap<E, Object> map;
    private static final Object PRESENT = new Object();

    public MyHashSet(){
        map = new HashMap<>();
    }

    public int size(){
        return map.size();
    }

    public void add(E element){
        map.put(element, PRESENT);
    }
}
