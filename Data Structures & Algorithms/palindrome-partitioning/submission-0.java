class Solution {
    public boolean checkPalindrome (String s,int start,int end){
        while (start<end){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
    public void generatePalindromePartition (String s,List<String> temp,List<List<String>> ans,int index){
        if (index==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i=index;i<s.length();i++){
            // Check the palindrome from the current index till i
            if (checkPalindrome (s,index,i)){
                temp.add(s.substring(index,i+1));
                generatePalindromePartition (s,temp,ans,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        List<List<String>> ans = new ArrayList();

        generatePalindromePartition (s,temp,ans,0);

        return ans;
    }
}
