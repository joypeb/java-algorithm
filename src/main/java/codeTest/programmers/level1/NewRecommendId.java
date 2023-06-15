package codeTest.programmers.level1;

public class NewRecommendId {
    public String solution(String new_id) {
        String answer = "";

        //대문자를 소문자로
        new_id = new_id.toLowerCase();

        //소문자, 숫자, 빼기, 및줄, 마침표를 제외한 모든 문자 제거
        /*answer = answer.replace("~","").replace("`","").replace("!","").replace("@","")
            .replace("#","").replace("$","").replace("%","").replace("^","")
            .replace("&","").replace("*","").replace("\\(","").replace(")","")
            .replace("=","").replace("+","").replace("\\[","").replace("\\{","")
            .replace("]","").replace("}","").replace("\\","").replace("|","")
            .replace(";","").replace(":'","").replace("\"","").replace("\'","")
            .replace(",","").replace("<","").replace(">","").replace("/","")
            .replace("?","");*/

        answer = new_id.replaceAll("[^a-z0-9-_.]","");

        for(int i=0; i<new_id.length(); i++) {
            char c = new_id.charAt(i);

            if(Character.isAlphabetic(c) || Character.isDigit(c)
                    || c == '-' || c == '_' || c == '.') {
                answer += c;
            }
        }

        //마침표 변경
        while(true) {
            int idx = answer.indexOf("..");

            if(idx != -1) {
                answer = answer.replace("..",".");
            } else {
                break;
            }
        }

        //처음이나 끝에 마침표가 있을경우 제거
        if(answer.length() >= 1 && answer.charAt(0) == '.') answer = answer.substring(1);
        int lastNum = answer.length()-1;
        if(answer.length() >= 1 && answer.charAt(lastNum) == '.') answer = answer.substring(0,lastNum);

        //빈 문자열일경우 a추가
        if(answer.length() == 0) {
            answer = "a" + answer;
        }

        //16자 이상이면 15자까지 자르기
        if(answer.length() >= 16) answer = answer.substring(0,15);

        //마지막에 점 제거
        while(true) {
            int lastNum2 = answer.length()-1;
            if(answer.length() >= 1 && answer.charAt(lastNum2) == '.') answer = answer.substring(0,lastNum2);
            else break;
        }

        //길이가 3보다 작은경우 3이 될때까지 마지막 문자를 넣음
        if(answer.length() < 3) {
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length()-1);
            }
        }

        return answer;
    }

    public String lastNum(String str) {
        int last = str.length()-1;
        if(str.length() >= 1 && str.charAt(last) == '.') str = str.substring(0,last);
        return str;
    }
}
