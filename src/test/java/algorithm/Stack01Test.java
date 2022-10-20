package algorithm;

import algorithm.stack.Stack01;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Stack01Test {
    @Test
    void pushTest() {
        Stack01 stack = new Stack01();

        stack.push(10);
        stack.push(20);

        int[] arr = stack.getArr();

        assertEquals(10,arr[0]);
        assertEquals(20,arr[1]);
        assertEquals(20, stack.pop());
    }
}