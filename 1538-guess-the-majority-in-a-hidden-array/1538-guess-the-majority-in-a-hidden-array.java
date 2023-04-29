



class Solution {
    
    // query n times;
    public int guessMajority(ArrayReader reader) {
        int n = reader.length();
        int[] map = new int[n];   
        map[0] = 1;
        int a = reader.query(0,1,2,3);
        int e = reader.query(1,2,3,4); map[4] = a==e?1:2;
        int b = reader.query(0,2,3,4); map[1] = b==e?1:2;
        int c = reader.query(0,1,3,4); map[2] = b==c?map[1]:3-map[1];
        int d = reader.query(0,1,2,4); map[3] = c==d?map[2]:3-map[2];
        int count1 = 0, count2 = 0;
        int id1 = -1, id2 =-1;
        int res = -1;
        for(int i=0;i<5;i++) {
            if(map[i] == 1) {
                count1++; id1 = i;
            }
            else {
                count2 ++; id2= i;
            }
        }
        int last = e;
        for(int i=5;i<n;i++){
            int cur = reader.query(i-3,i-2,i-1,i);
            map[i] = cur == last? map[i-4]:(3-map[i-4]);
            last = cur;
            if(map[i] == 1) {
                count1++; id1 = i;
            }
            else {
                count2 ++; id2= i;
            }
        } 
        //System.out.println(Arrays.toString(map));
        if(count1 == count2) return -1;
        return count1 > count2? id1:id2;
    }
}