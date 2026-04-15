class Solution {
    public boolean checkForPermutation (String s1,String s2){
        char [] s1array = s1.toCharArray();
        char [] s2array = s2.toCharArray();
        Arrays.sort(s1array);
        Arrays.sort(s2array);

        int x = 0;
        int y = 0;
        while (x<s1array.length && y<s2array.length){
            if (s1array[x]!=s2array[y]){
                return false;
            }
            x++;
            y++;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        // char [] s2array = s2.toCharArray();
        // Arrays.sort(s2array);

        for (int i=0;i<=s2.length()-s1.length();i++){
            if (checkForPermutation(s1,s2.substring(i,i+s1.length()))){
                return true;
            }
        }
    
        return false;
    }
}
