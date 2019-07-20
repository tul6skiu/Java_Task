class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = 1;
        int Maxcount = res;
        for (int i = 0; i < nums.length;i++){
            Maxcount *= nums[i];
            if (nums[i] > Maxcount){
                Maxcount = nums[i];
            }
            if (Maxcount > res)
                res = Maxcount;
        }
        return res;
    }
}
