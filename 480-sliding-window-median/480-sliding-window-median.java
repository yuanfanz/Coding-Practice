class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> 
            nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> left = new TreeSet<>(comparator);
        TreeSet<Integer> right = new TreeSet<>(comparator);
        
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; ++i) {
            if (i - k + 1 > 0) {
                int indexToBeRemoved = i - k;
                if (!left.remove(indexToBeRemoved)) {
                    right.remove(indexToBeRemoved);
                }
                balance(left, right);
            }
            if (left.size() == 0 || nums[left.last()] >= nums[i]) {
                left.add(i);
            } else {
                right.add(i);
            }
            balance(left, right);
            if (i - k + 1 >= 0) {
                if (left.size() == right.size()) {
                    result[i - k + 1] = ((double) nums[left.last()]
                                         + nums[right.first()]) / 2;
                } else if (left.size() > right.size()) {
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