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
        return helper(root, word, 0);
    }
    
    private boolean helper(TrieNode cur, String word, int index) {
        if (index == word.length()) {
            return cur.isWord;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (char next : cur.map.keySet()) {
                if (helper(cur.map.get(next), word, index + 1)) return true;
            }
        } else {
            if (cur.map.containsKey(ch)) {
                return helper(cur.map.get(ch), word, index + 1);
            } else {
                return false;
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