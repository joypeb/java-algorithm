package modernJavaInAction.chapter4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static modernJavaInAction.chapter4.Stream.menu;

public class StreamStart {
    /*
    * 스트림이란 뭘까 : 데이터 처리 연산을 지원하도록 소스에서 추출된 연속된 요소
    *
    * 연속된 요소 : 컬렉션과 마찬가지로 스트림도 특정 요소 형식으로 이루어진 연속된 값 집합의 인터페이스를 제공한다.
    *            컬렉션은 자료구조이므로 시간과 공간의 복잡성과 관련된 요소 저장 및 접근 연산이 주를 이룬다면
    *            스트림은 filter, sorted, map처럼 표현 계산식이 주를 이룬다.
    *            즉 컬렉션의 주제는 데이터고 스트림의 주제는 계산이다.
    *
    * 소스 : 스트림은 컬렉션, 배열, I/O 자원등의 데이터 제공 소스로부터 데이터를 소비한다.
    *       정렬된 컬렉션으로 스트림을 생성하면 정렬이 그대로 유지된다
    *
    * 데이터 처리 연산 : 스트림은 함수형 프로그래밍 언어에서 일반적으로 지원하는 연산과 데이터베이스와 비슷한 연산을 지원한다.
    *                스트림연산은 순차적으로 또는 병렬적으로 실행할 수 있다
    *
    * 파이프 라이닝 : 대부분의 스트림 연산은 스트림 연산끼리 연결해서 커다란 파이프 라인을 구성할 수 있도록 스트림 자신을 반환한다.
    *              그 덕분에 게으름, 쇼트서킷과 같은 최적화도 얻을 수 있다.
    *
    * 내부 반복 : 반복자를 이용해서 명시적으로 반복하는 컬렉션과 달리 스트림은 내부 반복을 지원한다
    *
    * */

    public static void main(String[] args) {
        List<String> lowCaloricDishesNameStream =
                menu.stream() //메뉴에서 스트림을 얻는다
                        .filter(dish -> dish.getCalories() > 300) //파이프라인 연산 만들기. 첫번째로 칼로리를 필터링한다
                        .map(Dish::getName) //요리명을 추출한다
                        .limit(3) //3개까지만 선택한다
                        .collect(Collectors.toList()); //결과를 다른 리스트로 저장

        System.out.println(lowCaloricDishesNameStream);

        /*
        * 외부반복과 내부반복
        *
        * 컬렉션과 스트림의 차이라고한다면 외부반복과 내부반복의 차이라고 할 수 있다
        *
        * 예를들어보면 컬렉션은 DVD이다.
        * DVD는 우리가 사고나면 그 DVD안에 모든 자료가 저장되어있다.
        *
        * 하지만 스트림은 인터넷 스트리밍이다
        * 유튜브나 방송을 본다면 DVD처럼 모든 자료를 한번에 가져올 수 없다.
        * 그렇기때문에 우리가 보는 그 부분과 몇 프레임을 미리 다운받는다.
        * 그렇게되면 스트림의 다른 대부분의 값을 처리하지 않은 상태에서도 미리 내려받은 프레임부터 재생할 수 있다.
        *
        * 결국 데이터를 언제 계산하느냐가 컬렉션과 스트림의 가장 큰 차이다
        *
        * 컬렉션은 모든 값을 메모리에 저장한 다음 그 값을 순회하며 계산을 하지만
        * 스트림은 요청할때만 계산을 하게된다
        *
        * 그렇기때문에 컬렉션은 for문과같이 외부에서 반복을 해야되지만
        * 스트림은 요청이 오면 내부에서 계산을 하여 결과를 내보내기때문에 내부 반복이다
        *
        *
        * */

        /*
        * 스트림의 연산
        *
        * 스트림에서는 많은 연산을 정의한다.
        *
        * 위의 코드에서 filter, map, limit은 서로 연결되어 파이프라인을 형성하고
        * collect는 파이프라인을 실행한다음 닫는다.
        *
        * 이렇게 서로 연결이 가능한 연산을 중간연산이라고 하며
        * 스트림을 닫는 연산을 최종연산이라고 한다.
        *
        * filter나 sorted와 같은 중간 연산은 다른 스트림을 반환한다.
        * 따라서 여러 중간연산을 연결해서 질의를 만들 수 있다.
        *
        * 중간연산의 중요한 특징은 단말 연산을 스트림 파이프라인에 실행하기 전까지는 아무 연산도 수행하지 않는하는것 즉 Lazy하게 동작한다.
        * 중간연산을 합친다음에 합쳐진 중간연산을 최종 연산으로 한번에 처리하기 때문이다
        * */

        List<String> names =
                menu.stream()
                        .filter(dish -> {
                            System.out.println("filtering " + dish.getName());
                            return dish.getCalories() > 300;
                        })
                        .map(dish -> {
                            System.out.println("mapping " + dish.getName());
                            return dish.getName();
                        })
                        .limit(3)
                        .collect(Collectors.toList());

        //아까의 코드와 똑같지만 sout을 이용해 내부 연산을 확인해본다. 이러한 sout사용은 테스트에서만 사용하고 실제 코드에서는 지양하자

        /*
        *   filtering pork
            mapping pork
            filtering beef
            mapping beef
            filtering chicken
            mapping chicken

            결과는 위와같다
            스트림의 lazy특성덕분에 filtering이 끝나고 mapping이 되는것이 아닌 두 연산이 병합되어 계산되었다
        * */
    }
}
