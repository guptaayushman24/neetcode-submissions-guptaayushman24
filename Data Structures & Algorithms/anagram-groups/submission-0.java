class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> hm = new HashMap<>();

        for (int i=0;i<strs.length;i++){
            List<String> list = new ArrayList<>();
            char [] strArray = strs[i].toCharArray();
            Arrays.sort(strArray);
            String str = String.valueOf(strArray);

            if (hm.containsKey(str)){
                list = hm.get(str);
                list.add(strs[i]);
            }
            else{
                list.add(strs[i]);
                hm.put(str,list);
            }
        }

        hm.forEach((key,value)->{
           ans.add(new ArrayList<>(value));
        });

        return ans;
    }
}
