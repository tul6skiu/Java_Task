class Solution {
    public int rob(int[] nums) {
        int [] dp = new int [nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length;i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}

class Solution2{
    public int rob2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res1 = nums[0];
        res1 + helper(nums, 2, nums.length - 2);
        int res2 = helper(nums, 1, nums.length - 1);
        return Math.max(res1, res2);
    }
    public int helper (int[] nums, int low, int high) {
        int yes = 0;
        int no = 0;
        for (int i = low;i <= high;i++) {
            int temp = no;
            no = Math.max(yes, no);
            yes = nums[i] + temp;
        }
        return Math.max(yes, no);
    }
}
