class Solution {
    public static boolean oddLengthPalindrome(String str, int s, int e) {
        int count = 0;
        while (s <= e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean evenLengthPalindrome(String str, int s, int e) {
        int count = 0;
        while (s <= e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            } else {
                return false;
            }
        }

        return true;
    }
    public int countSubstrings(String s) {
        int count = 0;
        // Odd lenth
        // Even length

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                if (oddLengthPalindrome(str, 0, str.length() - 1)) {
                    count = count + 1;
                }
            }
        }

        return count;
    }
}
