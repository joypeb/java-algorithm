package modernJavaInAction.chapter3;

import modernJavaInAction.chapter2.Apple;
import modernJavaInAction.chapter2.ApplePredicate;
import modernJavaInAction.chapter2.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Lamda {
    /*
    * 챕터 2에서 동작 파라미터화를 이용해 변화하는 요구사항에 효과적으로 대응하는 코드를 구현했다.
    * 하지만 이 코드는 만족할만큼깔끔하지 않다.
    * 이 코드를 깔끔하게 구현하기위해 java8의 람다 표현식을 이용한다.
    *
    * 람다란?
    *
    * 람다 표현식은 메서드로 전달할 수 있는 익명 함수를 단순화한 것이라고 할 수 있다.
    *
    * 익명 : 보통의 메서드와 달리 이름이 없으므로 익명이라 표현
    * 함수 : 람다는 메서드처럼 특정 클래스에 종속되지 않으므로 함수라고 부른다. 하지만 메서드처럼 파라미터 리스트, 바디, 반환형식 가능한 예외리스트를 포함한다.
    * 전달 : 람다 표현식을 메서드 인수로 전달하거나 변수로 저장할 수 있다.
    * 간결성 : 익명 클래스처럼 많은 자질구레한 코드를 구현할 필요가 없다
    * */

    public static void main(String[] args) {

        //Comparator 객체를 이용한 두 값 비교
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight()-o2.getWeight();
            }
        };

        //람다를 이용한 Comparator 객체 비교
        Comparator<Apple> byWeightLamda = (Apple o1, Apple o2) -> o1.getWeight()-o2.getWeight();


        List<Apple> inventory = new ArrayList<>();

        //사과를 구별하는데 람다 사용
        List<Apple> greenApples = filter(inventory, (Apple a) -> Color.GREEN.equals(a.getColor()));
    }

    //인터페이스를 통해 구현하고 람다를 이용해 코드 블럭을 넘기면 코드가 훨씬 깔끔하고 유연해진다
    public static List<Apple> filter(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory) {
            if(predicate.select(apple))
                result.add(apple);
        }

        return result;
    }
}
