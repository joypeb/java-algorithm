package study.lamda;

import java.util.function.*;

public class FunctionInterface implements FunctionCalculator{

    @Override
    public int calculate(int a, int b) {
        return 0;
    }

    @Override
    public int multi(int a, int b) {
        return a*b*a;
    }

    public static void main(String[] args) {
        //기존 인터페이스
        Calculator calculator = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };

        int result = calculator.calculate(1, 2);
        System.out.println(result);

        //함수형 인터페이스
        FunctionCalculator functionCalculator = (n1, n2) -> n1 + n2;
        int functionResult = functionCalculator.calculate(1, 2);
        System.out.println(functionResult);

        //default, static

        int result2 = functionCalculator.multi(1,2);


        //Function<T,R>
        Function<String, Integer> parsing = (str) -> Integer.parseInt(str);
        Function<Integer, String> intToString = (num) -> Integer.toString(num);

        Function<String, String> chainedFunction = parsing.andThen(intToString);

        System.out.println(chainedFunction.apply("1"));

        //Consumer
        Consumer<String> printer = (s) -> System.out.println(s);

        printer.accept("t");

        Consumer<String> printUpperCase = (str) -> System.out.println(str.toUpperCase());
        Consumer<String> printLowerCase = (str) -> System.out.println(str.toLowerCase());

        Consumer<String> printBoth = printUpperCase.andThen(printLowerCase);

        printBoth.accept("Hello");

        Supplier<Integer> randomNumberSupplier = () -> (int) (Math.random() * 100);
        int randomNumber = randomNumberSupplier.get();
        System.out.println(randomNumber);

        Predicate<Integer> predicate = (n) -> n % 2 == 0;
        Predicate<Integer> bigger = (n) -> n > 2;

        System.out.println(predicate.test(4));
        System.out.println(predicate.and(bigger).test(4));
        System.out.println(predicate.or(bigger).test(2));
        System.out.println(predicate.negate().test(4));

        UnaryOperator<Integer> unaryOperator = (n) -> n+1;

        System.out.println(unaryOperator.apply(1));

        BiFunction<Integer,String,Integer> parsingPlus = (n,s) -> n + Integer.parseInt(s);

        System.out.println(parsingPlus.apply(1,"10"));

        BinaryOperator<Integer> binaryOperator = (n1, n2) -> n1 * n2;

        System.out.println(binaryOperator.apply(2,4));
    }


}

interface Calculator {
    int calculate(int a, int b);
}

@FunctionalInterface
interface FunctionCalculator {
    int calculate(int a, int b);

    default int multi(int a, int b) {
        return a*b;
    }

    static int square(int a) {
        return a*a;
    }
}
