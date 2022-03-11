class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> set = new HashSet<>();
        for (String cur : deadends) {
            set.add(cur);
        }
        int step = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int k = 0; k < size; ++k) {
                String str = queue.poll();
                if (set.contains(str)) continue;
                set.add(str);
                char[] arr = str.toCharArray();
                for (int i = 0; i < arr.length; ++i) {
                    char ch = arr[i];
                    char up = ch == '0' ? '9' : (char) (ch - 1);
                    char down = ch == '9' ? '0' : (char) (ch + 1);
                    arr[i] = up;
                    String upStr = String.valueOf(arr);
                    arr[i] = down;
                    String downStr = String.valueOf(arr);
                    if (target.equals(upStr) || target.equals(downStr)) {
                        return step;
                    }
                    queue.offer(upStr);
                    queue.offer(downStr);
                    arr[i] = ch;
                }
            }
            step++;
        }
        return -1;
    }
}