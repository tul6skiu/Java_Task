public class searchInsert {
    public static  int searchInsert(int[] nums, int target) {
        int index = 0;
        int stepIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > target){
                stepIndex = 0;
                break;
            }
            else if (nums[i] == target) {
                return i;
            }
            else if (nums[i] > target){
                stepIndex = i;
                break;
            }
            else if( i == nums.length - 1)
                stepIndex = i;
        }
        return nums[nums.length - 1] < target? stepIndex + 1: stepIndex;
    }

    public static void main(String[] args) {
        int a[] = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(a, target));
    }
}
