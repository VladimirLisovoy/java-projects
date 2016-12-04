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

    private List list;

    @Before
    public void before() {
        list = getList();
        list.add("First");
        list.add(4);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add("Last");
        System.out.println("Initial list: " + list);
    }

    public abstract List getList();

    @Test
    public void testAdd() throws Exception {
        System.out.println("Add one more");
        assertEquals(7, list.add("One more"));
        assertEquals(8, list.size());
        System.out.println(list);
    }

    @Test
    public void testGetSize() throws Exception {
        System.out.println("Get Size");
        assertEquals(7, list.size());
        System.out.println(list);
    }

    @Test
    public void testGetFirst() throws Exception {
        System.out.println("Get First");
        assertEquals("First", list.get(0));
        System.out.println(list);
    }

    @Test
    public void testGetMiddle() throws Exception {
        System.out.println("Get value 5, index 4");
        assertEquals(5, list.get(4));
        System.out.println(list);
    }

    @Test
    public void testGetLast() throws Exception {
        System.out.println("Get Last");
        assertEquals("Last", list.get(6));
        System.out.println(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWrong() throws Exception {
        System.out.println("Get IllegalArgumentException by index 10");
        assertEquals("Expected Exception", "First", list.get(10));
    }

    @Test
    public void testInsertFirst() throws Exception {
        System.out.println("Insert before first");
        list.add("BeforeFirst", 0);
        System.out.println(list);
        assertEquals(8, list.size());
        assertEquals("BeforeFirst", list.get(0));
    }

    @Test
    public void testInsertMiddle() throws Exception {
        System.out.println("Insert middle value");
        list.add("Middle", 3);
        System.out.println(list);
        assertEquals(8, list.size());
        assertEquals("Middle", list.get(3));
    }

    @Test
    public void testInsertLast() throws Exception {
        System.out.println("Insert after last");
        list.add("AfterLast", 7);
        System.out.println(list);
        assertEquals(8, list.size());
        assertEquals("AfterLast", list.get(7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertWrong() throws Exception {
        System.out.println("Insert wrong value 33, index 33");
        list.add(33, 33);
    }

    @Test
    public void testIndexOf() throws Exception {
        System.out.println("Index of value 4");
        assertEquals(1, list.indexOf(4));
        System.out.println("Must return -1 for index of value 40");
        assertEquals(-1, list.indexOf(40));
        System.out.println(list);
    }

    @Test
    public void testLastIndexOf() throws Exception {
        System.out.println("Last index of value 4");
        assertEquals(3, list.lastIndexOf(4));
        System.out.println("Must return -1 for Last index of value 40");
        assertEquals(-1, list.lastIndexOf(40));
        System.out.println(list);
    }

    @Test
    public void testContains() throws Exception {
        System.out.println("Contains value 4");
        assertTrue(list.contains(4));
        System.out.println("Not Contains value 40");
        assertFalse(list.contains(40));
        System.out.println(list);
    }

    @Test
    public void testSetFist() throws Exception {
        System.out.println("Set: First->FirstNew");
        assertEquals("First", list.set("FirstNew", 0));
        assertEquals("FirstNew", list.get(0));
        System.out.println(list);
    }

    @Test
    public void testSetMiddle() throws Exception {
        System.out.println("Set: 4->40");
        assertEquals(4, list.set(40, 3));
        assertEquals(40, list.get(3));
        System.out.println(list);
    }

    @Test
    public void testSetLast() throws Exception {
        System.out.println("Set: Last->LastNew");
        assertEquals("Last", list.set("LastNew", 6));
        assertEquals("LastNew", list.get(6));
        System.out.println(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetWrong() throws Exception {
        System.out.println("Set Incorrect index 10");
        list.set(10, 10);
    }

    @Test
    public void testRemoveFirst() throws Exception {
        System.out.println("Remove: First");
        list.remove(0);
        System.out.println(list);
        assertEquals(-1, list.indexOf("First"));
    }

    @Test
    public void testRemoveMiddle() throws Exception {
        System.out.println("Remove: value 3, index 2");
        list.remove(2);
        System.out.println(list);
        assertEquals(-1, list.indexOf(3));
    }

    @Test
    public void testRemoveLast() throws Exception {
        System.out.println("Remove: Last");
        list.remove(6);
        System.out.println(list);
        assertEquals(-1, list.indexOf("Last"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWrong() throws Exception {
        System.out.println("Remove wrong index 60");
        list.remove(60);
    }

    @Test
    public void testClear() throws Exception {
        System.out.println("Clear list");
        list.clear();
        System.out.println(list);
        assertEquals(-1, list.indexOf("First"));
        assertEquals(0, list.size());
    }

    @Test
    public void testIterator() throws Exception {
        System.out.println("Iterator");
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
        System.out.println("Remove value 3, index 2");
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
