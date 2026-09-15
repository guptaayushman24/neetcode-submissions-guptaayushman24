class Solution {
    public String longestPalindrome(String s) {
        int start = 0; 
        int maxLen = 1; 
        String ans = "";
        int n = s.length();
        boolean [][] dp = new boolean [n][n];
        for (int i=0;i<n;i++){
            dp[i][i] = true; // Every one length of string is palindrome
        }

        // Start from the len = 2 to length of the string
        for (int len=2;len<=n;len++){
            for (int i=0;i+len-1<n;i++){ // For each substring last index will be i+len-1
                int j = i+len-1;
                if (s.charAt(i)==s.charAt(j)){
                    if (len==2){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }

                    // To find the substring
                    if (dp[i][j]==true && len>maxLen){
                         start = i;
                         maxLen = len;
                    }
                }
            }
        }

        return s.substring(start,start+maxLen);
    }
}
