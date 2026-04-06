class Solution {
   public static int doOperations (int x,int y,String token){
        if (token.equals("+")){
            return x+y;
        }
        else if (token.equals("-")){
            return x-y;
        }
        else if (token.equals("*")){
            return x*y;
        }
        return x/y;
    }
    public int evalRPN(String[] tokens) {
         Stack<String> st = new Stack<>();
      for (int i=0;i<tokens.length;i++){
        if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
            int x = Integer.valueOf(st.pop());
            int y = Integer.valueOf(st.pop());
            int z = doOperations (y,x,tokens[i]);
            st.push(String.valueOf(z));
        }
        else{
            st.push(tokens[i]);
        }
      }

      System.out.println(st.peek());
      return Integer.valueOf(st.peek());
    }
}
