class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) {
                count++;
                continue;
            }
            angles.add(getAngle(dx, dy));
        }
        // sort angle list, get a continuous list of points
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        // add points after the list to make it continuous
        // handle the corner case
        for (double d : angles) {
            tmp.add(d + 360);
        }
        int res = count;
        int i = 0;
        for (int j = 0; j < tmp.size(); ++j) {
            while (i < tmp.size() && tmp.get(j) - tmp.get(i) > angle) {
                i++;
            }
            if (tmp.get(j) - tmp.get(i) <= angle) {
                res = Math.max(res, j - i + 1 + count);
            }
        }
        return res;
    }
    
    private double getAngle(int dx, int dy) {
        return Math.atan2(dy, dx) * (180 / Math.PI);
    }
}












