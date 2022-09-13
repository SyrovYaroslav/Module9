import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V>   {
    private Node<K, V>[] table = (Node<K,V>[])new Node[10];

    private int size;

    static class Node<K,V>{
        int hash;
        K key;
        V value;

        public Node<K, V> getNext() {
            return next;
        }

        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }

        public void setNext(Node<K,V> next) {
            this.next = next;
        }

        public final int hashCode() {
            return Objects.hash(key, value);
        }

        public void setValue(V newValue) {
            value = newValue;
        }

        public final boolean equals(Object o) {
            if (o == this) {return true;}
            if (o == null || getClass() != o.getClass()) {return  false;}
            Node<K, V> node = (Node<K, V>) o;
            return Objects.equals(key, node.getKey()) &&
                    Objects.equals(value, node.getValue());
        }
    }

    public int index(K key) {
        int hash = key.hashCode();
        return hash % table.length;
    }

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<K, V>(hashCode() , key, value, null);
        int amount = 0;
        Node<K, V> x = table[index(key)];
        boolean colision = false;

//        for (Node<K, V> element : table) {
//            if (element != null) {
//                amount++;
//            }
//        }
//        if (amount == table.length) {
//            table = Arrays.copyOf(table, table.length * 3/2);
//        }

        if (x == null) {
            table[index(key)] = newNode;
        } else {
            if (x.getNext() == null) {
                if (x.getKey().equals(key)) {
                    x.setValue(value);
                }
            }
            while (x.getNext() != null )  {
                if (x.getKey().equals(key)) {
                    x.setValue(value);
                    colision = true;
                    break;
                }
                Node<K, V> next = x.getNext();
                x = next;
            }
            x.next = newNode;
            if (!colision && x.getNext() == null ) {
                x.next = newNode;
            }
        }

        size++;
    }

    public int size(){
        return size;
    }

}
