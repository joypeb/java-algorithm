package algorithm.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}