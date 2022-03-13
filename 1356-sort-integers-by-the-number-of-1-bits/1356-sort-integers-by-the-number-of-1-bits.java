class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] input = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(input, (a, b) -> getBit(a) == getBit(b) ? 
                    a - b : getBit(a) - getBit(b));
        return Arrays.stream(input).mapToInt(Integer::intValue).toArray();
    }
    private int getBit(int a) {
        int count = 0;
        while (a > 0) {
            count += a & 1;
            a >>>= 1;
        }
        return count;
    }
}