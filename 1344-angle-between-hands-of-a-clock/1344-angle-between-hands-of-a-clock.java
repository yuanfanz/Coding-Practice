class Solution {
    public double angleClock(int hour, int minutes) {
        double total = 360.0;
        
        if (hour == 12) hour = 0;
        
        double hourAngle = hour * 30.0 + minutes * 0.5;
        double minuteAngle = minutes / 60.0 * 360.0;
        
        // System.out.println();
        // System.out.println();
        
        double diff = Math.abs(minuteAngle - hourAngle);
        if (diff > 180) {
            diff = total - diff;
        }
        return diff;
    }
}