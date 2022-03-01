class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> 
            nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> left = new TreeSet<>(comparator);
        TreeSet<Integer> right = new TreeSet<>(comparator);
        
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; ++i) {
            if (i - k >= 0) {
                if (!left.remove(i - k)) {
                    right.remove(i - k);
                }
            }
            balance(left, right);
            if (left.size() == 0 || nums[i] <= nums[left.last()]) {
                left.add(i);
            } else {
                right.add(i);
            }
            balance(left, right);
            if (i - k + 1 >= 0) {
                int leftSize = left.size();
                int rightSize = right.size();
                if (leftSize == rightSize) {
                    result[i - k + 1] = ((double) nums[right.first()] + nums[left.last()]) / 2;
                } else if (leftSize > rightSize) {
                    result[i - k + 1] = (double) nums[left.last()];
                } else {
                    result[i - k + 1] = (double) nums[right.first()];
                }
            }
        }
        return result;
    }
    private void balance(TreeSet<Integer> left, TreeSet<Integer> right) {
        while (Math.abs(left.size() - right.size()) > 1) {
            if (left.size() > right.size()) {
                right.add(left.pollLast());
            } else {
                left.add(right.pollFirst());
            }
        }
    }
}