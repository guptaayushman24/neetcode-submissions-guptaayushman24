class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        int idx = temperatures.length-2;
        Stack<Integer> st = new Stack<>();

        st.push(temperatures.length - 1);

        for (int i = temperatures.length - 2; i >= 0; i--) {
            while (st.size() > 0 && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                ans[idx] = 0;
            } else {
                ans[idx] = st.peek() - i;
            }
            idx--;
            st.push(i);
        }

        return ans;
    }
}
