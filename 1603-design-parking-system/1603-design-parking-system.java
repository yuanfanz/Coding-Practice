class ParkingSystem {
    private int big;
    private int medium;
    private int small;
    private int bigCur;
    private int mediumCur;
    private int smallCur;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if (carType == 1) {
            return ++bigCur <= big;
        } else if (carType == 2) {
            return ++mediumCur <= medium;
        } else {
            return ++ smallCur <= small;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */