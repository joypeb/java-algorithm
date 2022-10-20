package algorithm.stack;

public class Stack02 {
    private Integer[] arr;
    private int top = 0;

    public Stack02() {
        this.arr = new Integer[10000];
    }
    public Stack02(int size) {
        this.arr = new Integer[size];
    }

    public Integer[] getArr() {
        return arr;
    }

    public void push(int value) {
        this.arr[this.top++] = value;
    }

    public int pop() {
        int value = this.arr[--this.top];
        return value;
    }
}
