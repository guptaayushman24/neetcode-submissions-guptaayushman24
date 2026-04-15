class Solution {
    class Triplet {
        int x;
        int y;
        double dist;

        Triplet (int x,int y,double dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->Double.compare(a.dist,b.dist));
        int [][] ans = new int [k][2];
        int idx = 0;
        for (int i=0;i<points.length;i++){
            int x1 = 0;
            int y1 = 0;
            int x2 = points[i][0];
            int y2 = points[i][1];

            double dist = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
            pq.add(new Triplet (x2,y2,dist));
        }

        while (k>0){
            Triplet triplet = pq.remove();
            int x = triplet.x;
            int y = triplet.y;
            ans[idx][0] = x;
            ans[idx][1] = y;
            idx++;
            k--;
        }

        return ans;
    }
}
