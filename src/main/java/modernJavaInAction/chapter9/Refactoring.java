package modernJavaInAction.chapter9;

public class Refactoring {
    /*
    * 코드 가독성 : 우리가 구현한 코드를 다른 사람이 쉽게 이해하고 유지보수할 수 있게 만드는 것
    * */

    public static void main(String[] args) {

        //익명 클래스를 람다 표현식으로 리패터링하기

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hi");
            }
        };

        Runnable r2 = () -> System.out.println("hi2");

        //익명클래스를 사용한 것보다 훨씬 가독성이 좋다
        //하지만 모든 익명클래스를 람다 표현식으로 변환할수는 없다.
        //익명클래스에서 this는 익명 클래스 자신을 가리키지만 람다에서 this는 람다를 감싸는 클래스를 가리킨다

        int a = 10;

        Runnable r1a  = () -> {
           //에러 int a = 2;
            System.out.println(a);
        };

        Runnable r2a = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };


        /*
        * 위의 상황을 제외하고 메서드가 2개가 작성되었을때도 어떤 메서드를 가르키는지 모르기때문에 에러가 발생한다
        * */


    }
}
