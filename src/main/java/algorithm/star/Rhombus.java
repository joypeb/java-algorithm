package algorithm.star;

public class Rhombus {
    private char letter = '*';

    public Rhombus() {
    }

    public Rhombus(char letter) {
        this.letter = letter;
    }

    public void rhombus(int num) {
        for(int i=1; i<=num; i++) {
            for(int j=num-i; j>0; j--) {
                System.out.print(" ");
            }
            for(int j=0; j<(2*i)-1; j++) {
                System.out.printf("%c",letter);
            }
            System.out.print("\n");
        }

        for(int i=1; i<=num; i++) {
            for(int k=0; k<i; k++) {
                System.out.printf(" ");
            }
            for(int j=(2*(num-i))-1; j>0; j--) {
                System.out.printf("%c",letter);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Rhombus rhombus = new Rhombus();

        rhombus.rhombus(5);
    }
}
