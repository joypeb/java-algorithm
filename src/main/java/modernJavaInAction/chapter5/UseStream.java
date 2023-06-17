package modernJavaInAction.chapter5;

import modernJavaInAction.chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static modernJavaInAction.chapter4.Stream.menu;

public class UseStream {
    /*
    * 스트림 활용
    *
    * 스트림을 활용하면 데이터를 어떻게 처리할지는 스트림 api가 관리하기때문에 편하게 데이터 관련 작업을 할 수 있다
    *
    * 필터링 : 스트림의 요소를 선택하는 방법
    *
    *
    *
    * */

    public static void main(String[] args) {
        //filter
        //해당 메서드는 Predicate를 인수로 받아서 일치하는 모든 요소를 스트림으로 반환한다.
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian) //filter를 이용해 vegitarian인 경우만 필터링을 하였다
                .collect(Collectors.toList());

        //distinct
        //고유 요소로 이루어진 스트림을 반환 즉 중복되는 값을 제거해준다
        List<Integer> nums = Arrays.asList(1,2,1,2,1,2).stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(nums);

        //스트림 요소를 선택하거나 스킵하는 방법
        //predicate이용 - takeWhile, dropWhile

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Dish.Type.OTHER), new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        //위와 같은 특별한 메뉴가 있고 이 메뉴들중에서 320칼로리 미만의 메뉴만을 선택할때 filter를 사용할 수 있다.
        //하지만 위의 리스트는 이미 오름차순으로 정렬이 되어있다.
        //만약 filter연산을 사용하면 스트림은 처음부터 끝까지 연산을 하기때문에 비효율적일것이다.
        //정렬되어있다는 사실을 알 경우 320칼로리 이상이 될 경우 중단을 하면 끝까지 연산을 하지않고 효율적인 연산이 가능하다.
        //이를 위해 takeWhile연산을 이용한다

        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        //filter는 predicate가 false가 나와도 끝까지 연산을하지만 takeWhile은 predicate가 false가 나올경우 그즉시 연산을 멈춘다

        //만약 나머지 요소를 선택하지 위해서는 dropWhile을 활용한다

        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        //takeWhile과 정반대로 해당 조건이 false가 나올경우 발견된 요소들을 버리고 나머지 요소들을 담는다.

        //만약 처음 n개의 요소를건너뛰고 싶을경우 skip() 메서드를 지원한다.
        List<Dish> skipDishes = menu.stream()
                .skip(2)
                .collect(Collectors.toList());
    }
}
