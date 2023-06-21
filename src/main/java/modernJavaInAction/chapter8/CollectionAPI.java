package modernJavaInAction.chapter8;

import java.util.*;

public class CollectionAPI {
    /*
    * 컬렉션 api가 없었다면 자바 개발에 많은 어려움이 있었을 것이다
    *
    * 컬렉션은 개발에 많은 편리함을 가져왔지만 아직 성가신부분들이 있고 에러를 유발하는 단점이 존재한다
    *
    * 이를위해 컬렉션API의 기능을 배워 더 편리하게 사용해보자
    *
    * */

    /*
    * 컬렉션 팩토리
    *
    * 적은 요소를 포함하는 리스트를 만들기 위해서는 어떻게 해야될까
    *
    * 이전의 코드는 다음과 같다
    * */

    public static void main(String[] args) {

        List<String> friends = new ArrayList<>();

        friends.add("Park");
        friends.add("Kim");
        friends.add("Lee");
        friends.add("hi");

        //위의 리스트를 저장하는데 많은 코드가 필요하다.
        //하지만 Arrays.asList() 팩토리 메서드를 이용하면 코드를 줄일 수 있다

        List<String> friends2 = Arrays.asList("Park","Kim","Lee");

        //하지만 위크 리스트는 고정 크기의 리스트이다. 즉 요소를 갱신할수있지만 요소를 추가하거나 삭제할순 없다.

        //friends2.add("Choi"); //에러발생

        //내부적으로 고정된 크기의 변환할 수 있는 배열로 구현되었기때문에 이런 일이 발생한다.

        List<String> friends3 = List.of("Park","Kim","Lee");

        //List.of() 메서드 또한 크기가 고정되어있다. 이러한 제약은 컬렉션이 의도치 않게 변하는 것을 막을 수 있다.

        Set<String> friendsSet = Set.of("Park","Kim","Lee");

        Map<String, Integer> ageOfFriends = Map.of("Park",23,"Kim",20,"Lee",21);

        //10개 이하의 키와 값 쌍을 가지는 작은 맵을 만들때는 Map.of가 유용하고 큰 맵을 만들때는 Map.Engty객체를 인수로 받으며 가변 인수로 구현된 Map.ofEntries 팩토리 메서드를 이용하는 것이 좋다

        Map<String, Integer> ageOfFriends2 = Map.ofEntries(Map.entry("Park",23), Map.entry("Kim",20), Map.entry("Lee",21));

        //리스트와 집합 처리
        //removeIf : preficate를 만족하는 요소를 제거한다.
        //replaceAll : UnaryOperator함수를 이용해 요소를 바꾼다
        //sort : 리스트를 정렬한다

        friends.removeIf(str -> str.equals("hi"));
        //removeIf를 이용해 list의 값이 hi일경우 제거하도록 만들었다.

        friends.replaceAll(s -> {
            if(s.startsWith("K"))
                return "Choi";
            else return s;
        });
        //replaceAll을 이용해 K로 시작하는 이름이 있을경우 Choi로 변경해서 리턴시켰다

        System.out.println(friends);
    }
}
