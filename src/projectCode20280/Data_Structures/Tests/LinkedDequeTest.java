package projectCode20280.Data_Structures.Tests;

import static org.junit.jupiter.api.Assertions.*;

import projectCode20280.Data_Structures.*;
import org.junit.jupiter.api.Test;

class LinkedDequeTest {

    @Test
    void testSize() {
        LinkedDeque<Integer> dq = new LinkedDeque<>();
        assertEquals(0, dq.size());
        dq.addFirst(0);
        assertEquals(1, dq.size());
    }

    @Test
    void testIsEmpty() {
        LinkedDeque<Integer> dq = new LinkedDeque<>();
        assertTrue(dq.isEmpty());
        dq.addFirst(0);
        assertFalse(dq.isEmpty());
        dq.removeFirst();
        assertTrue(dq.isEmpty());
    }

    @Test
    void testFirst() {
        LinkedDeque<Integer> dq = new LinkedDeque<>();
        dq.addFirst(-1);
        assertEquals(-1, dq.first());

        dq.removeFirst();
        assertNull(dq.first());


    }

    @Test
    void testLast() {
        LinkedDeque<Integer> dq = new LinkedDeque<>();
        dq.addFirst(-1);

        assertEquals(-1, dq.last());

        dq.addFirst(-2);
        assertEquals(-1, dq.last());

        dq.addLast(-3);
        assertEquals(-3, dq.last());
    }


    @Test
    void testRemoveLast() {
        LinkedDeque<Integer> dq = new LinkedDeque<>();
        dq.addFirst(-1);
        dq.addFirst(-2);
        assertEquals(-1, dq.removeLast());
    }

    @Test
    void testToString() {
        LinkedDeque<Integer> dq = new LinkedDeque<>();
        for(int i = 0; i < 5; ++i) dq.addLast(i);

        assertEquals("[0, 1, 2, 3, 4]", dq.toString());
    }

}
