class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int [][] cars = new int [position.length][2];
        double fleetTime = -1.0;
        int fleet = 0;
        for (int i=0;i<position.length;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars,(a,b)->Integer.compare(b[0],a[0]));

        for (int i=0;i<cars.length;i++){
            int remainingDistance = target-cars[i][0];
            double time = (double) remainingDistance/(cars[i][1]);

            if (time>fleetTime){
                fleet++;
                fleetTime = time;
            }
        }

        return fleet;
    }
}
