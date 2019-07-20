class Solution {
    public int coinChange(int[] coins, int amount) {
        if (null == coins || 0 == coins.length) {
            return -1;
        }
        Arrays.sort(coins);
        int size = coins.length;
        int count = 0;
        int res = 0;
        
        while (size != 0)
        {
            if (res <= amount)
            {
                res += coins[size - 1];
                count++;
            }
            else
            {
                size--;
            }
        }
        if (res == amount)
            return count;
        else
            return - 1;
        
    }
}
