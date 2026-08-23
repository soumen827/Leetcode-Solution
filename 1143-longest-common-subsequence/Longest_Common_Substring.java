    class Solution {
        public int longCommSubstr(String a, String b) {
            int m = a.length(), n = b.length();
            int[][] dp = new int[m+1][n+1]; // dp
            int max = 0;
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1] ;
                    else dp[i][j] = 0;
                    max = Math.max(max,dp[i][j]); //max me dp arr ka max value store kiya ohi ans hay

                }
            }
           return max; // store the lcs of substr(a,0,m-1)&(b,0,n-1);

        }
    }
