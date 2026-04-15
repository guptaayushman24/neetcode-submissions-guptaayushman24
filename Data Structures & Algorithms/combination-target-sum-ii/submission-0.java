class Solution {
    public void findCombinationSum2 (int [] candidates,List<Integer> temp,List<List<Integer>> ans,int index,int target,int sum){
        if (sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        if (index>=candidates.length){
            return;
        }
        if (sum>target){
            return;
        }
        // Including the nums[index]
        temp.add(candidates[index]);
        findCombinationSum2 (candidates,temp,ans,index+1,target,sum+candidates[index]);
        // sum = sum-candidates[index];
        temp.remove(temp.size()-1);

        // Checking if there any duplicate element present on the same level
        while (index<candidates.length-1 && candidates[index]==candidates[index+1]){
            index++;
        }

        // Excluding the nums[index]
        findCombinationSum2 (candidates,temp,ans,index+1,target,sum);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Easily can skip the duplicate elemetns that is why doing the sorting
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        findCombinationSum2 (candidates,temp,ans,0,target,0);

        return ans;
    }
}
