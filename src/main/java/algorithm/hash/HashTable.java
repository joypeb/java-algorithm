package algorithm.hash;

import java.util.HashSet;
import java.util.Set;

public class HashTable {
    private int size = 10000;
    private int[] table = new int[size];

    public HashTable() {

    }

    public HashTable(int size) {
        this.size = size;
        this.table = new int[size];
    }

    public int hash(String key) {
        int asciiSum = 0;
        for(int i=0; i<key.length(); i++) {
            asciiSum += key.charAt(i);
        }
        return asciiSum % size;
    }

    public void insert(String key, Integer value) {
        int hashCode = hash(key);
        this.table[hashCode] = value;
        System.out.println(key + " " + hashCode + "방에 저장 완료");
    }

    public int search(String key) {
        return this.table[hash(key)];
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        Set<Integer> nameSet = new HashSet<>();

        String[] names = {"DongyeonKang",
                "SubinKang", "KwanwunKo", "HyunseokKo", "KyoungdukKoo", "YeonjiGu", "SoyeonKown", "OhsukKwon", "GunwooKim", "KiheonKim", "NayeongKim", "DohyeonKim", "MinkyoungKim", "MinjiKim", "SanghoKim", "SolbaeKim", "YejinKim", "EungjunKim", "JaegeunKim", "JeonghyeonKim", "JunhoKim", "JisuKim", "kimjinah", "HaneulKim", "HeejungKim", "KimoonPark", "EunbinPark", "JeongHoonPark", "JeminPark", "TaegeunPark", "JiwonBae", "SeunggeunBaek", "JihwanByeon", "HeungseopByeon", "JeongHeeSeo", "TaegeonSeo", "SeeYunSeok", "SuyeonSeong", "SeyoelSon", "MinjiSong", "JinwooSong"};

        for(int i=0; i<names.length; i++) {
            ht.insert(names[i],ht.hash(names[i]));
        }


    }
}
