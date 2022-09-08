import java.util.HashMap;
import java.util.Objects;

public class MyHashMap<K, V>   {
    private Node<K, V>[] table = (Node<K,V>[])new Node[10];
    private int size;

    static class Node<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }


        public final int hashCode() {
            return Objects.hash(key, value);
        }

        public void setValue(V newValue) {
            value = newValue;
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return  false;
            }
            Node<K, V> node = (Node<K, V>) o;
            return Objects.equals(key, node.getKey()) &&
                    Objects.equals(value, node.getValue());
        }
    }

    public void put(K key, V value) {
        int hash = key.hashCode();
        int i = hash % table.length;
        table[i] = new Node<K, V>(hash , key, value, null);
    }

}
