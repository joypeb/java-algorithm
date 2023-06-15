package modernJavaInAction.chapter2;

public interface ApplePredicate {
    //유연하게 대처하기위해 전체적인 흐름을 살펴보자

    /*
    * 사과의 어떤 속성(무게, 색깔)을 선택하는것은 boolean 형식으로 나타낼 수 있다.
    * 그리고 이러한 메서드는 모두 동일하게 boolean을 리턴하기때문에 인터페이스를 정의해서 여러 버전의 ApplePredicate를 정의할 수 있다.
    *
    * */
    boolean select (Apple apple);
}
