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
        System.out.println(Arrays.toString(array));
    }

    public void remove(int index) {
        for(int i = 0; i < array.length; i++) {
            for (int k = 0; k < array.length - 1; k++) {
                if (i == index) {
                    Object temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }
        number--;
        array = Arrays.copyOf(array, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[i] = null;
            }
        }
        number = 0;
        System.out.println(Arrays.toString(array));
    }

    public void size() {
        int counter = 0;
        for (Object o : array) {
            if (o != null) {
                counter++;
            }
        }
        System.out.println(counter);
    }


    public Object get(int index) {
        return array[index];
    }
}

