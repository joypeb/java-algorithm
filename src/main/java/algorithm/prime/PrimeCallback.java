package algorithm.prime;

public class PrimeCallback {
    boolean someOperation(int a, int b) {
        return a < b;
    }

    boolean isPrime(int num) {
        for(int i=2; someOperation(i, num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeCallback primeCallback = new PrimeCallback();

        System.out.println(primeCallback.isPrime(4));
    }
}
