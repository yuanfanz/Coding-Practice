class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int total = 0;
        
        for (int i = 0; i < bank.length; ++i) {
            String cur = bank[i];
            int curDevices = getNumberOfDevices(cur);
            if (curDevices == 0) {
                continue;
            }
            total += prev * curDevices;
            prev = curDevices;
        }
        return total;
    }
    private int getNumberOfDevices(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                total++;
            }
        }
        return total;
    }
}