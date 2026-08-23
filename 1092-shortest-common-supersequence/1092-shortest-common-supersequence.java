class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        String lcs = LCS (s1,s2);
        int i=0,j=0,k=0; // i is for a , j is for b , k is for lcs Str
        String scs = "";
        while(i<s1.length() && j<s2.length() && k<lcs.length()){
            while(i<s1.length() && s1.charAt(i) != lcs.charAt(k)){
                scs += s1.charAt(i);
                i++;
            }
            while(j<s2.length() && s2.charAt(j) != lcs.charAt(k)){
                scs += s2.charAt(j);
                j++;
            }
            scs += lcs.charAt(k);// 3no me sam hua to(a,b,c)
            i++;j++;k++;
        }
        // s1 khatam ho gaya to scs me add karo s2 ka bache hua character
            while(j<s2.length()){
                scs += s2.charAt(j);
                j++;
            }
        
       // s2 khatam ho gaya to scs me add karo s1 ka bache hua character
            while(i<s1.length()){
                scs += s1.charAt(i);
                i++;
            }
        
        return scs;
    }
      public String LCS(String a, String b) { //print lcs function 
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
           if(a.charAt(i-1)==b.charAt(j-1)){
                str.append(a.charAt(i-1));
                i--;
                j--;
            }
           else if(dp[i][j-1]>dp[i-1][j])  j--;
           else i--;
           
        }
        str.reverse(); // reverse the StringBuilder
        return str.toString(); // StringBuilder <- String
       //return dp[m][n]; // store the lcs of substr(a,0,m-1)&(b,0,n-1);
        
    }
}