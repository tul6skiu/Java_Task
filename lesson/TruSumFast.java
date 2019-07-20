import java.util.*;

public class TruSumFast {

    static class Trio {
        int i;
        int j;
        int k;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Trio trio = (Trio) o;
            return i == trio.i &&
                    j == trio.j &&
                    k == trio.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, k);
        }

        public Trio set(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;

            return this;
        }


        public Trio(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }


    }

    public static int binarySearch(int rank, int[] a) {

        int lo = 0;
        int hi = a.length - 1;
        int mid = 0;
        while (lo <= hi) {

            mid = lo + (hi - lo) / 2;
            if (rank < a[mid]) hi = mid - 1;
            else if (rank > a[mid]) lo = mid + 1;
            else
                return mid;
        }
        return -1;

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        int cnt = 0;
        int k = 0;
        Trio trio = new Trio(0, 0, 0);
        Set<Trio> set = new HashSet<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == -1 && nums[j] == 2)
                    System.out.println("hello");
                if ((k = binarySearch(-(nums[i] + nums[j]), nums)) > j) {
                    if (!set.contains(trio.set(nums[i], nums[j], nums[k]))) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        set.add(trio);
                        lists.add(list);
                    }
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
      int a[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));
    }
}