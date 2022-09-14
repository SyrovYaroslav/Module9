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

        for (Node<K, V> element : table) {
            if (element != null) {
                amount++;
            }
        }

        if (amount == table.length) {
            table = Arrays.copyOf(table, table.length * 3/2);
        }

        if (x == null) {
            table[index(key)] = newNode;
            size ++;
        } else {
            if (x.getNext() == null) {
                if (x.getKey().equals(key)) {
                    x.setValue(value);
                    colision = true;
                }
            }
            while (x.getNext() != null )  {
                Node<K, V> next = x.getNext();
                x = next;
                if (x.getKey().equals(key)) {
                    x.setValue(value);
                    colision = true;
                    break;
                }
            }
            if (!colision) {
                x.next = newNode;
                size++;
            }
        }


    }

    public int size(){
        return size;
    }

    public void remove(K key) {
        Node<K, V> x = table[index(key)];
        if (x.getNext() == null) {
            if (x.getKey().equals(key)) {
                table[index(key)] = null;
            }
            size--;
        } else {
            while (x.getNext() != null) {
                Node<K, V> next = x.getNext();
                if (x.getKey().equals(key)) {
                    x.next = next.next;
                    x.hash = next.hash;
                    x.key = next.key;
                    x.value = next.value;
                    size--;
                    break;
                }
                x = next;
            }
        }
    }

    public Object get(K key) {
        Node<K, V> x = table[index(key)];
        Object result = null;
        if (x.getNext() == null) {
            if (x.getKey().equals(key)) {
                result = x.getValue();
            }
        } else {
            while (x.getNext() != null) {
                Node<K, V> next = x.getNext();
                x = next;
                if (x.getKey().equals(key)) {
                    result = x.getValue();
                    break;
                }
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
