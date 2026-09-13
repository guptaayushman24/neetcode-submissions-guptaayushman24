class Pair{
    int x;
    int y;

    Pair (int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void numberOfIsland (char [][] grid,Queue<Pair> q,boolean [][] visited,int [] dx,int [] dy){
        while (q.size()>0){
            Pair pair = q.remove();
            int x = pair.x;
            int y = pair.y;

            for (int i=0;i<4;i++){
                int newx = x+dx[i];
                int newy = y+dy[i];

                if (newx>=0 && newy>=0 && newx<grid.length && newy<grid[0].length && grid[newx][newy]=='1' && visited[newx][newy]==false){
                    q.add(new Pair(newx,newy));
                    visited[newx][newy] = true;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] visited = new boolean [n][m];
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        Queue<Pair> q = new LinkedList<>();
        int count = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]=='1' && visited[i][j]==false){
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                    numberOfIsland (grid,q,visited,dx,dy);
                    count++;
                }
            }
        }

        return count;
    }
}
