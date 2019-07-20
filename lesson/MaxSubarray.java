class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int sumMax = nums[0];
        int sum = sumMax;
        for (int i = 1; i < nums.length;i++){
            sum += nums[i];
            if (nums[i] > sum){
                sum = nums[i];
            }
            if (sum > sumMax)
                sumMax = sum;
        }
        return sumMax;
    }
}
