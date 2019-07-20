class Solution {   //будем считать что массив отсортирован
    public int BinarySearch(int[] nums, int item){
        int size = nums.length;
        int first = nums[0];
        int last = nums[size - 1];
        int midl = (first + last) / 2;
        while (nums[midl] != item && (first <= last)){
            if (nums[midl] > item){
                last = midl - 1;
            }
            else{
                first = midl + 1;
            }
            midl = (first + last) / 2;
        }
        return midl;
    }
    public static void main(String args[]) {
        int a[] = {1,2,3,4,5,6,7,8,9};
        int item = 4;
        System.out.println(BinarySearch(a, item));
    }
    
}
