public class removeElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if (nums[j] != val){
                i++;
                nums[i] = nums[j];
            }
        return i;
    }
}
