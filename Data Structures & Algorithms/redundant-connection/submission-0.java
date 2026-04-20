class DisjointSet {
    int n;
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();
    DisjointSet(int n) {
        this.n = n;

        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        return findUltimateParent(parent.get(node));
    }

    public void unionByRank(int u, int v) {
        int ultimateParentOfU = findUltimateParent(u);
        int ultimateParentOfV = findUltimateParent(v);

        if (ultimateParentOfU == ultimateParentOfV) {
            return;
        }

        if (rank.get(ultimateParentOfU) < rank.get(ultimateParentOfV)) {
            parent.set(ultimateParentOfU, ultimateParentOfV);
        } else if (rank.get(ultimateParentOfV) < rank.get(ultimateParentOfU)) {
            parent.set(ultimateParentOfV, ultimateParentOfU);
        } else {
            parent.set(ultimateParentOfV, ultimateParentOfU);
            int rankOfU = rank.get(ultimateParentOfU) + 1;
            rank.set(ultimateParentOfU, rankOfU);
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // If two nodes have the same parent then the edge between them is redundant
        int[] ans = new int[2];

        DisjointSet disjointset = new DisjointSet(edges.length+1);
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (disjointset.findUltimateParent(u) == disjointset.findUltimateParent(v)
                || disjointset.findUltimateParent(v) == disjointset.findUltimateParent(u)) {
                ans[0] = u;
                ans[1] = v;
            } else {
                disjointset.unionByRank(u, v);
            }
        }

        return ans;
    }
}
