package codeTest.programmers.level2;

public class CacheLRU {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length*5;

        int answer = 0;
        String[] cache = new String[cacheSize];

        for(String city : cities) {
            String lowCity = city.toLowerCase();
            int pos = -1;

            for(int i=0; i<cacheSize; i++)
                if(lowCity.equals(cache[i])) pos = i;

            if(pos == -1) {
                for(int i=cacheSize-1; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
                answer+=5;
            } else {
                for(int i=pos; i>=1; i--) {
                    cache[i] = cache[i-1];
                }
                answer+=1;
            }
            cache[0] = lowCity;
        }

        return answer;
    }

    public static void main(String[] args) {
        CacheLRU cacheLRU = new CacheLRU();

        int size = 2;
        String[] arr = {"Jeju", "Pangyo", "NewYork", "newyork"};

        System.out.println(cacheLRU.solution(size,arr));
    }
}
