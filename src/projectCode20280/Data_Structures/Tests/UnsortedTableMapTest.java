package projectCode20280.Data_Structures.Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import projectCode20280.Data_Structures.UnsortedTableMap;

public class UnsortedTableMapTest {

    @Test
    void testPut() {
        UnsortedTableMap<Integer,String> tm = new UnsortedTableMap<>();

        for (int i = 0; i < 5; i++) {
            tm.put(i, Integer.toString(i));
        }

        assertEquals("[<0, 0>, <1, 1>, <2, 2>, <3, 3>, <4, 4>]", tm.toString());
    }

    @Test
    void testGet() {
        UnsortedTableMap<Integer,String> tm = new UnsortedTableMap<>();

        for (int i = 0; i < 5; i++) {
            tm.put(i, Integer.toString(i));
        }

        assertEquals("3", tm.get(3));
        assertEquals("0", tm.get(0));
        assertEquals("4", tm.get(4));
    }

    @Test
    void testRemove() {
        UnsortedTableMap<Integer,String> tm = new UnsortedTableMap<>();

        for (int i = 0; i < 5; i++) {
            tm.put(i, Integer.toString(i));
        }

        assertEquals("3", tm.remove(3));
        assertEquals("[<0, 0>, <1, 1>, <2, 2>, <4, 4>]", tm.toString());

        assertEquals("4", tm.remove(4));
        assertEquals("[<0, 0>, <1, 1>, <2, 2>]", tm.toString());
    }



    @Test
    void testSize() {
        UnsortedTableMap<Integer,String> tm = new UnsortedTableMap<>();

        for (int i = 0; i < 5; i++) {
            tm.put(i, Integer.toString(i));
        }

        assertEquals(5 ,tm.size());
    }

    @Test
    void testIsEmpty() {
        UnsortedTableMap<Integer,String> tm = new UnsortedTableMap<>();

        assertTrue(tm.isEmpty());

        for (int i = 0; i < 5; i++) {
            tm.put(i, Integer.toString(i));
        }

        assertFalse(tm.isEmpty());
    }
}
