class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        Set<Integer> set = new HashSet<>();
        for (int i : passengers) {
            set.add(i);
        }
        
        int i = 0;
        int j = 0;
        
        while (i < buses.length) {
            int curBusLeave = buses[i];
            int cap = capacity;
            int last = -1;
            while (j < passengers.length && cap > 0) {
                if (passengers[j] <= curBusLeave) {
                    last = j;
                    j++;
                    cap--;
                } else {
                    break;
                }
            }
            // System.out.println(first);
            // System.out.println(second);
            if (i == buses.length - 1) {
                if (cap == 0) {
                    if (last == -1) {
                        int t1 = buses[i];
                        while (set.contains(t1)) {
                            t1--;
                        }
                        return t1;
                    } else {
                        int t1 = passengers[last] - 1;
                        while (set.contains(t1)) {
                            t1--;
                        }
                        return t1;
                    }
                } else {
                    int t1 = buses[i];
                    while (set.contains(t1)) {
                        t1--;
                    }
                    return t1;
                }
            }
            i++;
        }
        return -1;
    }
}