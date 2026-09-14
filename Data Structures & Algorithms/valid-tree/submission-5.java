class Pair {
    int child;
    int parent;

    Pair(int child, int parent) {
        this.child = child;
        this.parent = parent;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // int n = edges.length;
        if (edges.length==0){
            return true;
        }
        int m = edges[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int component = 0;
        for (int i = 0; i <n; i++) {
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
                if (component > 1) {
                    return false;
                }

                q.add(new Pair(i, -1));
                visited[i] = true;
                while (q.size() > 0) {
                    Pair remove = q.remove();
                    ArrayList<Integer> nbrs = graph.get(remove.child);
                    for (int x : nbrs) {
                        if (visited[x] == false) {
                            q.add(new Pair(x, remove.child));
                            visited[x] = true;
                        } else if (visited[x] == true && x != remove.parent) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
