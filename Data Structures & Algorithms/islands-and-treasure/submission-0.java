class Distance{
    int x;
    int y;
    int dist;

    Distance (int x,int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
// class Solution {
//     int [][] ans;
//     public void findNearestDistance (int x,int y,int [][] grid,boolean [][] visited,PriorityQueue<Distance> pq,int [] dx,int [] dy){
//         pq.add(new Distance (x,y,0));
//         while (pq.size()>0){
//             Distance distance = pq.remove();
//             if (grid[distance.x][distance.y]==0){
//                 ans[x][y] = distance.dist;
//                 break;
//             }

//            for (int i=0;i<4;i++){
//                 int newx = distance.x+dx[i];
//                 int newy = distance.y+dy[i];
             
//                 if (newx>=0 && newy>=0 && newx<grid.length && newy<grid[0].length && grid[newx][newy]!=-1 && visited[newx][newy]==false){
//                     pq.add(new Distance(newx,newy,distance.dist+1));
//                     visited[newx][newy] = true;
//                 }
//            }
//         }
//     }
//     public void islandsAndTreasure(int[][] grid) {
//         ans = new int [grid.length][grid[0].length];
//         int [] dx = {1,0,-1,0};
//         int [] dy = {0,-1,0,1};
//         for (int i=0;i<grid.length;i++){
//             for (int j=0;j<grid[0].length;j++){
//                 if (grid[i][j]!=-1){
//                     PriorityQueue<Distance> pq = new PriorityQueue<>((x,y)->x.dist-y.dist);
//                     boolean [][] visited = new boolean [grid.length][grid[0].length];
//                     findNearestDistance(i,j,grid,visited,pq,dx,dy);
//                 }
               
//             }
//         }

//         for (int i=0;i<grid.length;i++){
//             for (int j=0;j<grid[0].length;j++){
//                 grid[i][j] = ans[i][j];
//             }
//         }
//     }
// }

class Solution {
    int[][] ans;  // ✅ declared globally at class level

    public void findNearestDistance(int x, int y, int[][] grid, boolean[][] visited,
                                     PriorityQueue<Distance> pq, int[] dx, int[] dy) {
        // ✅ no need to pass ans as parameter anymore
        pq.add(new Distance(x, y, 0));
        while (pq.size() > 0) {
            Distance distance = pq.remove();
            if (grid[distance.x][distance.y] == 0) {
                ans[x][y] = distance.dist;  // ✅ directly access instance variable
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newx = dx[i] + distance.x;  // ✅ should use distance.x not x
                int newy = dy[i] + distance.y;  // ✅ should use distance.y not y
                if (newx>=0 && newy>=0 && newx<grid.length && newy<grid[0].length
                    && grid[newx][newy] != -1 && !visited[newx][newy]) {
                    pq.add(new Distance(newx, newy, distance.dist + 1));
                    visited[newx][newy] = true;
                }
            }
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        ans = new int[grid.length][grid[0].length];  // ✅ initialize here
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==Integer.MAX_VALUE) {
                    PriorityQueue<Distance> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    visited[i][j] = true;  // ✅ mark start
                    findNearestDistance(i, j, grid, visited, pq, dx, dy);
                }
                else if (grid[i][j]==-1){
                    ans[i][j] = -1;
                }
            }
        }

        // ✅ copy ans back to grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = ans[i][j];
            }
        }
    }
}
