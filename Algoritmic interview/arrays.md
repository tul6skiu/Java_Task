# Arrays

+ [Find the Duplicate Number](#find-the-duplicate-number)
+ [Find Minimum in Rotated Sorted Array](#Find-Minimum-in-Rotated-Sorted-Array)
+ [Remove duplicates from array](#Remove-duplicates-from-array)
+ [Find First and Last Position of Element in Sorted Array](#Find-First-and-Last-Position-of-Element-in-Sorted-Array)
+ [Rotate matrix](#Rotate-matrix)

## Find the Duplicate Number
Find First and Last Position of Element in Sorted Array
https://leetcode.com/problems/find-the-duplicate-number/

```java
public int findDuplicate(int[] nums) {
  for (int i = 0; i < nums.length;i++) {
      if (nums[Math.abs(nums[i])] < 0) {
          return Math.abs(nums[i]);
     }
     nums[Math.abs(nums[i])] *= -1;
  }
  return 0;
}
```

## Find Minimum in Rotated Sorted Array

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array

```java
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[0]) {
            return nums[0];
        }
        while (right >= left) {
            int mid = left + (right - left )/2;
            
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
```
## Remove duplicates from array

```java
public class Solution {
    public int[] removeDublicate(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {return nums;}

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length;i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }
        int [] res = new int[set.size()];
        int k = 0;
        for (int num : set) {
            res[k++] = num;
        }
       return res;
    }
```

## Find First and Last Position of Element in Sorted Array

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
```java
public class searchRange {
        public static int binarySearch(int [] nums, int target, boolean left) {
            int lo = 0;
            int hi = nums.length - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] > target || (left && target == nums[mid])) {
                    hi = mid;
                }
                else {
                    lo = mid + 1;
                }
            }
            return lo;
        }

        public static int[] searchRange( int[] nums, int target){
            int[] res = {-1, -1};
            int left = binarySearch(nums, target, true);

            if (left == nums.length || nums[left] != target) {
                return res;
            }

            res[0] = left;
            res[1] = binarySearch(nums, target, false) - 1;
            return res;
        }
}
```

## Rotate matrix
```java
 public static int[][] rotateMatrix(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = tmp;
            }
        }

        int left = 0, right = arr.length - 1;
        while (left < right) {
            for (int i = 0; i < arr.length; i++) {
                int tmp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = tmp;
            }
            left++;
            right--;
        }
        return arr;
    }
