package modernJavaInAction.chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStream {
    /*
    * 이전에는 컬렉션을 병렬로 처리하기 까다로워졌지만
    * 스트림이 등장하면서 병령로 처리하는게 쉬워졌다
    *
    * 기본적으로 parallelStream을 호출하면 병렬 스트림이 생성된다
    * 각각의 스레드에서 처리할 수 있도록 스트림 요소를 여러 청크로 분할한 스트림이다
    * 따라서 병렬 스트림을 이용하면 모든 멀티코어 프로세서가 각각의 청크를 처리하도록 할당할 수 있다
    * */
    public static void main(String[] args) {
        ParallelStream parallelStream = new ParallelStream();

        long num = 10000L;
        //System.out.println("sequentialSum " + sequentialSum(num));
        //System.out.println("iterativeSum " + iterativeSum(num));
        //System.out.println("parallelSum " + parallelSum(num));

        //벤치마크를 돌려보지는 않았지만 직접 실행해보니 속도차이가 꽤 느껴진다
        //System.out.println("rangedSum " + rangedSum(num));
        //System.out.println("parallelRangedSum " + parallelRangedSum(num));

        for(int i=0; i<5; i++) {
            System.out.println(parallelStream.sideEffectParallelSum(num));
        }
    }

    //숫자 n을 인수로 받아서 1부터 n까지 모든 숫자의 합계를 반환하는 메서드
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    //전통적인 자바 코드에서는 이렇게 작성이 가능하다
    public static long iterativeSum(long n) {
        long result = 0;
        for(long i = 1L; i<=n; i++) {
            result += i;
        }
        return result;
    }

    /*
    * 만약 n이 커진다면 이 연산을 병렬로 처리하는 것이 좋을거다.
    * 이를위해 parallel을 사용하면 손쉽게 변환이 가능하다
    * */

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i+1)
                .limit(n)
                .parallel() //스트림을 병렬로 변환
                .reduce(0L, Long::sum);
    }


    /*
    * parallel을 이용하면 병렬로 연산이 된다는것은 알았다
    * 하지만 이 연산이 정말로 빠른지 테스트해보고싶다.
    * 그래서 Java Microbenchmark Harness라는 라이브러리를 이용해 작은 벤치마크를 구현한다
    * 근데 구현하기 너무 귀찮고 여기서는 하기 힘들어서 건너뜁니다
    *
    * 결과는 병렬 스트림이 훨씬 느리게 나왔다 약(5배 차이..)
    * 왜 이럴까?
    *
    * 첫번째 : 반복 결과로 박신된 객체가 만들어지므로 숫자를 더하려면 언박싱을 해야한다
    * 두번째 : 반복 작업은 병렬로 수행할 수 있는 독립 단위로 나누기가 어렵다
    *
    * iterate는 본질적으로 순차적으로 동작하는 스트림이다
    * 하나의 입력이 들어가고 출력이 나온다음 그 다음 입력이 들어가는 형식인데
    * 이런 형식때문에 청크로 분해하지 못하였다. 하지만 병렬로 처리되도록 지시했고 각각의 합계가 다른 스레드에서 수행되었지만
    * 순차처리방식과 다를게 없기때문에 스레드를 할당하는 오버헤드만 증가하게 되었다.
    *
    * 이때문에 parallel메서드를 호출했을때 내부적으로 어떤 일이 일어나는지 꼭 이해해야 한다.
    *
    * 이제 더 특화된 메서드를 사용해보자
    * rangeClosed라는 메서드는 기본형이 long이므로 박싱과 언박싱 오버헤드가 사라진다
    * 또한 rangeClosed메서드는 청크로 분할할 수 있는 숫자 범위를 생산한다 (1-5, 6-10, 11-15 ...)
    *
    * * */

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    /*
    * 위의 메서드는 iterate메서드로 생성한 병렬 스트림보다 처리속도가 훨씬 빨랐다.
    * 특화되지 않은 스트림을 처리할때 오토박식, 언박싱등의 오버헤드는 속도에 영향을 끼친다
    * 상황에 따라서는 어떤 알고리즘을 무조건적으로 병렬화하는것보다 적절한 자료구조를 선택하는게 성능에 좋은 영향을 끼치는 것을 보여준다
    *
    * 이제 이 스트림을 병렬로 처리하면 어떻게 될까?
    * */

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    /*
    * 병렬 스트림을 사용하면 순차 실행보다 더 빠르게 메서드를 실행 할 수 있다
    * 하지만 병렬화가 완전 공짜는 아니다
    * 병렬화를 이용하려면 스트림을 재귀적으로 분할하고 각 서브스트림을 서로 다른 스레드의 리듀싱 연산으로 할당하고
    * 이들 결과를 하나의 값으로 합쳐야 한다. 멀티코어 간의 데이터 이동은 우리 생각보다 비싸다
    * 따라서 코어간에 데이터 전송시간보다 훨씬 오래 걸리는 작업만 병렬로 다른 코어에서 수행하는 것이 바람직하다
    * */

    /*
    * 병렬 스트림을 잘못 사용하면서 발생하는 많은 문제는 공유된 상태를 바꾸는 알고리즘을 사용하기떄문이다
    * */

    public long sideEffectSum(long n) {
        Accumlator accumlator = new Accumlator();
        LongStream.rangeClosed(1, n).forEach(accumlator::add);
        return accumlator.total;
    }

    public class Accumlator {
        public long total = 0;
        public void add(long value) {
            total += value;
        }
    }

    /*
    * 위의 코드를 병렬로 실행한다면?
    * 위 코드는 본질적으로 순차 실행할 수 있도록 구현되어있으므로 병렬로 실행하면 참사가 일어난다.
    * 특히 total을 접근할 때마다(다수의 스레드에서 동시 접근) 데이터 레이스 문제가 일어난다.
    * 이러한 동기화로 문제를 해결하다보면 결국 병렬화의 특성은 사라지게 될 것이다
    * */

    public long sideEffectParallelSum(long n) {
        Accumlator accumlator = new Accumlator();

        LongStream.rangeClosed(1, n).parallel().forEach(accumlator::add);
        return accumlator.total;
    }

    /*
    * 위의 메서드를 5번 실행해보았다
    *
    *   35518778
    *   42871365
    *   28489076
    *   35463971
    *   27931459
    * 생각했던 값과 전혀 다른 값들이 출몰하고있다.
    * 이유는 여러 스레드에서 동시에 누적자 total+=value를 실행하면서 이런 문제가 발생한다.
    * 아토믹 연산같지만 total += value는 아토믹 연산이 아니다.
    *
    * 이를통해 공유된 가변 상태를 피해야 한다는 사실을 확인했다.
    * 이제 효과적으로 사용하는 방법을 알아보자
    *
    *
    * */


    /*
    * 병렬 연산을 사용해야되는 기준
    *
    * 1. 직접 측정하라
    *   순차 스트림을 무조건 병렬 스트림으로 바꾸는 것은 옳지않다. 언제나 병렬 스트림이 순차 스트림보다 빠른것이 아니기 때문이다
    *   그렇기때문에 확신이 서지 않는다면 벤치마크를 통해 직접 성능을 측정해라
    * 2. 박싱을 주의해라
    *   박싱과 언박싱은 하나만 놓고보면 그렇게 리소스가 들어가는 연산이 아니지만 이 연산이 몇천, 몇만개가 반복되면 이는 성능에 영향을 미칠것이다.
    *   그렇기때문에 오토박싱이 없는 되도록이면 기본형 특화 스트림을 사용하는 것이 좋다
    * 3. 요소에 순서의 의존하는 스트림일경우 순차 스트림을 이용해라
    *   limit, findFirst와 같이 순서에 의존하는 스트림일 경우 병렬 연산을 하게되면 순차 연산보다 비싼 비용을 치러야한다.
    * 4. 스트림에서 수행하는 전체 파이프라인 연산 비용을 고려하라.
    *   처리해야 할 요소가 N이로 하나의 요소를 처리하는데 드는 비용이 Q라고하면 총 비용은 N*Q라고 예상을 할 수 있다.
    *   Q가 높아진다는것은 병렬 스트림으로 성능을 개선할 수 있음을 나타낸다
    * 5. 소량의 데이터에서는 순차 스트림을 사용해라
    *   오히려 멀티코어간의 데이터 이동이 더 비싸다
    * 6. 스트림을 구성하는 자료구조가 적절한지 확인하라.
    *   예를들어 ArrayList가 LinkedList보다 분할하기 더 쉽다. LinkedList는 모든 요소를 탐색해야 하지만 ArrayList는 필요가 없다
    * 7. 스트림의 특성과 파이프라인 중간 연산이 스트림의 특성을 어떻게 바꾸는지 확인해라
    *   예를들어 SIZED 스트림은 정확히 같은 크기의 두 스트림으로 분할할 수 있으므로 효과적으로 병렬 처리를 할 수 없다.
    *   반면 필터 연산이 있으면 스트림의 길이를 예측할 수없으므로 효과적으로 스트림을 병렬처리할 수 없다
    * 8. 최종 연산의 병합 과정 비용을 살펴라
    *   병합 과정의 비용이 비싸다면 병렬로 나눠서 얻은 스트림의 성능을 합치는데 다 소요해버릴수있다
    * */

    /*
    * 스트림 소스의 병렬화 친밀도
    * ArrayList : 아주 좋음
    * LinkedList : 나쁨
    * IntStream.range : 아주 좋음
    * Stream.iterate : 나쁨
    * HashSet : 좋음
    * TreeSet : 좋음
    * */

    /*
    * 9. 병렬 스트림이 수행되는 내부 인프라 구조도 살펴봐야된다.
    *
    * */


    /*
    * 포크/조인 프레임워크
    *
    * 포크/조인 프레임워크는 병렬화할 수 있는 작업을 재귀적으로 작은 작업으로 분할한 다음에 서브태스크 각각의 결과를 합쳐서 전체 결과를 만들도록 설계되었다
    *
    * 각각의 서브태스크의 크기가 충분히 작아질 때까지 태스크를 포함한 재귀적으로 포크함(나누다)
    * 모든 서브태스크를 병렬로 수행
    * 부분 결과를 조합
    *
    * 어디서 많이 본거같은데 이거 divide and conquer (분할정복알고리즘)을 병렬로 처리한 것이다
    *
    *
    * */

    public class ForkJoinSumCalculator extends RecursiveTask<Long> {
        private final long[] numbers;
        private final int start;
        private final int end;
        public static final long THRESHOLD = 10_000;

        public ForkJoinSumCalculator(long[] numbers) {
            this(numbers,0,numbers.length);
        }

        //메인 태스크의 서브태스크를 재귀적으로 만들 때 사용할 비공개 생성자
        private ForkJoinSumCalculator(long[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            int length = end - start; //이 태스크를 더할 배열의 길이
            if(length <= THRESHOLD) {
                return computeSequentially(); //기준값과 같거나 작으면 순차적으로 결과를 계산한다
            }

            //배열의 첫번째 절반을 더하도록 서브태스크 생성
            ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers,start,start+length/2);

            //ForkJoinPool의 다른 스레드로 새로 생성한 태스크를 비동기로 실행한다
            leftTask.fork();

            //배열의 나머지 절반을 더하도록 서브태스크를 생성
            ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers,start+length/2,end);

            //두번째 서브태스크를 동기 실행한다 이떄 추가 분열이 일어날 수 있다
            Long rightResult = rightTask.compute();

            //첫번째 서브태스크의 결과를 읽는다. 결과가 없으면 기다린다
            Long leftResult = leftTask.join();

            //두 서브태스크를 더한 결과
            return leftResult + rightResult;
        }

        private long computeSequentially() {
            long sum = 0;
            for(int i=start; i<end; i++) {
                sum+=numbers[i];
            }
            return sum;
        }
    }

    /*
    * 위 클래스의 메서드는 n까지의 자연수 덧셈 작업을 병렬로 수행하는 방법을 직관적으로 보여준다.
    * 다음코드처럼 ForkJoinSumCalculator의 생성자로 원하는 수의 배열을 넘겨줄 수 있다
    * */
    public long forkJoinSum(long n) {
        long[] numbers = LongStream.range(1,n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }


    class WordCounter {
        private final int counter;
        private final boolean lastSpace;

        public WordCounter(int counter, boolean lastSpace) {
            this.counter = counter;
            this.lastSpace = lastSpace;
        }

        public WordCounter accumulate(Character c) {
            if(Character.isWhitespace(c)) {
                return lastSpace ? this : new WordCounter(counter, true);
            }

            return lastSpace ? new WordCounter(counter+1, false) : this;
        }

        public WordCounter combine(WordCounter wordCounter) {
            return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
        }

        public int getCounter() {
            return counter;
        }
    }

    public int wordCount(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        return wordCounter.counter;
    }
}
