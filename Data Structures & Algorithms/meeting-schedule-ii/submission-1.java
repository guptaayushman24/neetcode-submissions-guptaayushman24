/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i=0;i<intervals.size();i++){
            if (minheap.size()>0 && intervals.get(i).start>=minheap.peek()){
                minheap.poll();
            }
            minheap.add(intervals.get(i).end);
        }
        return minheap.size();
    }
}
