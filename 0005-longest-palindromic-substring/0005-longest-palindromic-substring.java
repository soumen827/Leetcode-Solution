class Solution {
     public String longestPalindrome(String s) {
        int n = s.length();
        int [][] dp = new int [n][n];
        int start =0; // first idx of the palindrome
        int end =0;   // last idx of the palindrome
        int maxLen = 0;
        for(int k=0;k<n;k++){
            int i=0 , j = k;
            while(j<n){
                if(i==j){//1 length
                     dp[i][j] =1;
                }
                else if(j==i+1){ // for 2 length
                    if(s.charAt(i)==s.charAt(j)){
                         dp[i][j] =1;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                            dp[i][j] =1;
                           
                    }
                }
                if(dp[i][j]==1){ // palindrome hay
                    int len = j-i+1; // len nikala
                    if(len>maxLen){//max se bara hua to to ab oh max hay
                        maxLen = len;
                        start =i;
                        end =j;
                    }
                }
                i++;j++;   
            }
        }
        return s.substring(start,end+1); // end+1 karon akta kom lei
    }
}