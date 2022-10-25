package algorithm.hash;

public class HashFunction2 {
    public int hash(String key) {
        int asciiSum = 0;
        for(int i=0; i<key.length(); i++) {
            asciiSum += key.charAt(i);
        }
        return asciiSum % 90;
    }

    public static void main(String[] args) {
        HashFunction2 hf = new HashFunction2();
        hf.hash("hee");
    }
}
