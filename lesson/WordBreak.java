class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1;i < dp.length;i++){
            for (int j = i; j >=0;j--){
                if (dp[j]){
                    if (wordDict.contains(s.substring(j, i)));
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
