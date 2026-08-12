class Solution {
    static int sum;
    public int findTargetSumWays(int[] arr, int target) {
        // i -> 0 to n-1 | target = -sum to sum arry ka
         sum =0 ; int n = arr.length;
        for(int ele:arr) sum += ele;
        int [][] dp = new int[n][2*sum+1]; // -sum to sum -> 0 to 2*Sum
        for(int i=0;i<dp.length;i++){
            for(int j=0; j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return way(0,arr,0,target,dp);
    }
    public int way(int i, int[] arr,int res, int target, int[][]dp) {
        if(i==arr.length){
            if(res==target) return 1; // 1valid way
            else return 0;
        }
        // if(target<0) return skip oh nehi hoga kua ki -no hay 
       // dp[i][target+sum] -> ways(i,target)
        if(dp[i][res+sum] != -1) return dp[i][res+sum];
        int add = way(i+1,arr,res+arr[i],target,dp); // same as take skip
        int sub = way(i+1,arr,res-arr[i],target,dp);
        return dp[i][res+sum] = add+sub;
    }
}