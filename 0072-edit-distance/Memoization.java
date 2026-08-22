class Solution {
    public int minDistance(String word1, String word2) {
        StringBuilder a = new StringBuilder(word1);
        StringBuilder b = new StringBuilder(word2);
        int m = a.length(), n = b.length();
        int[][] dp = new int [m][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return minSteps(m-1,n-1,a,b,dp);

    }
    public int minSteps(int i, int j,StringBuilder a ,StringBuilder b,int[][]dp){
        if(i==-1) return j+1; // Base case
        if(j==-1) return i+1; // Base case
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j] = minSteps(i-1,j-1,a,b,dp);

        else{// 3 kaj
            int del = minSteps(i-1,j,a,b,dp);
            int ins = minSteps(i,j-1,a,b,dp);
            int rep = minSteps(i-1,j-1,a,b,dp);
            return dp[i][j] = 1 + Math.min(Math.min(del,ins),rep);// 1 for count operation 
        } 

    }
}
