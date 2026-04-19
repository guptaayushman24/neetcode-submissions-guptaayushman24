class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int [] ans = new int [numCourses];
        int [] indegree = new int [numCourses];
        int x = 0;

        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            graph.get(v).add(u);
        }
        for (int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            indegree[u]++;

        }

        for (int i=0;i<indegree.length;i++){
            if (indegree[i]==0){
                q.add(i);
            }
        }

        while (q.size()>0){
            int remove = q.remove();
            ans[x] = remove;
            x++;

            List<Integer> nbrs = graph.get(remove);
            for (int y:nbrs){
                indegree[y]--;
                if (indegree[y]==0){
                    q.add(y);
                }
            }
        }

        if (x==numCourses){
            return ans;
        }

        return new int [0];
    }
}
