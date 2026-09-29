class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int maxLen = 0;
        int len = 0;
        int l = 0;
        for (int r=0;r<s.length();r++){
            while (hs.contains(s.charAt(r))){
                hs.remove(s.charAt(l));
                l++;
            }

            hs.add(s.charAt(r));
            len = r-l+1;
            maxLen = Math.max(maxLen,len);
        }

        return maxLen;
    }
}
