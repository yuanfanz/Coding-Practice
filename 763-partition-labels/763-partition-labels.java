class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int index = pos[ch - 'a'];
            max = Math.max(max, index);
            if (max == i) {
                result.add(i + 1 - start);
                start = i + 1;
            }
        }
        return result;
    }
}