class Solution {
    public static int lengthOfLongestCommonSubsequence (String s1,String s2,int x,int y,int [][] dp){
        int z1 = 0;
        int z2 = 0;
        if (x>=s1.length() || y>=s2.length()){
            return 0;
        }

        if (dp[x][y]!=-1){
            return dp[x][y];
        }

        if (s1.charAt(x)==s2.charAt(y)){
            dp[x][y] = 1+lengthOfLongestCommonSubsequence(s1,s2,x+1,y+1,dp);
            return 1+lengthOfLongestCommonSubsequence(s1,s2,x+1,y+1,dp);
        }

        else{
            z1 = lengthOfLongestCommonSubsequence (s1,s2,x+1,y,dp);
            z2 = lengthOfLongestCommonSubsequence (s1,s2,x,y+1,dp);
        }

        dp[x][y] = Math.max(z1,z2);
        return Math.max(z1,z2);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int [text1.length()][text2.length()];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return lengthOfLongestCommonSubsequence (text1,text2,0,0,dp);
    }
}
