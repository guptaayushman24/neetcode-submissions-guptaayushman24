class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int [] freq = new int[26];
        int maxFreq = 0;
        int maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowLen = right - left + 1; // current window length

            if (windowLen - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }
}
