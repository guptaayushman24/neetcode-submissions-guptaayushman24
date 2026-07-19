class Cordinate{
    int x;
    int y;
    double dist;

    Cordinate (int x,int y,double dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Priority Queue
        PriorityQueue<Cordinate> pq = new PriorityQueue<>((a,b)->Double.compare(a.dist,b.dist));
        int [][] ans = new int [k][2];
        int idx = 0;
        for (int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];

            double dist =  Math.sqrt((x-0)*(x-0) + (y-0)*(y-0));
            pq.add(new Cordinate(x,y,dist));
        }

        while (k>0){
            ans[idx][0] = pq.peek().x;
            ans[idx][1] = pq.peek().y;

            pq.remove();
            k--;
            idx++;
        }


        return ans;
    }
}
