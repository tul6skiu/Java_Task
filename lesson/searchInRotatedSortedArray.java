public class searchInRotatedSortedArray {
    public static int search2(int[] nums, int target, int lo, int hi) {
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (target < nums[mid]) hi = mid - 1;
            else if (target > nums[mid]) lo = mid + 1;
            else return mid;

        }
        return -1;
    }
    public static int search(int[] nums, int target){
        if (nums.length == 0) return -1;
        int startIndex = 0;
        int endIndex = 0;
        int step1 = 0;
        int step2 = 0;
        int i = 0;
        while (i < nums.length - 1){
            if (nums[i] < nums[i + 1]){
                i++;
            }
            else {
                endIndex = i + 1;
                break;
            }
        }
        step1 = search2(nums,target,startIndex,endIndex);
        step2 = search2(nums,target,endIndex,nums.length - 1);
        if (step1 == -1 && step2 == -1)
            return -1;
        if (step1 == -1)
            return step2;
        else
            return  step1;


    }


    public static void main(String[] args) {
        int a[] = {};
        int t = 3;
        System.out.println(search(a,t));
    }
}
