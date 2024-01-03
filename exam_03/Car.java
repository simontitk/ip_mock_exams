public class Car {

    private String plate;
    private int mileage;
    private int lastServiceMileage;
    private int tankCapacity;
    private int gasLevel;
    private float consumption;

    public Car(String plate, int tankCapacity, float consumption) {
        this.plate = plate;
        this.tankCapacity = tankCapacity;
        this.consumption = consumption;
        this.mileage = 0;
        this.lastServiceMileage = 0;
        this.gasLevel = 0;
    }


    public String getPlate() {
        return this.plate;
    }


    public int getTankCapacity() {
        return this.tankCapacity;
    }


    public int getGasLevel() {
        return this.gasLevel;
    }


    public int kmSinceService() {
        return this.mileage - this.lastServiceMileage;
    }


    public void fillTank(int gasAmount) {
        if (gasAmount + this.gasLevel > tankCapacity) {
            throw new GasOverFlowException();
        }
        this.gasLevel += gasAmount;
    }


    public void service() {
        this.lastServiceMileage = this.mileage;
    }


    public boolean needsService() {
        return this.lastServiceMileage > 30000;
    }


    public boolean drive(int d) {
        int gasRequired = Math.round(this.consumption * d);
        if (this.gasLevel >= gasRequired) {
            this.mileage += d;
            this.gasLevel -= gasRequired;
            return true;
        }
        return false;
    }

}
