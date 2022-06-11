class Solution {
    public int maxDistance(int[] colors) {
        int i = 0;
        int j = colors.length - 1;
        int max = 0;
        while (i < j) {
            if (colors[i] != colors[j]) {
                max = Math.max(max, j - i);
                break;
            }
            j--;
        }
        i = 0;
        j = colors.length - 1;
        while (i < j) {
            if (colors[i] != colors[j]) {
                max = Math.max(max, j - i);
                break;
            }
            i++;
        }
        return max;
    }
}