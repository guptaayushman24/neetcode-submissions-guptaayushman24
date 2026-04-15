class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int [] freq = new int [26];
        int maxFrequency = 0;
        int ans = 0;
        for (int right=0;right<s.length();right++){
            freq[s.charAt(right)-'A']++;
            maxFrequency = Math.max(maxFrequency,freq[s.charAt(right)-'A']);
            if (right-left+1-maxFrequency>k){
               freq[s.charAt(left)-'A']--;
               left++; 
            }
            ans = Math.max(ans,right-left+1);
        }

        return ans;
    }
}
