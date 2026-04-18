class Pair{
    int x;
    int y;
    Pair (int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void solve(char[][] board) {
      boolean [][] visited = new boolean [board.length][board[0].length];
      Queue<Pair> q = new LinkedList<>();
      int [] dx = {1,0,-1,0};
      int [] dy = {0,1,0,-1};
      // Push all the boundary O's
      for (int i=0;i<board.length;i++){
        for (int j=0;j<board[0].length;j++){
            if (board[i][j]=='O' && (i==0 || j==0 || i==board.length-1 || j==board[0].length-1)){
                q.add(new Pair(i,j));
                visited[i][j] = true;
            }
        }
      }  

      while (q.size()>0){
        Pair remove = q.remove();
        for (int i=0;i<4;i++){
            int newx = dx[i]+remove.x;
            int newy = dy[i]+remove.y;

            if (newx>=0 && newy>=0 && newx<board.length && newy<board[0].length && board[newx][newy]=='O' && visited[newx][newy]==false){
                q.add(new Pair(newx,newy));
                visited[newx][newy] = true;
            }
        }
      }

      for (int i=0;i<visited.length;i++){
        for (int j=0;j<visited[0].length;j++){
            if (visited[i][j]==false && board[i][j]=='O'){
                board[i][j] = 'X';
            }
        }
      } 
    }
}
