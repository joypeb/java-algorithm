package algorithm.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private int[] arr = new int[10000];
    private List<Integer> arl = new ArrayList<>();
    private int pointer = 0;

    public Stack() {
    }

    public Stack(int size) {
        this.arr = new int[size];
    }

    public void push(int value) {
        this.arr[this.pointer] = value;
        pointer++;
    }

    public int pop() {
        int value = this.arr[this.pointer-1];
        this.pointer--;
        return value;
    }

    public int[] getArr() {
        return arr;
    }
}
