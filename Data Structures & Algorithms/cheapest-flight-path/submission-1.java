class Pair {
    int node;
    int distance;
    int stop;

    Pair(int node, int distance, int stop) {
        this.node = node;
        this.distance = distance;
        this.stop = stop;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;

        int[] shortestDistance = new int[n];
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int distance = flights[i][2];

            graph.get(u).add(new Pair(v, distance, 0));
        }

        q.add(new Pair(src, 0, 0));

        while (q.size() > 0) {
            Pair remove = q.remove();
            int node = remove.node;
            int dist = remove.distance;
            int stops = remove.stop;

            if (stops > k) {
                continue;
            }

            ArrayList<Pair> nbrs = graph.get(node);
            for (Pair x : nbrs) {
                if (x.distance + dist < shortestDistance[x.node] && stops <= k) {
                    shortestDistance[x.node] = x.distance + dist;
                    q.add(new Pair(x.node, x.distance + dist, stops + 1));
                }
            }
        }

        for (int i=0;i<shortestDistance.length;i++){
            System.out.print(shortestDistance[i]+" ");
        }

        if (shortestDistance[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        

        return shortestDistance[dst];
    }
}
