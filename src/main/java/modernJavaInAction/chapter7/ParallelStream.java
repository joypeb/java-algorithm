package modernJavaInAction.chapter7;

import java.util.stream.Stream;

public class ParallelStream {
    /*
    * 이전에는 컬렉션을 병렬로 처리하기 까다로워졌지만
    * 스트림이 등장하면서 병령로 처리하는게 쉬워졌다
    * */
    public static void main(String[] args) {

    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .parallel() //스트림을 병렬로 변환
                .reduce(0L, Long::sum);
    }
}
