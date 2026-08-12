class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = profit(0, nums, target, dp);
        if (ans == Integer.MIN_VALUE) {
            return -1;
        }
        return ans;
    }
    public static int profit(int idx, List<Integer> nums, int target, int[][] dp) {
        if (target == 0) return 0;
        if (idx == nums.size())  return Integer.MIN_VALUE;
        if (dp[idx][target] != -1)  return dp[idx][target];

        int skip = profit(idx + 1, nums, target, dp);
        int take = Integer.MIN_VALUE;

        if (nums.get(idx) <= target) {
            int next = profit(idx + 1, nums,
                              target - nums.get(idx), dp);

            if (next != Integer.MIN_VALUE) {
                take = 1 + next;
            }
        }

        return dp[idx][target] = Math.max(take, skip);
    }
}