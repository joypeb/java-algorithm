package algorithm.binarySearch;

public class Binary1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        int result = 7;

        //중간값과 key를 비교한다

        int low = 0, high = nums.length-1;
        boolean tf = true;

        while(tf) {
            int mid = (low+high)/2;

            if(result < nums[mid]) {
                high = mid - 1;
            } else if(result > nums[mid]) {
                low = mid + 1;
            } else if(result == nums[mid]){
                System.out.println(nums[mid]);
                tf = false;
            }
        }
    }
}
