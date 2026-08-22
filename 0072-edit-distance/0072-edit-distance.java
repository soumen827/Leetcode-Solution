class Solution {
    public int minDistance(String a, String b) {
        int m = a.length(), n = b.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[][] dp = new int[2][n + 1];
        // First row: a = ""
        for (int j = 0; j <= n; j++)  dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            // First column
            dp[1][0] = i;
            for (int j = 1; j <= n; j++) {
                int p = dp[0][j - 1]; // diagonal
                int q = dp[1][j - 1]; // left
                int r = dp[0][j];     // up
                if (a.charAt(i - 1) == b.charAt(j - 1))  dp[1][j] = p; else dp[1][j] = 1 + Math.min( Math.min(q, p),r);
            }
            // current row -> previous row (Copy pasting)
            for (int j = 0; j <= n; j++) {
                dp[0][j] = dp[1][j];
            }
        }
        return dp[1][n];
    }
}