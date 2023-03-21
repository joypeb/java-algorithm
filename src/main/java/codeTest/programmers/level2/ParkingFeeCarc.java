package codeTest.programmers.level2;

import java.util.*;

public class ParkingFeeCarc {
    class Car {
        String time;
        int totalTime;
        int num;
        boolean status;

        public Car(String time, int totalTime, int num, boolean status) {
            this.time = time;
            this.totalTime = totalTime;
            this.num = num;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "time='" + time + '\'' +
                    ", totalTime=" + totalTime +
                    ", num=" + num +
                    ", status=" + status +
                    '}';
        }
    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        HashMap<Integer,Car> hashMap = new HashMap<>();

        for(int i=0; i<records.length; i++) {
            String[] arr = records[i].split(" ");
            String time = arr[0];
            int num = Integer.parseInt(arr[1]);
            int totalTime = 0;
            boolean status = arr[2].equals("IN") ? true : false;

            Car car = hashMap.getOrDefault(num,new Car("00:00",0,num,true));

            if(!status) {
                int[] hourMin = Arrays.stream(car.time.split(":")).mapToInt(Integer::parseInt).toArray();
                int[] arrHourMin = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
                totalTime = ((arrHourMin[0]-hourMin[0])*60) + (arrHourMin[1]-hourMin[1]);
                totalTime += car.totalTime;
            } else {
                totalTime = car.totalTime;
            }

            hashMap.put(num,new Car(time,totalTime,num,status));
        }

        List<Integer> list = new ArrayList<>(hashMap.keySet());
        Collections.sort(list);

        answer = new int[list.size()];
        int cnt = 0;

        for(int x : list) {
            Car car = hashMap.get(x);
            int totalTime = car.totalTime;
            int result = 0;

            if(car.status) {
                int[] hourMin = Arrays.stream(car.time.split(":")).mapToInt(Integer::parseInt).toArray();
                int hour = 23, min = 59;
                totalTime += ((hour-hourMin[0])*60) + (min-hourMin[1]);
            }

            if(totalTime > fees[0]) {
                result = (int) (fees[1] + ((Math.ceil((totalTime-fees[0])/(double)fees[2])) * fees[3]));
            } else {
                result = fees[1];
            }

            answer[cnt] = result;
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        ParkingFeeCarc parkingFeeCarc = new ParkingFeeCarc();

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] fees2 = {1, 461, 1, 10};
        String[] records2 = {"00:00 1234 IN"};

        int[] result = parkingFeeCarc.solution(fees2,records2);

        System.out.println(Arrays.toString(result));
    }
}
