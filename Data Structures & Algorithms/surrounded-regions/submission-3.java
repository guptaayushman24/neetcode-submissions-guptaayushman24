class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void solve(char[][] board) {
        Queue<Pair> q = new LinkedList<>();
        int n = board.length;
        int m = board[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O') {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                    board[i][j]='#';
                }
            }
        }

        while (q.size() > 0) {
            Pair remove = q.remove();
            for (int i = 0; i < 4; i++) {
                int newx = dx[i] + remove.x;
                int newy = dy[i] + remove.y;

                if (newx >= 0 && newy >= 0 && newx < board.length && newy < board[0].length
                    && board[newx][newy] == 'O' && visited[newx][newy] == false) {
                    board[newx][newy] = '#';
                    q.add(new Pair(newx,newy));
                    visited[newx][newy] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j]=='#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}
