class Solution {
    public boolean checkPalindrome (String palindrome){
        int left = 0;
        int right = palindrome.length()-1;

        while (left<=right){
            if (palindrome.charAt(left)!=palindrome.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    public int countSubstrings(String s) {
        int count = 1;
        for (int i=1;i<s.length();i++){
            // Even Length
            int low = i-1;
            int high = i;

            
           
            while (s.charAt(low)==s.charAt(high)){
                 String palindrome = s.substring(low,high+1);
                 if (checkPalindrome (palindrome)){
                    low--;
                    high++;
                    count++;
                 }

                 if (low==-1 || high==s.length()){
                    break;
                 }
            }

                 // Odd Length
                low = i;
                high = i;
                 
                 while (s.charAt(low)==s.charAt(high)){
                    String palindrome = s.substring(low,high+1);
                    if (checkPalindrome(palindrome)){
                        low--;
                        high++;
                        count++;
                    }

                    if (low==-1 || high==s.length()){
                        break;
                    }
                 }
            }

        return count;
    }
}
