class Distance{
    int x;
    int y;

    Distance (int x,int y){
        this.x = x;
        this.y = y;
    }
}
 
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Distance> q = new LinkedList<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==0){
                    q.add(new Distance(i,j));
                }
            }
        }

        int [] dx = {1, 0, -1, 0};
        int [] dy = {0, -1, 0, 1};

        while (q.size()>0){
            Distance remove = q.remove();
            int x = remove.x;
            int y = remove.y;

            for (int i=0;i<4;i++){
                int newx = dx[i]+x;
                int newy = dy[i]+y;

                if (newx>=0 && newy>=0 && newx<grid.length && newy<grid[0].length && grid[newx][newy]==Integer.MAX_VALUE){
                    grid[newx][newy] = grid[x][y]+1;
                    q.add(new Distance(newx,newy));
                }
            }
        }
    }
}
