import java.util.Arrays;

public class MyQueue<E> {
    private Object[] array = new Object[10];
    private int size = 0;

    public void add(E value) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 3/2);
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        array[size = size - 1] = null;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        return array[0];
    }

    public Object poll() {
        Object element = array[0];
        array = Arrays.copyOfRange(array, 1, array.length);
        size--;
        return element;
    }
}
