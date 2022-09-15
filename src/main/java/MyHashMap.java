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
        Node<K, V> entry = table[index(key)];
        boolean colision = false;

        for (Node<K, V> element : table) {
            if (element != null) {
                amount++;
            }
        }

        if (amount == table.length) {
            table = Arrays.copyOf(table, table.length * 3/2);
        }

        if (entry == null) {
            table[index(key)] = newNode;
            size ++;
        } else {
            if (entry.getNext() == null) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    colision = true;
                }
            }
            while (entry.getNext() != null )  {
                Node<K, V> next = entry.getNext();
                entry = next;
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    colision = true;
                    break;
                }
            }
            if (!colision) {
                entry.next = newNode;
                size++;
            }
        }


    }

    public int size(){
        return size;
    }

    public void remove(K key) {
        Node<K, V> entry = table[index(key)];
        if (entry.getNext() == null) {
            if (entry.getKey().equals(key)) {
                table[index(key)] = null;
            }
            size--;
        } else {
            while (entry.getNext() != null) {
                Node<K, V> next = entry.getNext();
                if (entry.getKey().equals(key)) {
                    if (next == null) {
                        table[index(key)] = null;
                    } else {
                        entry.next = next.next;
                        entry.hash = next.hash;
                        entry.key = next.key;
                        entry.value = next.value;
                        size--;
                        break;
                    }
                }
                entry = next;
            }
        }
    }

    public Object get(K key) {
        Node<K, V> entry = table[index(key)];
        Object result = null;
        if (entry.getNext() == null) {
            if (entry.getKey().equals(key)) {
                result = entry.getValue();
            }
        } else {
            while (entry.getNext() != null) {
                Node<K, V> next = entry.getNext();
                if (entry.getKey().equals(key)) {
                    result = entry.getValue();
                    break;
                }
                entry = next;
            }
        }
        return result;
    }

    public void clear() {
        for (int i = 0;i < table.length;i++) {
            while (table[i] != null) {
                if (table[i].getNext() == null) {
                    table[i] = null;
                } else {
                    while (table[i].getNext() != null) {
                        Node<K, V> next = table[i].getNext();
                        table[i].next = next.next;
                        table[i].hash = next.hash;
                        table[i].key = next.key;
                        table[i].value = next.value;
                        table[i] = next;
                    }
                }
            }
        }
        size = 0;
    }
}
