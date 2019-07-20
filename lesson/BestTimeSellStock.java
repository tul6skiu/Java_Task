class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        if (size < 2)
            return 0;
        int i = 0, j = 1, res = 0;
        while (j < prices.length){
            int x = prices[i];
            int y = prices[j];
            if (x >= y)
                i = j;
            else{
                int a = y - x;
                if (a > res)
                    res = a;
            }
            j++;
        }
        return res;
    }
}
