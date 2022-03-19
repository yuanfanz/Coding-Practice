class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] pos = new int[26];
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            pos[ch - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); ++i) {
            end = Math.max(end, pos[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(i + 1 - start);
                start = i + 1;
            }
        }
        return result;
    }
}