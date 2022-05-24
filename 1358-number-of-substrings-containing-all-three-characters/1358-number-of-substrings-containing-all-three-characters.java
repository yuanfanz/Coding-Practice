class Solution {
    public int numberOfSubstrings(String s) {
        return getSubArr(s, 3) - getSubArr(s, 2);
    }
    
    private int getSubArr(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        
        int n = s.length();
        int count = 0;
        for (int j = 0; j < n; ++j) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (i < n && map.size() > k) {
                int val = map.get(s.charAt(i));
                val--;
                if (val == 0) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), val);
                }
                i++;
            }
            if (map.size() <= k) {
                count += j - i + 1;
            }
        }
        return count;
    }
}