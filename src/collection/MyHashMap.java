package collection;

/**
 * 自定义一个 HashMap 类
 * @author heavenTian
 */
public class MyHashMap<K, V> {

    private HashNode<K, V>[] table; //位桶数组。bucket array
    private int size; //存放的键值对的个数

    public int size(){
        return size;
    }

    public V get(K key){

        int hash = myHash(key.hashCode(), table.length);
        V value = null;

        if (table[hash] != null){
            HashNode temp = table[hash];
            while (temp != null){
                if (key.equals(temp.getKey())){
                    value = (V) temp.getValue();
                    break;
                }
                temp = temp.getNext();
            }
        }

        return value;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < table.length; i++){
            HashNode hn = table[i];
            if (hn != null){
                while (true){
                    sb.append(hn.getKey() + ":" + hn.getValue());
                    sb.append(", ");
                    hn = hn.getNext();
                    if (hn == null){
                        break;
                    }
                }
            }
        }
        sb.deleteCharAt(sb.length()-2);
        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();
    }

    public void put(K key, V value){

        //定义新的节点对象
        HashNode<K, V> hn = new HashNode<>();
        hn.setHash(myHash(key.hashCode(), table.length));
//        System.out.println(hn.getHash());
        hn.setKey(key);
        hn.setValue(value);

        //把节点放入数组中
        HashNode temp = table[hn.getHash()];
        boolean flag = false;
        if (temp == null){
            table[hn.getHash()] = hn;
        }else {
            while (true){
                if (temp.getKey().equals(hn.getKey())){
                    temp.setValue(hn.getValue());
                    flag = true;
                    break;
                }

                if (temp.getNext() == null){
                    temp.setNext(hn);
                    break;
                }
                temp = temp.getNext();
            }
        }
        if (!flag)
            size++;
    }

    private int myHash(int v, int length){
//        System.out.println("hash is myHash" + (v&(length-1))); //直接位运算，效率高
//        System.out.println("hash is myHash" + (v%(length-1))); //取模运算，效率低
        return v&(length-1);
    }

    private MyHashMap(){
        table = new HashNode[16];
    }

    public static void main(String[] args) {

        MyHashMap<Integer, String> hm = new MyHashMap<>();
        hm.put(10, "aa");
        hm.put(20, "bb");
        hm.put(30, "cc");
        hm.put(20, "abc");

        hm.put(53, "哈哈");
        hm.put(69, "呵呵");
        hm.put(85, "嘻嘻");
        hm.put(68, "看过来");

        System.out.println(hm);
        System.out.println(hm.get(68));
        System.out.println(hm.size());
    }
}
