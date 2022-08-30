import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] array = new Object[10];
    private int number = 0;

    public void add(E value) {
        if (number == array.length) {
            array = Arrays.copyOf(array, array.length + array.length/2);
        }
        array[number] = value;
        number++;
        System.out.println(Arrays.toString(array));
    }
}

