class Solution {
    public boolean containsDuplicate(int[] nums) {
        int size = nums.length;
        int res = 1;
        if (size < 2)
            return false;
        for (int i = 0; i < size; i++){
            for (int j = i + 1; j < size; j++){
                if (i == j)
                {
                    res = 0;
                }
            }
        }
        return  res == 0? false:true;
        
    }
}
