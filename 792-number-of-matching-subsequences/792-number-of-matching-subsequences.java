class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList[] bucket = new ArrayList[26];
        
        for (int i = 0; i < 26; ++i) {
            bucket[i] = new ArrayList<>();
        }
        for (String cur : words) {
            char ch = cur.charAt(0);
            bucket[ch - 'a'].add(new Node(cur, 0));
        }
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            ArrayList<Node> list = bucket[ch - 'a'];
            bucket[ch - 'a'] = new ArrayList<>();
            for (Node node : list) {
                node.index += 1;
                if (node.index == node.word.length()) {
                    res++;
                } else {
                    bucket[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
        }
        return res;
    }
    
    class Node{
        String word;
        int index;
        public Node(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}