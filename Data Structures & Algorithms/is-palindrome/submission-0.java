class Solution {
    public boolean isPalindrome(String s) {
        String newStr = "";
        for (int i=0;i<s.length();i++){
          if ((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='0' && s.charAt(i)<='9')){
            newStr = newStr+s.charAt(i);
          }
        }
        newStr = newStr.toLowerCase();
        newStr.replace(" ","");
        int left = 0;
        int right = newStr.length()-1;
        while (left<=right){
          if (newStr.charAt(left)!=newStr.charAt(right)){
            return false;
          }
          left++;
          right--;
        }

        return true;
    }
}
