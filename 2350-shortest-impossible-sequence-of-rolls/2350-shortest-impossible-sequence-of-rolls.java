class Solution {
    public int shortestSequence(int[] rolls, int k) {
        Set<Integer> set = new HashSet<>();
        
        int count = 1;
        for (int i : rolls) {
            set.add(i);
            if (set.size() == k) {
                set = new HashSet<>();
                count++;
            }
        }
        return count;
    }
}