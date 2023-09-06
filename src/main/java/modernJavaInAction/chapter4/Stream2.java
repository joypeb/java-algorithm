package modernJavaInAction.chapter4;

import java.util.*;
import java.util.stream.Collectors;

import static modernJavaInAction.chapter4.Stream.menu;

public class Stream2 {

    public static void main(String[] args) {

        //기존 자바 7의 코드
        List<Dish> lowCaloricDishes = new ArrayList<>();

        for(Dish dish : menu) {
            if(dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();

        for(Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }

        /*
        * 위의 코드에서는 lowCaloricDishes라는 가비지 변수를 사용하여 로직을 처리했다
        * 이러한 로직은 코드의 가독성이나 유지보수가 힘들었다
        * */

        //자바 8 코드
        List<String> lowCaloricDishesNameStream = menu.parallelStream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());

        /*
         * 자바 8부터 쓰이는 스트림은 선언형으로 코드를 구현 할 수 있다
         * 즉 루프와 if 조건문 등을 기정할 필요없이 동작만 수행하여 값을 구할 수 있다
         * 또한 stream을 이용하면 멀티 스레드를 자유롭게 사용할 수 있다
         */

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));


        // 스트림의 특징
        /*
        * 선언형 : 간결하고 가독성이 좋아진다
        * 조립할 수 있음 : 유연성이 좋아진다
        * 병렬화 : 성능이 좋아진다
        * */


        /*
        * 스트림이란?
        * - 데이터 처리 연산을 지원하도록 소스에서 추출된 연속된 요소
        *
        * 연속된 요소 : 특정 요소 형식으로 이루어진 연속된 값 집합의 인터페이스를 제공한다
        * 소스 : 스트림은 컬렉션 배열 IO자원등의 데이터 제공 소스로부터 데이터를 소비한다
        * 데이터 처리 연산 : 스트림은 함수형 프로그래밍 언어에서 일반적으로 지원하는 연산과 비슷한 연산을 지원한다
        *
        * 파이프라이닝 : 스트림의 연산은 스트림 연산끼리 연결해서 커다란 파이프라인을 구성할 수 있도록 스트림 자신을 반환한다. 덕분에 게으름, 쇼트서킷같은 최적화도 얻을 수 있다
        * 내부 반복 : 반복자를 이용해서 명시적으로 반복하는 컬렉션과 달리 스트림은 내부 반복을 지원한다
        *
        * 코드를 살펴보자
        *
        * List<String> lowCaloricDishesNameStream = menu.parallelStream()   메뉴(리스트)에서 스트림을 얻는다
                .filter(d -> d.getCalories() < 400)                         파이프라인 연산 만들기, 첫번째로 칼로리를 필터링한다
                .map(Dish::getName)                                         두번째 Dish에서 menu String으로 변환
                .limit(3)                                                   세번째 3개까지만 제한을 걸었다
                .sorted(Comparator.comparing(Dish::getName))                마지막으로 정렬을 하고
                .collect(Collectors.toList());                              최종연산으로 list로 만들어주었다
        * */


        /*
        * 스트림 연산
        *
        * 중간 연산
        * 파이프라인으로 서로 연결이 가능한 연산을 중간연산이라고 한다
        *
        * 최종연산
        * 스트림 파이프라인에서 결과를 도출한다. 보통 최종 연산에 의해 List, Integer, void등 스트림 이외의 결과가 반환된다
        *
        *
        * */
    }
}
