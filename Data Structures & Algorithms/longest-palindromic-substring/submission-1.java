class Solution {
    public String longestPalindrome(String s) {
        // Two types of palindrome can exist odd length and even length
        if (s.length()<=1){
            return s;
        }
        String LPS = "";
        for (int i = 1; i < s.length(); i++) {
            // Even Length
            int low = i - 1;
            int high = i;

            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if (low == -1 || high == s.length()) {
                    break;
                }
            }

            String palindrome = s.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }

            // Odd Length
            low = i;
            high = i;

            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if (low == -1 || high == s.length()) {
                    break;
                }
            }

            palindrome = s.substring(low + 1, high);
            if (palindrome.length() > LPS.length()) {
                LPS = palindrome;
            }
        }

        return LPS;
    }
}
