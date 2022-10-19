package algorithm.star;

public class RightTriangle {
    private char letter = '*';

    public RightTriangle() {
    }

    public RightTriangle(char letter) {
        this.letter = letter;
    }

    public void rightTriangle(int num) {

        for(int i=0; i<num; i++) {
            for(int j=0; j<i+1; j++) {
                System.out.printf("%c",letter);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        RightTriangle rightTriangle = new RightTriangle('@');

        rightTriangle.rightTriangle(4);
    }
}
