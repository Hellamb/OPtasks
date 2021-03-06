package ua.kpi.fict.acts.it03;

public class CarOnInternalCombustionEngine extends Car {

    protected double fuelAmount = 0;
    protected String model;
    protected double fuelTankVolume;
    protected double fuelPerKilometer;
    private Idrive driveMode;


    public CarOnInternalCombustionEngine(String model, double weight, String color, double fuelTankVolume, double fuelPerKilometer, Idrive driveMode)
    {
        super(weight,color);
        this.model = model;
        this.fuelTankVolume = fuelTankVolume;
        this.fuelPerKilometer = fuelPerKilometer;
        this.driveMode = driveMode;
    }

    @Override
    public String ignitionSound() {
        return "Wruhm-wruhm";
    }


    public void fillFuelTank()
    {
        fuelAmount = fuelTankVolume;
    }


    public void drive(double distance)
    {
        double[] result = driveMode.drive(distance, fuelAmount, fuelPerKilometer);
        System.out.println("Вы успешно проехали: "+ result[0]+ " км. Топлива осталось: " +result[1] +  " л.");
        mileage += result[0];
        fuelAmount = result[1];
    }


    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public double getFuelTankVolume()
    {
        return fuelTankVolume;
    }

    public void setFuelTankVolume(double fuelTankVolume)
    {
        this.fuelTankVolume = fuelTankVolume;
        this.fuelAmount = 0;
    }

    public double getFuelAmount()
    {
        return fuelAmount;
    }

    public double getFuelPerKilometer()
    {
        return fuelPerKilometer;
    }

    public void setFuelPerKilometer(double fuelPerKilometer)
    {
        this.fuelPerKilometer = fuelPerKilometer;
    }

    public void setDriveMode(Idrive driveMode)
    {
        this.driveMode = driveMode;
    }

    @Override
    public String toString()
    {
        return "Car(" +"model= " + model + ", weight= " + weight + ", color= " + color  + ", fuel= " + fuelAmount +'/' + fuelTankVolume + ", mileage= "+ mileage + ", fuelPerKilometer = "+ fuelPerKilometer +')';
    }
    @Override
    public boolean equals(Object o)
    {
        if( o == this) return true;
        if(!(o instanceof CarOnInternalCombustionEngine)) return false;
        CarOnInternalCombustionEngine other = (CarOnInternalCombustionEngine) o;
        if(this.fuelAmount == other.getFuelAmount() &&
                this.mileage == other.getMileage() &&
                this.model == other.getModel() &&
                this.fuelTankVolume == other.getFuelTankVolume() &&
                this.fuelPerKilometer == other.getFuelPerKilometer() &&
                this.weight == other.getWeight() &&
                this.color == other.getColor()) return true;
        else return false;
    }
}