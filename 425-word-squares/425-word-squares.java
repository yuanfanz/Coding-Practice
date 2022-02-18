class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        TrieNode root = new TrieNode();
        buildTrie(words, root);
        int len = words[0].length();
        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
            dfs(result, list, root, len);
            list.remove(list.size() - 1);
        }
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> list, TrieNode root, int len) {
        if (len == list.size()) {
            // there is enough words to form a square
            result.add(new ArrayList<>(list));
            return;
        }
        // find the prefix we need based on strings in list
        int index = list.size();
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s.charAt(index));
        }
        String prefix = sb.toString();
        List<String> startsWithList = findByPrefix(prefix, root);
        for (String sw : startsWithList) {
            list.add(sw);
            dfs(result, list, root, len);
            list.remove(list.size() - 1);
        }
    }
    
    private List<String> findByPrefix(String prefix, TrieNode root) {
        List<String> result = new ArrayList<>();
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            if (!cur.map.containsKey(ch)) {
                return result;
            }
            cur = cur.map.get(ch);
        }
        result.addAll(cur.startsWith);
        return result;
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