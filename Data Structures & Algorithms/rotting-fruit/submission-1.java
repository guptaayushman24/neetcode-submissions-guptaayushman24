class TrackOrange{
    int x;
    int y;
    int t;

    TrackOrange (int x,int y,int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<TrackOrange> q = new LinkedList<>();
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};
        int time = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==2){
                    q.add(new TrackOrange(i,j,0));
                }
            }
        }

        while (q.size()>0){
            TrackOrange remove = q.remove();
            time = remove.t;
            for (int i=0;i<4;i++){
                int newx = dx[i]+remove.x;
                int newy = dy[i]+remove.y;

                if (newx>=0 && newy>=0 && newx<grid.length && newy<grid[0].length && grid[newx][newy]!=2 && grid[newx][newy]!=0){
                    q.add(new TrackOrange(newx,newy,time+1));
                    grid[newx][newy] = 2;
                }
            }
        }

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    return -1;
                }
            }
        }

        return time;
    }
}
