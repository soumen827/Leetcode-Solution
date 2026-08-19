class Solution {
    public int minInsertions(String s) {
       StringBuilder a = new StringBuilder(s); 
        StringBuilder b = new StringBuilder(s).reverse();
        int m = a.length(), n = b.length();
        int[][] dp = new int[m][n]; // dp
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
       return m- lcs(m-1,n-1,a,b,dp);//String.length - lcs.length(Only this change)

    }
    public int lcs(int i, int j,StringBuilder a, StringBuilder b,int[][]dp) {
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return  dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return 1+ lcs(i-1,j-1,a,b,dp);
        else return dp[i][j] = Math.max(lcs(i-1,j,a,b,dp),lcs(i,j-1,a,b,dp)); // akbar i-- j same rakha , or akbar j-- and i same 
        
    }
}