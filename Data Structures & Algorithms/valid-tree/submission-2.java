class Pair {
    int src;
    int parent;

    Pair(int src, int parent) {
        this.src = src;
        this.parent = parent;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // If there is cycle in the graph then it is not the valid tree
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Queue<Pair> q = new LinkedList<>();
        int component = 0;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                component++;
                if (component>1){
                    return false; // If more than one component then it is not the valid tree
                }
                q.add(new Pair(i, -1));
                visited[i] = true;

                while (q.size() > 0) {
                    Pair remove = q.remove();
                    int src = remove.src;
                    int parent = remove.parent;

                    ArrayList<Integer> nbrs = graph.get(src);
                    for (int x : nbrs) {
                        if (visited[x] == false) {
                            q.add(new Pair(x, src));
                            visited[x] = true;
                        } else if (visited[x] == true && x != parent) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
