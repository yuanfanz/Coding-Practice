class Solution {
    TrieNode root;
    public List<String> wordsAbbreviation(List<String> words) {
        root = new TrieNode();
        
        for (String word : words) {
            buildTrie(word);
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            result.add(getAbbr(word));
        }
        return result;
    }
    
    private String getAbbr(String s) {
        if (s.length() <= 3) return s;
        TrieNode cur = root.map.get(s.charAt(0));
        String prefix = s.length() + " " + s.charAt(s.length() - 1);
        for (int i = 1; i < s.length() - 2; ++i) {
            char ch = s.charAt(i);
            if (cur.freqMap.get(prefix) == 1) {
                return s.substring(0, i) + (s.length() - i - 1) + s.charAt(s.length() - 1);
            }
            cur = cur.map.get(ch);
        }
        return s;
    }
    
    private void buildTrie(String s) {
        TrieNode cur = root;
        String prefix = s.length() + " " + s.charAt(s.length() - 1);
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (!cur.map.containsKey(ch)) {
                cur.map.put(ch, new TrieNode(ch));
            }
            cur = cur.map.get(ch);
            cur.freqMap.put(prefix, cur.freqMap.getOrDefault(prefix, 0) + 1);
        }
    }
    
    class TrieNode{
        char ch;
        Map<Character, TrieNode> map;
        Map<String, Integer> freqMap;
        public TrieNode() {
            map = new HashMap<>();
        }
        public TrieNode(char ch) {
            this.ch = ch;
            map = new HashMap<>();
            freqMap = new HashMap<>();
        }
    }
}