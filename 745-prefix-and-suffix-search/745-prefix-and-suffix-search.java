class WordFilter {
    private TrieNode root;
    private Map<String, Integer> indexMap;
    private int ans;
    public WordFilter(String[] words) {
        root = new TrieNode();
        indexMap = new HashMap<>();
        int index = 0;
        for (String word : words) {
            TrieNode cur = root;
            indexMap.put(word, index++);
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
        ans = -1;
        findSuffix(cur, suffix);
        return ans;
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
    
    private void findSuffix(TrieNode cur, String suffix) {
        if (cur.isWord) {
            int start = cur.word.length() - suffix.length();
            if (cur.word.substring(start).equals(suffix)) {
                int index = indexMap.get(cur.word);
                if (index > ans) {
                    ans = index;
                }
            }
        } else {
            for (char next : cur.map.keySet()) {
                findSuffix(cur.map.get(next), suffix);
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