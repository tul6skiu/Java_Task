class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set <List<Integer>> set = new HashSet<>();
        if (nums == null || nums.length < 3)
            new ArrayList<>(set);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3;i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                if (nums[i] + nums[j] + nums[k] == 0){
                    set.add(new ArrayList<>
                            (Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                }
                else{
                    if (nums[j] + nums[k] > (-nums[i]))
                        k--;
                    else
                        j++;
                }
                
            }
        }
        return new ArrayList<>(set);
    }
}
