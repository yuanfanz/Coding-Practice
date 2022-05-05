class Solution {
    public int countPoints(String rings) {
        int[] rod = new int[10];
        for (int i = 0; i < rings.length(); i += 2){
            char ch = rings.charAt(i);
            int pos = rings.charAt(i + 1) - '0';
            int val = ch == 'R' ? 1 : ch == 'G' ? 2 : 4;
            rod[pos] = rod[pos] | val;
        }
        int count = 0;
        for (int i : rod) {
            if (i == 7) {
                count++;
            }
        }
        return count;
    }
}