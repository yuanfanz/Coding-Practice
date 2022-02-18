class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        
        for (int i = 0; i < s.length(); ++i) {
            map[s.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int index = map[ch - 'a'];
            max = Math.max(max, index);
            if (i == max) {
                list.add(i - start + 1);
                start = i + 1;
            }
        }
        return list;
    }
}