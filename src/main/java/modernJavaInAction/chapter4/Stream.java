package modernJavaInAction.chapter4;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    /*
    * stream : java8 api에 새로 추가된 기능이다.
    *
    * 스트림을 이용하면 선언형(즉 데이터를 처리하는 임시 구현 코드 대신 질의로 표현할 수 있다)으로 컬렉션 데이터를 처리할 수 있다.
    * 또한 스트림을 이용하면 멀티스레드 코드를 구현하지 않아도 데이터를 투명하게 병렬로 처리할 수 있다.
    *
    * */

    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args) {

        //칼로리가 400미만인 요리를 구할때
        //자바7까지의 코드
        List<Dish> lowCaloricDishes = new ArrayList<>();

        for(Dish dish : menu) {
            if(dish.getCalories() < 400)
                lowCaloricDishes.add(dish);
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish dish1, Dish dish2) {
                return dish1.getCalories() - dish2.getCalories();
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();

        for(Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }

        //위의 코드는 일단 길다. 그리고 여러 단계를 거치기때문에 코드를 읽기도 불편하다.

        //이제 자바8부터 사용하는 스트림을 이용한 코드다
        List<String> lowCaloricDishesNameStream =
                menu.stream()
                        .filter(dish -> dish.getCalories() < 400)
                        .sorted(Comparator.comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(Collectors.toList());

        //위의 코드를 멀티코어 아키텍처에서 병렬로 실행하고 싶을경우 parallel을 추가하면 된다
        List<String> lowCaloricDishesNameStreamParallel =
                menu.parallelStream()
                        .filter(dish -> dish.getCalories() < 400)
                        .sorted(Comparator.comparing(Dish::getCalories))
                        .map(Dish::getName)
                        .collect(Collectors.toList());

        //스트림을 쓸 경우 코드를 선언형으로 구현할 수 있다.
        //즉, loop, if 조건문 등의 제어 블록을 사용해서 어떻게 동작을 구현할지 지정할 필요 없이
        //'저 칼로리 요리만 선택해라'와 같은 동작의 수행을 지정할 수 있다.
        //3장의 선언형 코드와 동작 파라미터화를 활용하면 변하는 요구사항에 쉽게 대응할 수 있다.

        /*
        * stream이 흐름을 의미하는 것 처럼 위의 코드들은 filter, sorted, map, collect와 같은 연산을 연결해서
        * 하나의 흐름으로 이어지게 만들었다.
        * 이러한 코드는 가독성이 좋아지고 명확성이 유지된다
        * */
    }
}
