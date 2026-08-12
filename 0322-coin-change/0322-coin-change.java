class Solution {
    public int coinChange(int[] coins, int amount) {
        long[][]dp = new long [coins.length][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0; j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans =(int)noOfCoin(0,coins,amount,dp); //convert long to int
        if(ans==Integer.MAX_VALUE) return -1; // for the test case  max value aya to -1 retuen 
        else return ans;
         
    }
    public long noOfCoin(int i, int[] coins, int amount,long[][]dp) {
        if(i==coins.length) {
            if(amount==0) return 0;// no more coin needed
            else return Integer.MAX_VALUE;// not a valid combination not return 1
        }
        if(dp[i][amount] != -1) return (dp[i][amount]);
        long skip = noOfCoin(i+1,coins,amount,dp);
        if(amount-coins[i]<0) return dp[i][amount] = skip;
        long take = 1 + noOfCoin(i,coins,amount-coins[i],dp);
        return dp[i][amount] = Math.min(skip,take);
    }
}