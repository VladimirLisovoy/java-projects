package ua.lisovoy.data_structure.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by vladimir on 03.12.16.
 */
public abstract class AbstractMapTest {

    private Map map;

    public abstract Map getMap();

    @Before
    public void before() {
        map = getMap();
        map.put("url", "google.com");
        map.put("user", "admin");
        map.put("domain", "com");
        map.put("browser", "chrome");
        map.put("password", "verySecurityPass");
        System.out.println(map);
    }

    @Test
    public void put() throws Exception {
        assertEquals("google.com", map.put("url", "luxoft.com"));
        map.put("user", "admin");
        map.put("user2", "admin");
        map.put("user3", "admin");
        map.put("user4", "admin");
        map.put("user5", "admin");
        map.put("user6", "admin");
        map.put("user7", "admin");
        map.put("user8", "admin");
        map.put("user8", "admin");
        System.out.println(map);
    }

    @Test
    public void get() throws Exception {
        assertEquals("admin", map.get("user"));
        assertNotEquals("guest", map.get("user"));
        System.out.println(map);
    }

    @Test
    public void containsKey() throws Exception {
        assertTrue("admin", map.containsKey("domain"));
        assertFalse(map.containsKey("dom"));
        System.out.println(map);
    }

    @Test
    public void putIfAbsent() throws Exception {
        assertEquals("google.com", map.putIfAbsent("url", "luxoft.com"));
        assertEquals("luxoft.com", map.putIfAbsent("urlNew", "luxoft.com"));
        System.out.println(map);
    }

    @Test
    public void getSize() throws Exception {
        assertEquals(5, map.size());
        System.out.println(map);
    }

    @Test
    public void remove() throws Exception {
        assertEquals("verySecurityPass", map.remove("password"));
        assertEquals("google.com", map.remove("url"));
        assertEquals("admin", map.remove("user"));
        System.out.println(map);
    }


    @Test
    public void putAll() throws Exception{
        HashMap<String, String> anotherMap = new HashMap<String, String>();
        anotherMap.put("user","admin");
        anotherMap.put("yellow","2");
        anotherMap.put("green","3");
        anotherMap.put("white","4");

        map.putAll(anotherMap);

        assertEquals(8,map.size());
        assertEquals("3",map.get("green"));
        System.out.println(map);
    }

}

