class Time{
    int x;
    int y;
    int time;

    Time (int x,int y,int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        // Push all the rotten oranges in the queue with t = 0
        // Pop the each element one by one and if there is possiblity push the fruits
        int time = 0;
        Queue<Time> q = new LinkedList<>();
        boolean [][] visited = new boolean [grid.length][grid[0].length];
        int [] dx = {1,0,-1,0};
        int [] dy = {0,-1,0,1};

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==2){
                    q.add(new Time(i,j,0));
                }
            }
        }

        while (q.size()>0){
            Time minTime = q.remove();
            time = minTime.time;
            for (int i=0;i<4;i++){
                int newx = minTime.x+dx[i];
                int newy = minTime.y+dy[i];
                if (newx>=0 && newy>=0 && newx<grid.length && newy<grid[0].length && grid[newx][newy]==1){
                    q.add(new Time(newx,newy,minTime.time+1));
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
