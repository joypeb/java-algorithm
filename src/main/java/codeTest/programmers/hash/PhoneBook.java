package codeTest.programmers.hash;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    //전화번호 목록

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashSet<String> hs = new HashSet<>();

        for(String s : phone_book) {
            hs.add(s);
        }

        for(String s : hs) {
            for(int i=1; i<s.length(); i++) {
                String compare = s.substring(0,i);
                if(hs.contains(compare)){
                    return false;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        String[] t1 = {"119", "97674223", "1195524421"};
        String[] t2 = {"123","456","789"};


        System.out.println(phoneBook.solution(t2));
    }
}
