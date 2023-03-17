package codeTest.programmers.level3;

import java.util.*;

public class TravelRoute {
    /*
    1. tickets[i][0]이 ICN인 배열만 선택
    2. 해당 배열부터 하나씩 방문 배열 만들기 -> bfs
    3. 만든 배열을 static에 넣고 다른 배열이 들어오면 배열을 비교해서 알파벳순이 높은것 뽑기
    */

    class Route {
        String ticket;
        int[] check;
        String[] result;
        int cnt;

        public Route(String ticket, int[] check, String[] result, int cnt) {
            this.ticket = ticket;
            this.check = check;
            this.result = result;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "ticket='" + ticket + '\'' +
                    ", check=" + Arrays.toString(check) +
                    ", result=" + Arrays.toString(result) +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    String[] bfs(String[][] tickets) {
        ArrayList<String[]> resultList = new ArrayList<>();
        Queue<Route> q = new LinkedList<>();

        //인천에서 출발하는 티켓 찾기
        for(int i=0; i<tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                int[] check = new int[tickets.length];
                String[] result = new String[tickets.length+1];
                result[0] = tickets[i][0];
                result[1] = tickets[i][1];
                String ticket = tickets[i][1];
                check[i] = 1;
                int cnt = 2;

                Route route = new Route(ticket,check,result,cnt);

                q.add(route);
            }
        }

        while (!q.isEmpty()) {
            Route route = q.poll();

            if(route.cnt == tickets.length+1) {
                resultList.add(route.result);
            } else {
                for (int i = 0; i < tickets.length; i++) {
                    if (route.check[i] != 1 && route.ticket.equals(tickets[i][0])) {
                        System.out.println(route.toString());
                        int[] check = Arrays.copyOf(route.check,route.check.length);
                        check[i] = 1;

                        int cnt = route.cnt;

                        String[] result = Arrays.copyOf(route.result,route.result.length);
                        result[cnt] = tickets[i][1];
                        cnt += 1;

                        String ticket = tickets[i][1];
                        q.add(new Route(ticket,check,result,cnt));

                    }
                }
            }
        }

        for(String[] x : resultList) {
            System.out.println(Arrays.toString(x));
        }

        String[] result = resultList.get(0);
        for(int i=1; i< resultList.size(); i++) {
            for(int j=1; j<result.length; j++) {
                String[] arr = resultList.get(i);
                int num = arr[j].charAt(0) - result[j].charAt(0);
                System.out.println(arr[j] + " " + result[j] + " " + num);
                if(num > 0) break;
                if(num < 0) {
                    System.out.println(Arrays.toString(arr));
                    System.out.println(Arrays.toString(result));
                    System.out.println(arr[j] +", " + result[j]);
                    System.out.println(num);
                    result = Arrays.copyOf(arr,arr.length);
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

    public String[] solution(String[][] tickets) {
        return bfs(tickets);
    }

    public static void main(String[] args) {
        TravelRoute travelRoute = new TravelRoute();

        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[][] tickets3 = {{"ICN", "AAA"}, {"ICN", "CCC"}, {"CCC", "DDD"}, {"AAA", "BBB"}, {"AAA", "BBB"}, {"DDD", "ICN"}, {"BBB", "AAA"}};

        travelRoute.solution(tickets2);
    }
}
