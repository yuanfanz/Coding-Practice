class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        
        TrieNode root = new TrieNode();
        buildTrie(words, root);
        
        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
            dfs(result, list, root, word.length());
            list.remove(list.size() - 1);
        }
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> list, TrieNode root, int len) {
        if (len == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        StringBuilder sb = new StringBuilder();
        int index = list.size();
        for (String s : list) {
            sb.append(s.charAt(index));
        }
        List<String> startsWith = find(sb.toString(), root);
        for (int i = 0; i < startsWith.size(); ++i) {
            list.add(startsWith.get(i));
            dfs(result, list, root, len);
            list.remove(list.size() - 1);
        }
        
    }
    
    private List<String> find(String prefix, TrieNode root) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            if (!cur.map.containsKey(ch)) {
                return new ArrayList<>();
            }
            cur = cur.map.get(ch);
        }
        return cur.startsWith;
    }
    
    private void buildTrie(String[] words, TrieNode root) {
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!cur.map.containsKey(ch)) {
                    cur.map.put(ch, new TrieNode(ch));
                }
                cur = cur.map.get(ch);
                cur.startsWith.add(word);
            }
        }
    }
    
    class TrieNode{
        char ch;
        Map<Character, TrieNode> map;
        List<String> startsWith;
        public TrieNode() {
            map = new HashMap<>();
        }
        public TrieNode(char ch) {
            this.ch = ch;
            map = new HashMap<>();
            startsWith = new ArrayList<>();
        }
    }
}