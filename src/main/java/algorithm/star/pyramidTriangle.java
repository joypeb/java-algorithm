package algorithm.star;

public class pyramidTriangle {
    private char letter = '*';

    public pyramidTriangle() {
    }

    public pyramidTriangle(char letter) {
        this.letter = letter;
    }

    public void pyramid(int num) {
        for(int i=1; i<=num; i++) {
            for(int j=num-i; j>0; j--) {
                System.out.print(" ");
            }
            for(int j=0; j<(2*i)-1; j++) {
                System.out.printf("%c",letter);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        pyramidTriangle pyramidTriangle = new pyramidTriangle();

        pyramidTriangle.pyramid(7);
    }
}
