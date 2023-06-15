package modernJavaInAction.chapter2;

import java.util.ArrayList;
import java.util.List;

public class BehaviorParameterization {
    //동작 파라미터화

    /*
    * 소비자의 요구사항은 계속 바뀐다.
    * 계속 바뀌는 요구사항에 맞춰서 효과적으로 대응하기위해서는 동작 파라미터화를 이용해야한다.
    * 동작 파라미터화란 아직은 어떻게 실행할 것인지 결정하지 않는 코드 블록을 의미한다.
    * 이 동작 파라미터화를 이용하여 나중에 실행될 메서드의 인수로 코드 블록을 전달해 변화에 유연하게 대처하도록 코드를 짤수있다
    * 그리고 이러한 방법은 java8 람다에서 해결할 수 있다.
    *
    * */

    static Color color;

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();

        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN /*RED*/);



    }

    //기본적인 색이 그린으로 같은지 확인하는 메서드
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory) {
            if(color.GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }


    //유연하게 변경 -> 색을 인수로 받아서 레드,그린을 유연하게 받을 수 있게 되었다
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory) {
            if(apple.getColor().equals(color)) {
                result.add(apple);
            }
        }

        return result;
    }


    //색이아닌 무게로 구별이 가능한 메서드를 작성
    //하지만 이러한 방법은 위의 filterApplesByColor와 코드가 겹치는 부분이 너무 많다
    //DRY (Don't repeat yourself)를 어겼다
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory) {
            if(apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }



}
