// use double for calculating time, as 1.33 and 1 is not same, if int is taken  both  will be 1 which will return a wrong answer.

import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Each car: [pos, time]
        List<double[]> carDetails = new ArrayList<>();
        
        for (int i = 0; i < position.length; i++) {
            double time = (double)(target - position[i]) / speed[i];
            carDetails.add(new double[]{position[i], time});
        }
        
        // Sort cars by position descending (closer to target first)
        carDetails.sort((a, b) -> Double.compare(b[0], a[0]));
        
        int fleets = 0;
        double curMaxTime = 0;
        
        for (double[] car : carDetails) {
            double time = car[1];
            if (time > curMaxTime) {
                fleets++;
                curMaxTime = time;  // new fleet formed
            }
        }
        
        return fleets;
    }
}
