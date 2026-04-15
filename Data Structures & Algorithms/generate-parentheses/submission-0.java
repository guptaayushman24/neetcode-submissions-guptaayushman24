class Solution {
    public void  generate (List<String> ans,int n,String str,int open,int close){
        if (str.length()==n*2){
            ans.add(str);
            return;
        }

        if (n>open){
            // Insert openning bracket
            generate (ans,n,str+"(",open+1,close);
        }

        if (close<open){
            // Insert clossing bracket
            generate (ans,n,str+")",open,close+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        // StringBuilder sb = new StringBuilder();
        String str = "";
        int open = 0;
        int close = 0;
        generate (ans,n,str,open,close);

        return ans;
    }
}
