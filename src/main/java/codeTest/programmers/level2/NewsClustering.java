package codeTest.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class NewsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;

        String str11 = str1.toLowerCase();
        String str22 = str2.toLowerCase();

        ArrayList<String> str1List = getList(str11);
        ArrayList<String> str2List = getList(str22);

        System.out.println(str1List.toString());
        System.out.println(str2List.toString());

        //교집합
        ArrayList<String> retainList2 = (ArrayList<String>)str2List.clone();
        ArrayList<String> retainList = new ArrayList<>();
        for(String x : str1List) {
            if(retainList2.contains(x)) {
                retainList.add(x);
                retainList2.remove(x);
            }
        }
        retainList.retainAll(str2List);
        int retainSize = retainList.size();


        //합집합
        int allSize = str1List.size() + str2List.size() - retainSize;

        if(retainSize == 0 && allSize == 0) return 65536;
        else {
            double j = retainSize/(double)allSize;
            answer = (int) (65536 * j);
        }

        return answer;
    }

    ArrayList<String> getList(String str) {
        ArrayList<String> strList = new ArrayList<>();
        int lt = 0, rt = 1;

        while(true) {
            if(rt == str.length()) break;

            char ltStr1 = str.charAt(lt);
            char rtStr1 = str.charAt(rt);

            if(97 <= ltStr1 && ltStr1 <= 122 && 97 <= rtStr1 && rtStr1 <= 122)
                strList.add(ltStr1+""+rtStr1);

            lt++;
            rt++;
        }

        return strList;
    }

    public static void main(String[] args) {
        NewsClustering newsClustering = new NewsClustering();

        System.out.println(newsClustering.solution("abab","baba"));
    }
}
