class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        //LIS
        int [] dp1 = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(nums[j]<nums[i]) dp1[i] = Math.max(dp1[i],dp1[j]);
            }
            dp1[i] += 1; // for idx i 
        }
        // Reverse  LIS
        int [] dp2 = new int[n];
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<=n-1;j++){
                if(nums[j]<nums[i]) dp2[i] = Math.max(dp2[i],dp2[j]);
            }
            dp2[i] += 1; // for idx i
        }
        int maxLen =0;
        for(int i=0;i<n;i++){
            if(dp1[i]>1 && dp2[i]>1){
                 int sum = dp1[i] + dp2[i] - 1; // LIS(forword) + LIS(Backward) + 1;
                maxLen = Math.max(maxLen,sum);
            }
        }
        if(maxLen<3) return 0; // for mountain arry min 3 ta idx dorkar
        return n-maxLen;
    }
}