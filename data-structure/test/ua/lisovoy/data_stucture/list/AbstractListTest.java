package ua.lisovoy.data_stucture.list;

import org.junit.Before;
import org.junit.Test;
import ua.lisovoy.data_structure.list.List;

import java.util.Iterator;

import static org.junit.Assert.*;


/**
 * Created by vladimir on 11/28/2016.
 */
public abstract class AbstractListTest {

    private List<Integer> list;

    @Before
    public void before() {
        list = getList();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list);
    }

    public abstract List<Integer> getList();

    @Test
    public void testAdd() throws Exception {
        assertEquals(7, list.add(8));
        assertEquals(8, list.size());
        System.out.println(list);
    }

    @Test
    public void testGetSize() throws Exception {
        int size = list.size();
        assertEquals(7, size);
        System.out.println(size);
    }

    @Test
    public void testGetFirst() throws Exception {
        Integer firstValue = list.get(0);
        System.out.println(firstValue);
        assertEquals(new Integer(1), firstValue);
    }

    @Test
    public void testGetMiddle() throws Exception {
        Integer middleValue = list.get(4);
        System.out.println(middleValue);
        assertEquals(new Integer(5), middleValue);
    }

    @Test
    public void testGetLast() throws Exception {
        Integer lastValue = list.get(6);
        System.out.println(lastValue);
        assertEquals(new Integer(7), lastValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWrong() throws Exception {
        assertEquals(new Integer(1), list.get(10));
    }

    @Test
    public void testInsertFirst() throws Exception {
        list.add(0, 0);
        System.out.println(list);
        assertEquals(8, list.size());
        assertEquals(new Integer(0), list.get(0));
    }

    @Test
    public void testInsertMiddle() throws Exception {
        list.add(3, 3);
        System.out.println(list);
        assertEquals(8, list.size());
        assertEquals(new Integer(3), list.get(3));
    }

    @Test
    public void testInsertLast() throws Exception {
        list.add(8, 7);
        System.out.println(list);
        assertEquals(8, list.size());
        assertEquals(new Integer(8), list.get(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertWrong() throws Exception {
        list.add(33, 33);
    }

    @Test
    public void testIndexOf() throws Exception {
        assertEquals(1, list.indexOf(4));
        assertEquals(-1, list.indexOf(40));
        System.out.println(list);
    }

    @Test
    public void testLastIndexOf() throws Exception {
        assertEquals(3, list.lastIndexOf(4));
        assertEquals(-1, list.lastIndexOf(40));
        System.out.println(list);
    }

    @Test
    public void testContains() throws Exception {
        boolean contains = list.contains(4);
        assertTrue(contains);
        System.out.println(contains);
    }

    @Test
    public void testNotContains() throws Exception {
        boolean contains = list.contains(40);
        assertFalse(contains);
        System.out.println(contains);
    }

    @Test
    public void testSetFist() throws Exception {
        assertEquals(new Integer(1), list.set(100, 0));
        assertEquals(new Integer(100), list.get(0));
        System.out.println(list);
    }

    @Test
    public void testSetMiddle() throws Exception {
        assertEquals(new Integer(4), list.set(40, 3));
        assertEquals(new Integer(40), list.get(3));
        System.out.println(list);
    }

    @Test
    public void testSetLast() throws Exception {
        assertEquals(new Integer(7), list.set(70, 6));
        assertEquals(new Integer(70), list.get(6));
        System.out.println(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetWrong() throws Exception {
        list.set(10, 10);
    }

    @Test
    public void testRemoveFirst() throws Exception {
        list.remove(0);
        System.out.println(list);
        assertEquals(-1, list.indexOf(1));
    }

    @Test
    public void testRemoveMiddle() throws Exception {
        list.remove(2);
        System.out.println(list);
        assertEquals(-1, list.indexOf(3));
    }

    @Test
    public void testRemoveLast() throws Exception {
        list.remove(6);
        System.out.println(list);
        assertEquals(-1, list.indexOf(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWrong() throws Exception {
        list.remove(60);
    }

    @Test
    public void testClear() throws Exception {
        list.clear();
        System.out.println(list);
        assertEquals(-1, list.indexOf(1));
        assertEquals(0, list.size());
    }

    @Test
    public void testIterator() throws Exception {
        int index = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Object value = iterator.next();
            System.out.println(value);
            assertEquals(list.get(index), value);
            index++;
        }
    }

    @Test
    public void testIteratorRemove() throws Exception {
        int index = 0;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            iterator.next();
            if (index == 2) {
                iterator.remove();
            }
            index++;
        }
        System.out.println(list);
        assertEquals(-1, list.indexOf(3));
    }

}
