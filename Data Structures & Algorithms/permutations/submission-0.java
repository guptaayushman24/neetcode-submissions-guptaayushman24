class Solution {
    public void findAllPermutation (int [] nums,List<List<Integer>> ans,List<Integer> temp,boolean [] freq){
        if (temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i=0;i<nums.length;i++){
            if (freq[i]==false){
                temp.add(nums[i]);
                freq[i] = true;
                findAllPermutation (nums,ans,temp,freq);
                temp.remove(temp.size()-1);
                freq[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean [] freq = new boolean [nums.length];
        findAllPermutation (nums,ans,temp,freq);

        return ans;
    }
}
