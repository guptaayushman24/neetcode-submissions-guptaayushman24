class Solution {
    public boolean validateSudokoRow(char[][] board, int startRow, boolean[] nums) {
        for (int j = 0; j < board[0].length; j++) { // row is FIXED, walk columns
            if (board[startRow][j] != '.') {
                int d = board[startRow][j] - '0';
                if (nums[d])
                    return false;
                nums[d] = true;
            }
        }
        return true;
    }
    public boolean validateSudokoColumn(char[][] board, int startCol, boolean[] nums) {
        for (int i = 0; i < board.length; i++) { // col is FIXED, walk rows
            if (board[i][startCol] != '.') {
                int d = board[i][startCol] - '0';
                if (nums[d])
                    return false;
                nums[d] = true;
            }
        }
        return true;
    }
    public boolean validateSubMatrix(
        char[][] board, int startRow, int endRow, int startCol, int endCol) {
        boolean[] nums = new boolean[10];
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (board[i][j] != '.') {
                    if (nums[board[i][j] - '0'] == true) {
                        return false;
                    }

                    nums[board[i][j] - '0'] = true;
                }
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // Row validate
        for (int i = 0; i < board.length; i++) {
            boolean[] nums = new boolean[10];
            if (!validateSudokoRow(board, i, nums)) {
                return false;
            }
        }

        //  Column validate
        for (int j = 0; j < board[0].length; j++) {
            boolean[] nums = new boolean[10];
            if (!validateSudokoColumn(board, j, nums)) {
                return false;
            }
        }

        // 3 X 3 matrix validate
        for (int i = 0; i <= board.length - 3; i+=3) {
            for (int j = 0; j <= board[0].length - 3; j+=3) {
                int startRow = i;
                int endRow = i + 2;
                int startCol = j;
                int endCol = j + 2;

                if (!validateSubMatrix(board, startRow, endRow, startCol, endCol)) {
                    return false;
                }
            }
        }

        return true;
    }
}
