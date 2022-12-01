package algorithm.combination;

public class BitPermutation {

    public static void printP(char[] arr, int n) {
        for(int i=0; i<(1<<n); i++) {
            //순열의 총 개수는 배열의 크기만큼 비트 이동을 한 개수와 같다
            for(int j=0; j<n; j++) {
                if((i & (1 << j)) != 0) {
                    System.out.print(arr[j] + ", ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[] arr1 = {'a','b','c','d'};
        //배열의 길이를 넣는다
        printP(arr1, 4);

        //System.out.println(1&(1<<0));
        //0001
        //0001

        //0010
        //0001 -> 비트 한칸 옮김 -> 0010

        //이렇게 각 자리에 대한 비트가 있는지 계산을 해서 출력한다
    }
}
