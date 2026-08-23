class Solution {
    public int longestCommonSubsequence(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m+1][n+1]; // dp
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1] ;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);

            }
        }
        StringBuilder str = new StringBuilder("");
        int i = m, j =n;
        while(i>=1 && j>=1){
           if(a.charAt(i-1)==b.charAt(j-1)) str.append(a.charAt(i-1));
           if(dp[i][j-1]>dp[i-1][j])  j--;
           else i--;
           
        }
        System.out.println(str.reverse()); // reverse the StringBuilder
       return dp[m][n]; // store the lcs of substr(a,0,m-1)&(b,0,n-1);
        
    }
}