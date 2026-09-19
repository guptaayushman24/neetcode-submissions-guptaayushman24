class Solution {
    public static int findMinDistance(String word1, String word2, int idx1, int idx2,int [][] dp) {
        if (idx1 >= word1.length()) {
            return word2.length() - idx2; // insert the rest of word2
        }
        if (idx2 >= word2.length()) {
            return word1.length() - idx1; // delete the rest of word1
        }
        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            return findMinDistance(word1, word2, idx1 + 1, idx2 + 1,dp);
        }
        if (dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        int replace = 1 + findMinDistance(word1, word2, idx1 + 1, idx2 + 1,dp);
        int delete = 1 + findMinDistance(word1, word2, idx1 + 1, idx2,dp);
        int insert = 1 + findMinDistance(word1, word2, idx1, idx2 + 1,dp);

        dp[idx1][idx2] = Math.min(replace, Math.min(delete, insert));
        return Math.min(replace, Math.min(delete, insert));
    }
    public int minDistance(String word1, String word2) {
        int [][] dp = new int [word1.length()+1][word2.length()+1];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = findMinDistance(word1, word2, 0, 0,dp);

        return ans;
    }
}
