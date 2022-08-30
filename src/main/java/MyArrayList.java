import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] array = new Object[10];
    private int number = 0;

    public void add(E value) {
        array[number] = value;
        number++;
        if (number == array.length) {
            array = Arrays.copyOf(array, array.length + array.length/2);
        }
        System.out.println(Arrays.toString(array));
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

