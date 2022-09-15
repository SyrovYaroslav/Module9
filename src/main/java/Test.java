
public class Test {
    public static void main(String[] args) {
        MyHashMap<Integer, String> a = new MyHashMap<>();
        a.put(1, "1");
        a.put(11, "11");
        a.put(11, "1sdgsgs");
        a.put(12, "[eq");
        a.put(13, "13");
        a.remove(11);
        a.put(12, "[eq");
        System.out.println(a.get(11));
        System.out.println(a.get(3));
        a.clear();
        System.out.println(a.size());
    }

}
