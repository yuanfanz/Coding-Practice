class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        
        final int[] mutation = new int[]{0, 2, 6, 19};
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        if (!set.contains(end)) return -1;
        set.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                String str = queue.poll();
                if (str.equals(end)) {
                    return step;
                }
                if (!set.contains(str) || visited.contains(str)) continue;
                visited.add(str);
                char[] arr = str.toCharArray();
                for (int i = 0; i < arr.length; ++i) {
                    char ch = arr[i];
                    // System.out.println(ch);
                    for (int next : mutation) {
                        if (ch - 'A' == next) continue;
                        arr[i] = (char) (next + 'A');
                        String nextStr = String.valueOf(arr);
                        // System.out.println(nextStr);
                        queue.offer(nextStr);
                    }
                    arr[i] = ch;
                }
            }
            step++;
        }
        return -1;
    }
}