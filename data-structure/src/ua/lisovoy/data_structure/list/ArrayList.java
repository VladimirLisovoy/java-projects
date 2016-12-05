package ua.lisovoy.data_structure.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by vladimir on 11/28/2016.
 */
public class ArrayList<E> extends AbstractList<E> {

    private static final int INITIAL_CAPACITY = 5;
    private static final double INCREASE_PERCENTAGE = 1.5;

    E[] array;

    public ArrayList() {
        array = (E[]) new Object[INITIAL_CAPACITY];
    }

    private int getNewCapacity() {
        return (int) (array.length * INCREASE_PERCENTAGE);
    }

    @Override
    public int add(E value) {
        add(value, size);
        return size - 1;
    }

    @Override
    public void add(E value, int index) {
        validateAddIndex(index);
        if (size == array.length) {
            int newCapacity = getNewCapacity();
            E[] arrayExtend = (E[]) new Object[newCapacity];
            System.arraycopy(array, 0, arrayExtend, 0, size);
            array = arrayExtend;
        }
        System.arraycopy(array, index, array, index+1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E set(E value, int index) {
        validateIndex(index);
        E oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public void remove(int index) {
        validateIndex(index);
        System.arraycopy(array, index+1, array, index, size - index - 1);
        array[size-1] = null;
        size--;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>();
    }


    class ArrayIterator<E> implements Iterator<E> {
        private int counter;

        @Override
        public boolean hasNext() {
            return counter < size;
        }

        @Override
        public E next() {
            return (E) array[counter++];
        }

        @Override
        public void remove() {
            ArrayList.this.remove(counter-1);
        }

    }

}
