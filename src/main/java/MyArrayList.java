import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] array = new Object[10];

    public void add(Object value) {
        int namber = 0;
        array[namber] = value;
        namber++;
        if (namber == array.length) {
            array = Arrays.copyOf(array, array.length + array.length/2);
        }
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }
}

