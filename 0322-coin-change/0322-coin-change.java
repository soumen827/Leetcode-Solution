class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][]dp = new long [2][amount+1]; // only 2 row 
        for(int i=0;i<n;i++){
            for(int j=0; j<=amount;j++){
        long skip = (i>0) ? dp[0][j]: ((j==0) ? 0:Integer.MAX_VALUE);
                if(j-coins[i]<0)  dp[1][j] = skip;
                else{
        long take = 1 + dp[1][j-coins[i]];
                    dp[1][j] = Math.min(skip,take);
                }
            }
            for(int j=0;j<=amount;j++){ // copy pasing
                dp[0][j] = dp[1][j];
            }
        }
        int ans =(int)dp[1][amount];
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}