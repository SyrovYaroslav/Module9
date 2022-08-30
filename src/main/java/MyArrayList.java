import java.util.Arrays;

public class MyArrayList {
    private Object[] array = {};

    public void add(Object value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }
}

