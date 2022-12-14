import java.util.Arrays;

public class MyStack<E> {
    private Object[] array = new Object[10];
    private int size = 0;

    public void push(E value) {
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
        return array[size-1];
    }

    public Object pop() {
        Object element = array[size - 1];
        System.arraycopy(array, size, array, size - 1, 1);
        array[size = size - 1] = null;
        return element;
    }

}
