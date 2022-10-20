package algorithm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class Stack02Test {

    @BeforeEach
    void setUp() {
        System.out.println("beforepush");
    }

    @Test
    @DisplayName("push가 잘되는지")
    void pushAndPop() {
        Stack02 st = new Stack02();
        st.push(10);
        st.push(20);

        Integer[] arr = st.getArr();

        assertEquals(20,st.pop());
        assertEquals(10,st.pop());


    }

    @Test
    void isEmpty() {
        Stack02 st = new Stack02();

        assertTrue(st.isEmpty());
        st.push(1);

        assertFalse(st.isEmpty());

        st.pop();

        assertTrue(st.isEmpty());

        assertThrows(EmptyStackException.class, () -> {
            st.pop();
        });
    }

    @Test
    void realStack() {
        Stack<Integer> st = new Stack<>();

        assertThrows(EmptyStackException.class, () -> {
            st.pop();
        });
    }

    @Test
    void peek() {
        Stack02 st = new Stack02();

        assertThrows(EmptyStackException.class, () -> {
            st.peek();
        });

        st.push(10);
        assertEquals(10, st.peek());

    }
}