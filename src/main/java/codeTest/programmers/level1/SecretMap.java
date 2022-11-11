package codeTest.programmers.level1;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        //or연산을 해서 지도를 합친다
        //이진수로 변환
        //1은 #, 0은 공백으로 변환
        String[] answer = new String[arr1.length];
        String[] binary = new String[arr1.length];

        for(int i=0; i< arr1.length; i++) {
            binary[i] = Integer.toBinaryString(arr1[i]|arr2[i]);
            if(binary[i].length() < n) {
                for(int j=binary[i].length(); j<n; j++) {
                    binary[i] = "0" + binary[i];
                }
            }
            answer[i] = binary[i].replaceAll("1","#").replaceAll("0"," ");
        }

        return answer;
    }

    public String binaryMake(int num) {
        String b = "";
        while(num > 0) {
            b = num%2 + b;
            num/=2;
        }

        return b;
    }

    public static void main(String[] args) {
        SecretMap secretMap = new SecretMap();

        String x = secretMap.binaryMake(10);
        System.out.println(x);

    }
}
