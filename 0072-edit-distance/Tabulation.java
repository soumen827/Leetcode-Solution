class Solution {
    public int minDistance(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int [m][n];
        if(m==0) return n;
        if(n==0) return m;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                int p = (j>=1 && i>=1)? dp[i-1][j-1]: (i==0 ? j : i);
                int q = (j>=1) ? dp[i][j-1]: i;
                int r = (i>=1) ? dp[i-1][j]: j;
                if(a.charAt(i)==b.charAt(j)) dp[i][j] = p;
                else dp[i][j] = 1 + Math.min(Math.min(q,p),r);
                
            }
        }
        return dp[m-1][n-1];
    }
}
