package projectCode20280.Data_Structures.Tests;

import static org.junit.jupiter.api.Assertions.*;
import projectCode20280.Data_Structures.*;
import org.junit.jupiter.api.Test;

class ArrayStackTest {

    @Test
    void testSize() {
        ArrayStack<Integer> s = new ArrayStack<>(11);
        for(int i = 0; i < 10; ++i)
            s.push(i);
        System.out.println(s);
        assertEquals(10, s.size());
    }

    @Test
    void testIsEmpty() {
        ArrayStack<Integer> s = new ArrayStack<>(11);
        for(int i = 0; i < 10; ++i)
            s.push(i);
        for(int i = 0; i < 10; ++i) {
            s.pop();
        }
        assertTrue(s.isEmpty());
    }

    @Test
    void testPush() {
        ArrayStack<Integer> s = new ArrayStack<>(11);
        for(int i = 0; i < 10; ++i)
            s.push(i);
        assertEquals(10, s.size());
        assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", s.toString());
    }

    @Test
    void testTop() {
        ArrayStack<Integer> s = new ArrayStack<>(11);
        for(int i = 0; i < 10; ++i)
            s.push(i);
        assertEquals(9, s.top());
    }

    @Test
    void testPop() {
        ArrayStack<Integer> s = new ArrayStack<>(11);
        for(int i = 0; i < 10; ++i)
            s.push(i);
        assertEquals(9, s.pop());
        assertEquals(9, s.size());
    }

    @Test
    void testToString() {
        ArrayStack<Integer> s = new ArrayStack<>(11);
        for(int i = 0; i < 10; ++i)
            s.push(i);
        assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", s.toString());
    }
}
