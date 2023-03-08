package pccp;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class test {

    public static void main(String[] args) {
        Function<Integer,String > o = x -> {
            return x % 2 ==0 ? "even" : "odd";
        };

        System.out.println(o.apply(1));
        Map<String,Integer> m = new HashMap<>();

        m.put("c",1);
        m.put("c",2);

        System.out.println(m.size());

        Function<Integer, Integer> s = x -> x * x;

        System.out.println(s.apply(3));
    }
}
