class Solution {
    public static boolean checkForThePermutationOfS1InS2 (String s1,String s2){
        char [] s1arr = s1.toCharArray();
        char [] s2arr = s2.toCharArray();

        Arrays.sort(s1arr);
        Arrays.sort(s2arr);

        int x = 0;
        while (x<s1arr.length){
            if (s1arr[x]!=s2arr[x]){
                return false;
            }
            else{
                x++;
            }
        }

        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        boolean isValid = false;
        for (int i=0;i<=s2.length()-s1.length();i++){
            isValid = checkForThePermutationOfS1InS2 (s1,s2.substring(i,i+s1.length()));
            if (isValid){
                break;
            }
        }

        return isValid;
    }
}
