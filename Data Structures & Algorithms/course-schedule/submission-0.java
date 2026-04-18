class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int [] indegree = new int [numCourses];
        Queue<Integer> q = new LinkedList<>();

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
            count++;
            ArrayList<Integer> nbrs = graph.get(remove);
            for (int x:nbrs){
                indegree[x]--;
                if (indegree[x]==0){
                    q.add(x);
                }
            }
        }

        if (count==numCourses){
            return true;
        }

        return false;
        
    }
}
