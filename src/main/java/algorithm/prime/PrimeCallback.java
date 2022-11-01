package algorithm.prime;

public class PrimeCallback {

    boolean isPrime(int num, Operation operation) {
        for(int i=2; operation.someOperation(i,num); i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeCallback primeCallback = new PrimeCallback();
        Operation operation1 = new NOperation();
        Operation operation2 = new N2Operation();
        Operation operationSqrt = new SqrtOperation();

        System.out.println(primeCallback.isPrime(4, operationSqrt));

        //lamda적용
        System.out.println(primeCallback.isPrime(4, (a,b) -> a<b));
        System.out.println(primeCallback.isPrime(6, (a,b) -> a<=b/2));
        System.out.println(primeCallback.isPrime(8, (a,b) -> a*a<=b));
    }
}

interface Operation {
    boolean someOperation(int a, int b);
}

class NOperation implements Operation{

    @Override
    public boolean someOperation(int a, int b) {
        return a<b;
    }
}

class N2Operation implements Operation {

    @Override
    public boolean someOperation(int a, int b) {
        return a<=(b/2);
    }
}

class SqrtOperation implements Operation {

    @Override
    public boolean someOperation(int a, int b) {
        return a<=Math.sqrt(b);
    }
}
