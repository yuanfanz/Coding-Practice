class Solution {
    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); ++i) {
            int ch = num.charAt(i) - '0';
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < num.length(); ++i) {
            int ch = num.charAt(i) - '0';
            if (!map.containsKey(i)) {
                if (ch == 0) continue;
                else return false;
            }
            if (map.get(i) != ch) {
                return false;
            }
        } 
        return true;
    }
}