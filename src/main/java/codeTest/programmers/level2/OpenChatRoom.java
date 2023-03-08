package codeTest.programmers.level2;

import java.util.*;

public class OpenChatRoom {

    static Queue<TypeRecord> queue = new LinkedList<>();
    static Map<String, String> map = new HashMap<>();
    class TypeRecord {
        String status;
        String id;

        public TypeRecord(String status, String id) {
            this.status = status;
            this.id = id;
        }

        public String getStatus() {
            return status;
        }
        public String getId() {
            return id;
        }
    }

    public String[] solution(String[] record) {
        String[] answer = {};

        for(int i=0; i<record.length; i++) {
            String[] type = record[i].split(" ");
            String status = type[0];

            if(status.equals("Enter")) {
                addMapType(type);
                addTypeRecord(type);
            } else if(status.equals("Leave")){
                addTypeRecord(type);
            } else if(status.equals("Change")) {
                addMapType(type);
            }

        }

        answer = new String[queue.size()];

        for(int i=0; i< answer.length; i++) {
            TypeRecord typeRecord = queue.poll();
            String nickname = map.get(typeRecord.getId());
            String statusKorean = "";

            if(typeRecord.getStatus().equals("Enter")) {
                statusKorean = "님이 들어왔습니다.";
            } else {
                statusKorean = "님이 나갔습니다.";
            }

            answer[i] = nickname + statusKorean;
        }

        return answer;
    }

    void addTypeRecord(String[] type) {
        TypeRecord typeRecord = new TypeRecord(type[0],type[1]);
        queue.add(typeRecord);
    }

    void addMapType(String[] type) {
        map.put(type[1],type[2]);
    }

    public static void main(String[] args) {
        OpenChatRoom openChatRoom = new OpenChatRoom();

        String[] arr = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] result = openChatRoom.solution(arr);

        System.out.println(Arrays.toString(result));
    }
}
