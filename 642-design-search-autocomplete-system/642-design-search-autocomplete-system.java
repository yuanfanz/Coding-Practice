class AutocompleteSystem {
    TrieNode root;
    String prefix;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; ++i) {
            add(sentences[i], times[i]);
        }
    }
    
    private void add(String s, int count) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (!cur.map.containsKey(ch)) {
                cur.map.put(ch, new TrieNode(ch));
            }
            cur = cur.map.get(ch);
            cur.countMap.put(s, cur.countMap.getOrDefault(s, 0) + count);
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix = prefix + c;
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            if (!cur.map.containsKey(ch)) {
                return new ArrayList<>();
            }
            cur = cur.map.get(ch);
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>
            ((a, b) -> a.count == b.count ? a.sentence.compareTo(b.sentence) : b.count - a.count);
        for (String s : cur.countMap.keySet()) {
            pq.offer(new Tuple(s, cur.countMap.get(s)));
        }
        int k = 3;
        List<String> result = new ArrayList<>();
        while (pq.size() != 0 && k > 0) {
            result.add(pq.poll().sentence);
            k--;
        }
        return result;
    }
    
    class Tuple{
        String sentence;
        int count;
        public Tuple(String sentence, int count) {
            this.sentence = sentence;
            this.count = count;
        }
    }
    
    class TrieNode{
        char ch;
        Map<Character, TrieNode> map;
        Map<String, Integer> countMap;
        public TrieNode() {
            map = new HashMap<>();
        }
        public TrieNode(char ch) {
            this.ch = ch;
            map = new HashMap<>();
            countMap = new HashMap<>();
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */