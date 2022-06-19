class Solution {
    TrieNode root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new TrieNode();
        
        buildTrie(products);
        
        StringBuilder sb = new StringBuilder();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); ++i) {
            sb.append(searchWord.charAt(i));
            List<String> list = search(sb.toString());
            result.add(list);
        }
        return result;
    }
    
    public List<String> search(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (!cur.map.containsKey(ch)) {
                return new ArrayList<>();
            }
            cur = cur.map.get(ch);
        }
        List<String> curList = cur.list;
        Collections.sort(curList);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3 && i < curList.size(); ++i) {
            result.add(curList.get(i));
        }
        return result;
    }
    
    public void buildTrie(String[] products) {
        for (String s : products) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (!cur.map.containsKey(ch)) {
                    cur.map.put(ch, new TrieNode(ch));
                }
                cur = cur.map.get(ch);
                cur.list.add(s);
            }
        }
    }
    
    class TrieNode{
        char ch;
        Map<Character, TrieNode> map;
        List<String> list;
        public TrieNode(){
            map = new HashMap<>();
        }
        public TrieNode(char ch) {
            this.ch = ch;
            map = new HashMap<>();
            list = new ArrayList<>();
        }
    }
}