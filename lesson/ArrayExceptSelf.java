class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int count = 0;
        int res = 1;
        for (int i = 0; i < len;i++)
        {
            if (nums[i] == 0)
            {
                nums[i] = 0;
            }
            else
                res *= nums[i];
        }
        
        for (int i = 0; i < len;i++)
        {
            if (nums[i] == 0 && count > 2)
                nums[i] = 0;
            else if (nums[i] == 0 && count > 0)
                nums[i] = 0;
            else if (nums[i] != 0 && count == 0)
                nums[i] = res / nums[i];
        }
        return nums;
    }
}
