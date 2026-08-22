class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder a = new StringBuilder(text1); // use Stringbuilder in place of String
        StringBuilder b = new StringBuilder(text2);
        int m = a.length(), n = b.length();
        int[][] dp = new int[m][n]; // dp
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int p = (i>=1 && j>=1)? dp[i-1][j-1] : 0;
                int r = (i>=1)? dp[i-1][j] : 0;
                int q = (j>=1)? dp[i][j-1] : 0;
                if(a.charAt(i)==b.charAt(j))
                    dp[i][j] = 1+p;
                else dp[i][j] = Math.max(q,r);

            }
        }
       return dp[m-1][n-1];
        
    }
    // public int lcs(int i, int j,StringBuilder a, StringBuilder b,int[][]dp) {
    //     if(i<0 || j<0) return 0;
    //     if(dp[i][j] != -1) return  dp[i][j];
    //     if(a.charAt(i)==b.charAt(j)) return 1+ lcs(i-1,j-1,a,b,dp);
    //     else return dp[i][j] = Math.max(lcs(i-1,j,a,b,dp),lcs(i,j-1,a,b,dp)); // akbar i-- j same rakha , or akbar j-- and i same 
        
    // }
}