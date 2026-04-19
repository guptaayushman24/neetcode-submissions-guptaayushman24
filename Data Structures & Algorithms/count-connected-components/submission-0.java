class Solution {
    public int countComponents(int n, int[][] edges) {
      boolean [] visited = new boolean [n];
      Queue<Integer> q = new LinkedList<>();
      int component = 0;
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for (int i=0;i<n;i++){
        graph.add(new ArrayList<>());
      }

      for (int i=0;i<edges.length;i++){
        int u = edges[i][0];
        int v = edges[i][1];

        graph.get(u).add(v);
        graph.get(v).add(u);

      }

      for (int i=0;i<n;i++){
        if (visited[i]==false){
            component++;
            q.add(i);
            visited[i] = true;
            while (q.size()>0){
                int remove = q.remove();
                ArrayList<Integer> nbrs = graph.get(remove);
                for (int x:nbrs){
                    if (visited[x]==false){
                        q.add(x);
                        visited[x] = true;
                    }
                }
            }
        }
      }

      return component;
    }
}
