class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int ele:nums) sum += ele;
        if(sum%2 !=0) return false;
        int target = sum/2;
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<dp.length;i++){
           for(int j=0;j<dp[0].length;j++){
            dp[i][j] =-1;
           }
        }
         
       return subset(0,nums,target,dp);
    }
    private boolean subset(int i,int[] arr, int target,int[][]dp) {
        int n = arr.length;
        if(i==n){ // last tak agaya
            if(target==0) return true;
            else return false;
        }
        boolean ans = false; //extra
        if(dp[i][target]!= -1) return (dp[i][target]==1);// dp int ka hay and return type bool
        boolean skip = subset(i+1,arr,target,dp);
        if(target-arr[i]<0) ans = skip;
        else{
           boolean take = subset(i+1,arr,target-arr[i],dp);//take matlab sum+ us arry idx
           ans = take || skip;
        }
        if(ans==true) dp[i][target] = 1;
        else  dp[i][target] =0;
        return ans;
    }
}