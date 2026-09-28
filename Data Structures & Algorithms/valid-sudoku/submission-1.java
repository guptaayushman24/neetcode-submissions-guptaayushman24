class Solution {
    public boolean validRow(int startRow, char[][] board, boolean[] visited, int m) {
        for (int j = 0; j < m; j++) {
            if (board[startRow][j] != '.') {
                int digit = board[startRow][j] - '0';
                if (visited[digit] == true) {
                    return false;
                }
                visited[digit] = true;
            }
        }

        return true;
    }

    public boolean validCol(int startCol, char[][] board, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (board[i][startCol] != '.') {
                int digit = board[i][startCol] - '0';
                if (visited[digit] == true) {
                    return false;
                }
                visited[digit] = true;
            }
        }

        return true;
    }

    public boolean isValidSubMatix(char[][] board, int sR, int eR, int sC, int eC) {
        boolean[] visited = new boolean[10];
        for (int i = sR; i <= eR; i++) {
            for (int j = sC; j <= eC; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    if (visited[digit] == true) {
                        return false;
                    }
                    visited[digit] = true;
                }
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // Validate each row
        // Validate each col
        // Validate each 3X3 matrix

        int n = board.length;
        int m = board[0].length;

        boolean isValidRow = false;
        boolean isValidCol = false;
        boolean isValid3X3 = false;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[10];
            isValidRow = validRow(i, board, visited, m);
            if (isValidRow == false) {
                return false;
            }
        }

        for (int j = 0; j < m; j++) {
            boolean[] visited = new boolean[10];
            isValidCol = validCol(j, board, visited, n);
            if (isValidCol == false) {
                return false;
            }
        }

        for (int i = 0; i <= n - 3; i += 3) {
            for (int j = 0; j <= m - 3; j += 3) {
                int sR = i;
                int eR = i + 2;
                int sC = j;
                int eC = j + 2;
                isValid3X3 = isValidSubMatix(board, sR, eR, sC, eC);
                if (isValid3X3 == false) {
                    return false;
                }
            }
        }

        return true;
    }
}
