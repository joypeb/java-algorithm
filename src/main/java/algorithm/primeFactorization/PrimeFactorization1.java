package algorithm.primeFactorization;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization1 {

    static List<Integer> primeFacto(int num) {
        List<Integer> list = new ArrayList<>();

        for(int i=2; i<=(int)Math.sqrt(num); i++) {
            while (num % i == 0) {
                list.add(i);
                num/=i;
            }
        }

        if(num != 1) {
            list.add(num);
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> result = primeFacto(72);

        System.out.println(result);
    }
}
