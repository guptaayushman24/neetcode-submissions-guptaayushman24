class Solution {
    public static int calculateMaxArea (int [][] grid,int x,int y,boolean [][] visited,int count,int [] dx,int [] dy){

        if (visited[x][y]==true){
            return count;
        }
        visited[x][y] = true;

        for (int i=0;i<4;i++){
            int newx = x+dx[i];
            int newy = y+dy[i];

            if (newx>=0 && newy>=0 && newx<grid.length && newy<grid[0].length && grid[newx][newy]==1 && visited[newx][newy]==false){
                count = count+calculateMaxArea (grid,newx,newy,visited,1,dx,dy);
            }
        }

        // for (int i=0;i<grid.length;i++){
        //     for (int j=0;j<grid[0].length;j++){
        //         if (grid[i][j]==1 && visited[i][j]==false){
                    
        //         }
        //     }
        // }

        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        int maxArea = Integer.MIN_VALUE;
        boolean [][] visited = new boolean [n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==1 && visited[i][j]==false){
                    int ans = calculateMaxArea (grid,i,j,visited,1,dx,dy);
                    maxArea = Math.max(maxArea,ans);
                }
            }
        }

        if (maxArea==Integer.MIN_VALUE){
            return 0;
        }
        return maxArea;
    }
}
