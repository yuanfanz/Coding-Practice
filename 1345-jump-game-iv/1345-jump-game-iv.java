class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; ++i) {
            Set<Integer> set = map.getOrDefault(arr[i], new HashSet<>());
            set.add(i);
            map.put(arr[i], set);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int index = queue.poll();
                if (index == arr.length - 1) return level;
                if (index + 1 < arr.length && map.containsKey(arr[index + 1])) {
                    queue.offer(index + 1);
                }
                if (index - 1 >= 0 && map.containsKey(arr[index - 1])) {
                    queue.offer(index - 1);
                }
                if (map.containsKey(arr[index])) {
                    for (int next : map.get(arr[index])) {
                        if (next == index) continue;
                        queue.offer(next);
                    }
                }
                map.remove(arr[index]);
            }
            level++;
        }
        return -1;
    }
}