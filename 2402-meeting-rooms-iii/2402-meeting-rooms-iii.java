class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Room> available = new PriorityQueue<>((a, b) -> a.id - b.id);
        PriorityQueue<Room> ongoing = new PriorityQueue<>
            ((a, b) -> a.end == b.end ? a.id - b.id : a.end - b.end);
        
        for (int i = 0; i < n; ++i) {
            available.offer(new Room(i));
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        
        for (int[] cur : meetings) {
            int start = cur[0];
            int end = cur[1];
            // first, release rooms for meetings closed at this time
            while (ongoing.size() > 0 && ongoing.peek().end <= start) {
                Room next = ongoing.poll();
                available.offer(next);
            }
            if (available.size() > 0) {
                Room newRoom = available.poll();
                newRoom.end = end;
                newRoom.count = newRoom.count + 1;
                ongoing.offer(newRoom);
            } else {
                Room nextRoom = ongoing.poll();
                int newEnd = nextRoom.end;
                nextRoom.count = nextRoom.count + 1;
                nextRoom.end = newEnd + end - start;
                ongoing.offer(nextRoom);
            }
        }
        while (ongoing.size() > 0) {
            Room next = ongoing.poll();
            available.offer(next);
        }
        int max = 0;
        int res = 0;
        while (available.size() > 0) {
            Room cur = available.poll();
            // System.out.print(cur.count + " ");
            if (max < cur.count) {
                max = cur.count;
                res = cur.id;
            }
        }
        return res;
    }
    
    class Room{
        int id;
        int start;
        int end;
        int count;
        public Room(int id) {
            this.id = id;
            this.count = 0;
        }
    }
}