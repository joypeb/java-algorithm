package algorithm.hash;

import java.util.ArrayList;
import java.util.List;

public class HashFunction3 {
    class Node {
        private String key;
        private Integer value;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    List<Node>[] table = new ArrayList[1000];

    public int hash(String s) {
        int ascii = 0;
        for(int i=0; i<s.length(); i++) {
            ascii += s.charAt(i);
        }
        return ascii % 1000;
    }

    public void insert(String key, int value) {
        int hashIndex = hash(key);

        if(this.table[hashIndex] == null) {
            this.table[hashIndex] = new ArrayList<>();
        }

        this.table[hashIndex].add(new Node(key,value));
    }

    public Integer get(String key) {
        List<Node> nodes = this.table[hash(key)];

        for (Node node : nodes) {
            if(key.equals(node.getKey())) {
                return node.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashFunction3 hf = new HashFunction3();
        hf.insert("Yoonseo",1);
        hf.insert("Seoyoon",2);

        int result = hf.get("Yoonseo");

        if(result == 1) {
            System.out.println("성공");
        } else {
            System.out.println("실패 value : " + result);
        }

        if(result == 2) {
            System.out.println("성공");
        } else {
            System.out.println("실패 value : " + result);
        }
    }
}
