class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < keyboard.length(); ++i) {
            char ch = keyboard.charAt(i);
            map.put(ch, i);
        }
        
        int cur = 0;
        int sum = 0;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            int next = map.get(ch);
            int diff = Math.abs(cur - next);
            cur = next;
            sum += diff;
        }
        return sum;
    }
}