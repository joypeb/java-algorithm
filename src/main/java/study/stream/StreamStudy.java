package study.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStudy {

    public static void main(String[] args) {
        //stream의 흐름
        /*
        * 컬렌션 생성 -> stream 생성 -> 중간연산 -> 최종연산 -> 결과
        * */

        //stream 생성
        List<Integer> list = Arrays.asList(1,1,2,3,4,5);
        Stream<Integer> intStream = list.stream();

        String[] arr = {"a","b","c"};
        Stream<String> strStream = Stream.of(arr);

        Stream<Integer> evenStream = Stream.iterate(0, n->n+2); //0,2,4,6...

        Stream<Double> randomStream = Stream.generate(Math::random);

        IntStream intStream2 = IntStream.of(7,1,2,6,33,2,2,2,1,7,8,9,10,22);

        //중간 연산

        intStream
                .parallel()
                .filter(n -> n<4)
                .map(n -> n+1)
                .distinct()
                .forEach(System.out::println);

        String[][] arrs = {{"apple", "banana"}, {"kim", "park"}};

        Stream<String[]> arrStream = Stream.of(arrs);

        List<String> streamByArr = arrStream
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        System.out.println(streamByArr);

        List<Integer> list2 = evenStream.limit(5).collect(Collectors.toList());

        System.out.println(list2);

        //최종 연산

        int intResult = Arrays.asList(1,1,2,3,4,5).stream().reduce((a, b) -> a+b).get();
        int intResult2 = Arrays.asList(1,1,2,3,4,5).stream().reduce(1, (a, b) -> a+b);

        System.out.println(intResult + ", " + intResult2);


        List<String> strList = Arrays.asList("apple","banana","watermelon");

        String strMin = strList.stream().min(Comparator.comparing(String::length)).get();

        int min = list.stream().mapToInt(n -> n).min().getAsInt();
        long count = list.stream().count();

        System.out.println(strMin);


        System.out.println(IntStream.of(new int[]{1,2,3,4,5}).sum());
        System.out.println(IntStream.of(new int[]{1,2,3,4,5}).average().getAsDouble());


        System.out.println(IntStream.of(new int[]{1,2,3,4,5}).count());
        System.out.println(strList.stream().count());

        String[] fruits = {"banana", "apple", "mango", "kiwi", "peach", "cherry", "lemon"};

        Set<String> set = Stream.of(fruits).collect(Collectors.toSet());

        List<String> lists = Stream.of(fruits).collect(Collectors.toList());

        HashSet<String> hashSet = Stream.of(fruits).collect(Collectors.toCollection(HashSet::new));

        String join = Stream.of(fruits).collect(Collectors.joining());
        String join2 = Stream.of(fruits).collect(Collectors.joining(", "));

        System.out.println(set.toString());
        System.out.println(lists);
        System.out.println(hashSet.toString());
        System.out.println(join);
        System.out.println(join2);

        int[] find = {5,4,3,2,1};

        OptionalInt findFirst = IntStream.of(find).findFirst();
        OptionalInt findAny = IntStream.of(find).parallel().findAny();

        System.out.println(findFirst.getAsInt());
        System.out.println(findAny.getAsInt());

        System.out.println(IntStream.of(find).anyMatch(n -> n==5));
        System.out.println(IntStream.of(find).allMatch(n -> n>=0));
        System.out.println(IntStream.of(find).noneMatch(n -> n==0));
    }
}
