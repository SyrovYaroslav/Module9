import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] array = new Object[10];
    private int number = 0;

    public void add(E value) {
        if (number == array.length) {
            array = Arrays.copyOf(array, array.length * 3/2);
        }
        array[number] = value;
        number++;
    }

    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, number - 1 - index);
        array[number = number - 1] = null;
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[i] = null;
            }
        }
        number = 0;
    }

    public int size() {
        return number;
    }


    public Object get(int index) {
        return array[index];
    }
}

