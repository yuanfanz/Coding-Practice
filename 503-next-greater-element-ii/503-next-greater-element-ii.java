class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n * 2];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = nums[i % n];
        }
        int[] result = new int[n * 2];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; ++i) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (stack.size() > 0 && arr[i] > arr[stack.peek()]) {
                    int index = stack.pop();
                    result[index] = arr[i];
                }
                stack.push(i);
            }
        }
        return Arrays.copyOfRange(result, 0, n);
    }
}