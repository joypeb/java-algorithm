package codeTest.programmers.level2;

import java.util.*;

public class BracketRotation {
    // 1. 괄호를 쪼개어 큐에 집어넣는다
    // 2. 한바퀴를 for 돌린다
    // 3. 하나씩 검사를 수행하며 카운트를 올린다

    public int solution(String s) {
        int answer = 0;

        List<String> list = new ArrayList<>(Arrays.asList(s.split("")));
        Stack<String> stack  = new Stack<>();

        for(int i=0; i<list.size(); i++) {
            inner:for(int j=0; j<list.size(); j++) {
                String bracket = list.get(j);
                if(bracket.equals("(") || bracket.equals("{") || bracket.equals("[")) {
                    stack.add(bracket);
                } else {
                    if (stack.isEmpty()) {
                        stack.add("(");
                        break inner;
                    }
                    if(bracket.equals(")")) {
                        if(!stack.peek().equals("(")) {
                            break inner;
                        } else {
                            stack.pop();
                        }
                    } else if(bracket.equals("}")) {
                        if(!stack.peek().equals("{")) {
                            break inner;
                        } else {
                            stack.pop();
                        }
                    } else if(bracket.equals("]")) {
                        if(!stack.peek().equals("[")) {
                            break inner;
                        } else {
                            stack.pop();
                        }
                    }
                }
            }

            if(stack.isEmpty()) {
                answer++;
            }
            stack.clear();
            System.out.println(list.toString());
            list.add(list.get(0));
            list.remove(0);
        }

        return answer;
    }

    public static void main(String[] args) {
        BracketRotation bracketRotation = new BracketRotation();

        String s = "}]()[{";

        int result = bracketRotation.solution(s);

        System.out.println(result);
    }
}
