class Solution {
    public static boolean checkForPalindrome(String subString) {
        int s = 0;
        int e = subString.length() - 1;

        while (s <= e) {
            if (subString.charAt(s) != subString.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }

        return true;
    }
    public String longestPalindrome(String s) {
        if (s.length()==1){
            return s;
        }
        int maxLen = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j+1);
                if (checkForPalindrome(subString)) {
                    maxLen = Math.max(maxLen, subString.length());
                    if (subString.length() >= maxLen) {
                        maxLen = subString.length();
                        ans = subString;
                    }
                }
            }
        }

        return ans;
    }
}
