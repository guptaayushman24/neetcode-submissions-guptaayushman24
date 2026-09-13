class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    // public void surroundedRegion (char [][] board,int [] dx,int [] dy,boolean [][]
    // visited,Queue<Pair> q){

    // }
    public void solve(char[][] board) {
        Queue<Pair> q = new LinkedList<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Push all the boundary 'Os' in the queue
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j]=='O') {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (q.size() > 0) {
            Pair remove = q.remove();
            int x = remove.x;
            int y = remove.y;
            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];

                if (newx >= 0 && newy >= 0 && newx < n && newy < m && board[newx][newy] == 'O'
                    && visited[newx][newy] == false) {
                    q.add(new Pair(newx, newy));
                    visited[newx][newy] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && visited[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
