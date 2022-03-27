class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int i = 0; i < bills.length; ++i) {
            int cur = bills[i];
            if (cur == 5) {
                count5++;
            } else if (cur == 10) {
                if (count5 == 0) return false;
                count5--;
                count10++;
            } else {
                if (count10 == 0 && count5 < 3) return false;
                if (count5 < 1) return false;
                if (count10 > 0) {
                    count10--;
                    count5--;
                } else {
                    count5 -= 3;
                }
            }
        }
        return true;
    }
}