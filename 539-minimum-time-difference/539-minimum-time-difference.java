class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] time = new int[n];
        
        for (int i = 0; i < n; ++i) {
            time[i] = getTime(timePoints.get(i));
        }
        Arrays.sort(time);
        int min = 24 * 60;
        for (int i = 1; i < time.length; ++i) {
            min = Math.min(min, Math.abs(time[i] - time[i - 1]));
            // System.out.println(min);
        }
        return Math.min(min, Math.abs(time[0] + 24 * 60 - time[time.length - 1]));
    }
    
    private int getTime(String s) {
        String[] arr = s.split(":");
        return Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
    }
}