class Solution {
    public double[] convertTemperature(double celsius) {
        double kel = celsius + 273.15;
        double fa = celsius * 1.80 + 32.00;
        return new double[]{kel, fa};
    }
}