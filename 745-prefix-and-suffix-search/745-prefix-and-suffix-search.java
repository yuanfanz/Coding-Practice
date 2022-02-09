class WordFilter {
    private TrieNode root;
    private Map<String, Integer> map;
    private int res;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        root = new TrieNode();
        int index = 0;
        for (String word : words) {
            map.put(word, index++);
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!cur.map.containsKey(ch)) {
                    cur.map.put(ch, new TrieNode(ch));
                }
                cur = cur.map.get(ch);
                if (i == word.length() - 1) {
                    cur.isWord = true;
                    cur.word = word;
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode cur = findPre(prefix);
        if (cur == null) {
            return -1;
        }
        res = -1;
        findSuf(cur, suffix, suffix.length());
        return res;
    }
    
    private TrieNode findPre(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            if (!cur.map.containsKey(ch)) {
                return null;
            }
            cur = cur.map.get(ch);
        }
        return cur;
    }
    
    private void findSuf(TrieNode cur, String suffix, int len) {
        if (cur.isWord) {
            int start = cur.word.length() - len;
            if (cur.word.substring(start).equals(suffix)) {
                int index = map.get(cur.word);
                if (index > res) {
                    res = index;
                }
            }
        } else {
            for (char next : cur.map.keySet()) {
                findSuf(cur.map.get(next), suffix, len);
            }
        }
    }
    
    class TrieNode{
        char ch;
        Map<Character, TrieNode> map;
        boolean isWord;
        String word;
        public TrieNode() {
            map = new HashMap<>();
            isWord = false;
        }
        public TrieNode(char ch) {
            this.ch = ch;
            map = new HashMap<>();
            isWord = false;
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */