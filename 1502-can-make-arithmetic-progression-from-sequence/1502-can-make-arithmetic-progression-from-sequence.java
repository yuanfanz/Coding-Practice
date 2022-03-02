class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int diff = max - min;
        if (diff % (arr.length - 1) != 0) return false;
        int gap = diff / (arr.length - 1);
        int n = arr.length;
        while (--n > 0) {
            min += gap;
            if (!set.contains(min)) {
                return false;
            }
        }
        return true;
    }
}