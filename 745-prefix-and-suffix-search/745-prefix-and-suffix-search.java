class WordFilter {
    TrieNode root;
    Map<String, Integer> map;
    private int res = -1;
    public WordFilter(String[] words) {
        root = new TrieNode();
        map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            String s = words[i];
            map.put(s, i);
            TrieNode cur = root;
            for (int j = 0; j < s.length(); ++j) {
                char ch = s.charAt(j);
                if (!cur.map.containsKey(ch)) {
                    cur.map.put(ch, new TrieNode(ch));
                }
                cur = cur.map.get(ch);
                if (j == s.length() - 1) {
                    cur.isWord = true;
                    cur.word = s;
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode cur = findPrefix(prefix);
        if (cur == null) {
            return -1;
        }
        res = -1;
        findSuffix(cur, suffix);
        return res;
    }
    
    private void findSuffix(TrieNode cur, String s) {
        if (cur.isWord) {
            int start = cur.word.length() - s.length();
            if (cur.word.substring(start).equals(s)) {
                int index = map.get(cur.word);
                if (index > res) {
                    res = index;
                }
            }
        } else {
            for (char ch : cur.map.keySet()) {
                findSuffix(cur.map.get(ch), s);
            }
        }
    }
    
    private TrieNode findPrefix(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (!cur.map.containsKey(ch)) {
                return null;
            }
            cur = cur.map.get(ch);
        }
        return cur;
    }
    
    class TrieNode{
        char ch;
        Map<Character, TrieNode> map;
        boolean isWord;
        String word;
        public TrieNode() {
            map = new HashMap<>();
        }
        public TrieNode(char ch) {
            this.ch = ch;
            map = new HashMap<>();
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */