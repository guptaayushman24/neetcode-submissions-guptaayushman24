class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length==2){
            if (stones[0]>stones[1]){
                return stones[0]-stones[1];
            }
            else{
                return stones[1]-stones[0];
            }
        }
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      for (int x:stones){
        pq.add(x);
      }

      while (pq.size()>2){
        int x = pq.remove();
        int y = pq.remove();
        if (x!=y){
            pq.add(x-y);
        }
      }

    if (pq.size()==1){
        return pq.peek();
    }
    int x = pq.remove();
    int y = pq.remove();

    return x-y;

    }
}
