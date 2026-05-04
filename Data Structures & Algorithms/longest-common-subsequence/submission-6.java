class Solution {
    public static int findLengthLongestCommonSubSequence(
        String text1, String text2, int idx1, int idx2, int[][] dp) {
        if (idx1 >= text1.length() || idx2 >= text2.length()) {
            return 0;
        }

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            if (dp[idx1][idx2] != -1) {
                return dp[idx1][idx2];
            }
            return dp[idx1][idx2] =
                       1 + findLengthLongestCommonSubSequence(text1, text2, idx1 + 1, idx2 + 1, dp);
        }
        if (dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        int x = findLengthLongestCommonSubSequence(text1, text2, idx1 + 1, idx2, dp);
        int y = findLengthLongestCommonSubSequence(text1, text2, idx1, idx2 + 1, dp);

        dp[idx1][idx2] = Math.max(x, y);
        return Math.max(x, y);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = findLengthLongestCommonSubSequence(text1, text2, 0, 0, dp);

        return ans;
    }
}
