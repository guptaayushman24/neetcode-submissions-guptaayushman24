class Solution {
    public static int findUniquePaths(int x, int y, int m, int n, int[][] dp) {
        if (x < 0 || y < 0 || x > m || y > n) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        int way1 = findUniquePaths(x, y + 1, m, n,dp);
        int way2 = findUniquePaths(x + 1, y, m, n,dp);

        dp[x][y] = way1+way2;
        return way1 + way2;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<m+1;i++){
            for (int j=0;j<n+1;j++){
                dp[i][j] = -1;
            }
        }
        int ans = findUniquePaths(0, 0, m, n, dp);

        return ans;
    }
}
