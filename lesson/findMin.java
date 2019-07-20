class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        int size = nums.length;
        for (int i = 0; i < size;i++){
            if (min > nums[i])
                min = nums[i];
        }
        return min;
    }
}
