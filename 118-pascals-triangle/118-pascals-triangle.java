class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        result.add(new ArrayList<>(Arrays.asList(1)));
        for (int i = 1; i < numRows; ++i) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; ++j) {
                List<Integer> prev = result.get(i - 1);
                int sum = prev.get(j - 1) + prev.get(j);
                list.add(sum);
            }
            list.add(1);
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}