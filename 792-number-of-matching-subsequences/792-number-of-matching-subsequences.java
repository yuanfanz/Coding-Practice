class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<Node>[] bucket = new ArrayList[26];
        
        for (int i = 0; i < 26; ++i) {
            bucket[i] = new ArrayList<>();
        }
        for (String word : words) {
            char ch = word.charAt(0);
            bucket[ch - 'a'].add(new Node(word, 0));
        }
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            List<Node> list = bucket[ch - 'a'];
            bucket[ch - 'a'] = new ArrayList<>();
            for (Node node : list) {
                node.index++;
                if (node.index == node.word.length()) {
                    count++;
                } else {
                    char next = node.word.charAt(node.index);
                    bucket[next - 'a'].add(node);
                }
            }
        }
        return count;
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