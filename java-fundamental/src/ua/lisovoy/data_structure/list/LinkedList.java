package ua.lisovoy.data_structure.list;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 * Created by vladimir on 11/28/2016.
 */
public class LinkedList<E> extends AbstractList<E> {
    private Node<E> head;
    private Node<E> tail;

    @Override
    public int add(E value) {
        add(value, size);
        return size - 1;
    }

    @Override
    public void add(E value, int index) {
        validateAddIndex(index);
        Node<E> node = new Node<E>(value);
        if (size == 0) {
            head = tail = node;
        } else if (index == size) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else if (index == 0) {
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            Node<E> temp = getNode(index);
            node.next = temp;
            node.prev = temp.prev;
            temp.prev.next = temp.prev = node;
        }
        size++;
    }

    @Override
    public int indexOf(E value) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value.equals(value)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        Node<E> temp = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (temp.value.equals(value)) {
                return i;
            }
            temp = temp.prev;
        }
        return -1;
    }


    @Override
    public E set(E value, int index) {
        validateIndex(index);
        Node<E> temp = getNode(index);
        E oldValue = temp.value;
        temp.value = value;
        return oldValue;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return getNode(index).value;
    }

    private Node<E> getNode(int index) {
        Node<E> temp;
        if (index < size / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    @Override
    public void remove(int index) {
        validateIndex(index);
        if (size == 1){
            head = tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<E> temp = getNode(index);
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        }
        size--;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator<E>();
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        Node temp = head;
        for (int i = 0; i < size; i++) {
            joiner.add(String.valueOf(temp.value));
            temp = temp.next;
        }
        return joiner.toString();
    }


    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        public Node(E value) {
            this.value = value;
        }
    }

    class LinkedIterator<E> implements Iterator<E> {
        private int counter;

        @Override
        public boolean hasNext() {
            return counter < size;
        }

        @Override
        public E next() {
            return (E) getNode(counter++).value;
        }

        @Override
        public void remove() {
            LinkedList.this.remove(counter-1);
        }

    }
}

