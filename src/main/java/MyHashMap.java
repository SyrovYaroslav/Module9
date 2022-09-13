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
        Node<K, V> lastNode = null;
        int amount = 0;
        boolean colision = false;

//        for (Node<K, V> element : table) {
//            if (element != null) {
//                amount++;
//            }
//        }
//        if (amount == table.length) {
//            table = Arrays.copyOf(table, table.length * 3/2);
//        }

        if (table[index(key)] == null) {
            table[index(key)] = newNode;
        } else {
            if (table[index(key)].getNext() == null) {
                if (table[index(key)].getKey().equals(key)) {
                    table[index(key)].setValue(value);
                }
            }
            while (table[index(key)].getNext() != null )  {
                if (table[index(key)].getKey().equals(key)) {
                    table[index(key)].setValue(value);
                    colision = true;
                    break;
                }
                table[index(key)] = table[index(key)].getNext();
            }
            if (!colision && table[index(key)].getNext() == null ) {
                table[index(key)].next = newNode;
            }
        }
        System.out.println(Arrays.toString(table));
        System.out.println(table[index(key)].getKey());
        System.out.println(table[index(key)].getValue());
        System.out.println(table[index(key)].getNext());

        size++;
    }

    public int size(){
        return size;
    }

}
