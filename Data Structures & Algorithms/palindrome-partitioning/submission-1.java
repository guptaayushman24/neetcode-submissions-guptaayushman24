class Solution {
    public static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void palindromePartition(
        String s, List<String> res, List<List<String>> path, int index) {
            if (index==s.length()){
                path.add(new ArrayList<>(res));
            }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                res.add(s.substring(index, i + 1));
                palindromePartition(s, res, path, i + 1);
                res.remove(res.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> path = new ArrayList<>();
        List<String> res = new ArrayList<>();

        palindromePartition(s, res, path, 0);

        return path;
    }
}
