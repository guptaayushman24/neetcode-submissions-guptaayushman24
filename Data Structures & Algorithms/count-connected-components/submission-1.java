class Solution {
    public static void noOfConnectedComponent(
        int n, List<List<Integer>> adjList, boolean[] visited,Queue<Integer> q) {
        while (q.size() > 0) {
            int remove = q.remove();
            List<Integer> nbrs = adjList.get(remove);
            for (int x : nbrs) {
                if (visited[x] == false) {
                    q.add(x);
                    visited[x] = true;
                }
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        int ans = 0;
        List<List<Integer>> adjList = new ArrayList<>();
         Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                q.add(i);
                visited[i] = true;
                noOfConnectedComponent(n, adjList, visited,q);
                ans++;
            }
        }

        return ans;
    }
}
