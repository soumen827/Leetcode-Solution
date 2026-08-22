class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[2][n+1]; // dp
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1)==b.charAt(j-1)) dp[1][j] = 1+dp[1-1][j-1] ;
                else dp[1][j] = Math.max(dp[1-1][j],dp[1][j-1]);

            }
            //copy path
                for(int j=0;j<=n;j++)
                    dp[0][j] = dp[1][j];
        }
       return dp[1][n]; // store the lcs of substr(a,0,m-1)&(b,0,n-1);
        
    }
}
// S.C = O(n)
// T.C = (m*n)