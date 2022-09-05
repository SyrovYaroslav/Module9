import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> a = new MyLinkedList<>();
        LinkedList<String> b = new LinkedList<>();
        a.add("abc");
        a.add("bac");
        a.add("cba");
        System.out.println(a.get(1));
        System.out.println(a.size());
        a.remove(1);
        System.out.println(a.get(1));
        System.out.println(a.size());
        a.clear();
        a.add("a");
        a.add("b");
        System.out.println(a.get(0));

    }

}
