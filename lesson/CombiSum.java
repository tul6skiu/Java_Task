class Solution {
    public int combinationSum4(int[] nums, int target) {
        int [] res = new int[target + 1];
        res[0] = 1;
        for (int i = 1; i <= target;i++){
            for (int num : nums){
                if (i >= num)
                    res[i] += res[i - num];
            }
        }
        return res[target];
    }
}
