package codeTest.programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ChangeWord {
    /*
    * 공통
    * words에 target문자열이 들어있지않으면 0을 출력하기때문에 stream을 이용해 target이 들었는지 검사한다
    *
    * bfs
    * 1. 탐색을 위한 큐를 생성해준다
    * 2. 큐에 제네릭을 Word라는 클래스로 지정해준다. Word에는 현재 단어, 체크용 배열, 카운트가 포함된다
    * 3. 큐가 empty될때까지 while문을 돌린다
    * 4. 큐에서 Word클래스를 꺼내어서 target과 비교한다 만약 target과 같을경우 CNT와 최솟값을 비교해 변수의 값을 변경한다
    * 5. target과 다를경우 for문을 돌린다.
    * 6. Word에 있는 check가 0인 자리만 문자열을 검사한다. 이때 word.word와 words[i]의 문자열의 겹치지 않는 문자가 1개인경우만 골라낸다 ex) hit / hot은 i와 o 하나의 문자만 겹치지 않기때문에 골라내야한다
    * 7. 골라낸 문자열을 다음 bfs depth이기때문에 큐에 넣어준다. 이때 골라낸 문자열자리를 체크에서 1로 변경해주고 cnt도 1더해주어 클래스를 큐에 넣는다
    * 8. 돌려보면 최소로 도달한 값이 나온다
    *
    * dfs
    * 1. 탈출조건으로 begin과 target이 같을경우 CNT의 최솟값을 비교해 CNT변수의 값을 변경시키고 리턴한다
    * 2. 두번째 탈출조건으로 begin과 target의 값이 같지 않지만 최대 depth에 도달했을경우 return시킨다
    * 3. 모든 배열을 하나하나 최대 depth까지 확인해야되기때문에 for문으로 하나하나 판다
    * 4. check가 0일경우 bfs와 같이 겹치지 않는 문자가 1개인경우만 골라낸다
    * 5. 해당 문자를 begin으로 넘기고 해당 자리의 check를 1로 변경하고 cnt를 하나 추가시킨다음 dfs를 호출해준다
    *
    * dfs 흐름
    *
    * hit -> hot -> hot(체크되었기때문에 건너뜀) -> dot -> hot,dot(건너뜀) -> dog -> hot,dot,dog(건너뜀) -> lot(1개만 겹치지 않기때문에 건너뜀) -> log -> hot,dot,dog(건너뜀) -> lot -> (이제 건너뜀 생략함)
    * -> log (최대 depth도달했기때문에 리턴) -> cog(CNT랑 비교후 리턴) -> 다시 log까지 리턴 -> cog(CNT랑 비교 후 리턴) -> ...
    * */

    static int CNT;

    static void dfs(String begin, String target, int[] check, String[] words,  int cnt) {
        if(begin.equals(target)) {
            System.out.println(cnt<CNT);
            if (cnt < CNT) CNT = cnt;
            return;
        }

        if(cnt >= check.length) return;

        for(int i=0; i<words.length; i++) {
            System.out.println(words[i] + " " + cnt);
            if(check[i] != 1) {
                int wordCnt = 0;
                for(int j=0; j<words[i].length(); j++) {
                    if(begin.charAt(j) != words[i].charAt(j)) wordCnt++;
                }
                if(wordCnt == 1) {
                    System.out.println(words[i] + " " + cnt + "in");
                    check[i] = 1;
                    dfs(words[i], target, check, words, cnt+1);
                }
            }
        }
    }
    void bfs(String begin, String target, String[] words) {
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, new int[words.length],0));

        while (!q.isEmpty()) {
            Word word = q.poll();
            if(word.word.equals(target)) {
                if(word.cnt < CNT) CNT = word.cnt;
            } else {
                for(int i=0; i< words.length; i++) {
                    if(word.check[i] != 1) {
                        int wordLength = 0;
                        for(int j=0; j<words[i].length(); j++) {
                            if(word.word.charAt(j) != words[i].charAt(j)) wordLength++;
                        }

                        if(wordLength == 1) {
                            word.check[i] = 1;
                            q.add(new Word(words[i],word.check,word.cnt+1));
                        }
                    }
                }
            }

        }
    }

    class Word {
        public String word;
        public int[] check;
        public int cnt;

        public Word(String word, int[] check, int cnt) {
            this.word = word;
            this.check = check;
            this.cnt = cnt;
        }

        public Word(String word) {
            this.word = word;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        //단어가 존재하는지 확인
        boolean targetCheck = Arrays.asList(words).contains(target);
        if(!targetCheck) return answer;

        int[] check = new int[words.length];

        CNT = words.length;

        bfs(begin,target,words);
        dfs(begin,target,new int[words.length], words, 0);

        return CNT;
    }

    public static void main(String[] args) {
        ChangeWord changeWord = new ChangeWord();

        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(changeWord.solution("hit","cog",words));
    }
}
