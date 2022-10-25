package algorithm.hash;

public class Hash01 {
    public int hash(String str) {
        int ascii = 0;
        for(int i = 0; i<str.length(); i++) {
            ascii += str.charAt(i);
        }
        return ascii % 1000;
    }
}
