class Solution {
    public static int findUniquePath (int x,int y,int m,int n,int [][] dp){
        if (x==m-1 && y==n-1){
            return 1;
        }

        if (x>=m || y>=n){
            return 0;
        }
        if (dp[x][y]!=-1){
            return dp[x][y];
        }
        int oneWay = findUniquePath (x+1,y,m,n,dp);
        int secondWay = findUniquePath (x,y+1,m,n,dp);

        dp[x][y] = oneWay+secondWay;

        return oneWay+secondWay;
    }
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m+1][n+1];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = findUniquePath (0,0,m,n,dp);

        return ans;
    }
}
