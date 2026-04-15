class Solution {
    public static void findSubSetWithDup (List<List<Integer>> ans,List<Integer> temp,int [] nums,int index){
        if (index>=nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        // Including nums[index]
        temp.add(nums[index]);
        findSubSetWithDup (ans,temp,nums,index+1);
        temp.remove(temp.size()-1);

        // Skiping the duplicate which are on the same level
        while (index<nums.length-1 && nums[index]==nums[index+1]){
            index++;
        }

        // Excluding nums[index]
        findSubSetWithDup (ans,temp,nums,index+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // Easily can skip the duplicate elemetns that is why doing the sorting
        Arrays.sort(nums);
        findSubSetWithDup (ans,temp,nums,0);

        return ans;
    }
}
