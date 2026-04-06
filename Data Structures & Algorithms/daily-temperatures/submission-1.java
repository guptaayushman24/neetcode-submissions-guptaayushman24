class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int [] ans = new int [temperatures.length];
        for (int idx=temperatures.length-1;idx>=0;idx--){
            while (st.size()>0 && temperatures[idx]>=temperatures[st.peek()]){
                st.pop();
            }
            if (st.size()>0){
                ans[idx] = st.peek()-idx;
                 
            }
            

            st.push(idx);
        }

        return ans;
    }
}
