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
/*якщо масив арр = а б с д е. наш індекс нехай буде 2. newSize = size - 1 (5 -1 = 4).
Якщо аррейКопі(арр, index + 1, app, index, newSize - index(4 - 2 = 2))
Ми кажемо скопію частину масиву починаючи з індексу 3, в той самий масив,
тобто починаючи з 3го індексу будуть елементи д та е.
І кажемо поклади ці 2 елементи в той самий масив починаючи з 2 індексу, тобто а б с там в же є,
але починаючи з 2го буде а б і сюди вставляємо те що скопіювали, тобто 2 елементи -> а б д е, все
 */
    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, number - 1 - index);
        array[number = number - 1] = null;
        System.out.println(Arrays.toString(array));
    }

    public void clear() {
        Arrays.fill(array, null);
        number = 0;
    }

    public int size() {
        return number;
    }


    public Object get(int index) {
        return array[index];
    }
}

