class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!cur.map.containsKey(ch)) {
                cur.map.put(ch, new TrieNode(ch));
            }
            cur = cur.map.get(ch);
            if (i == word.length() - 1) {
                cur.isWord = true;
            }
        }
    }
    
    public boolean search(String word) {
        return dfs(root, 0, word);
    }
    
    private boolean dfs(TrieNode cur, int i, String word) {
        if (i == word.length()) {
            return cur.isWord;
        }
        char ch = word.charAt(i);
        if (ch != '.') {
            if (!cur.map.containsKey(ch)) {
                return false;
            }
            return dfs(cur.map.get(ch), i + 1, word);
        } else {
            for (char next : cur.map.keySet()) {
                if (dfs(cur.map.get(next), i + 1, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    class TrieNode{
        char ch;
        Map<Character, TrieNode> map;
        boolean isWord;
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
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */