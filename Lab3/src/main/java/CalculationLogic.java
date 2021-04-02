public class CalculationLogic {
    ICalc calcMethod;
    public CalculationLogic(ICalc calcMethod)
    {
        this.calcMethod = calcMethod;
    }

    public double calculate(double a, double b,double c, double d)
    {
        return calcMethod.calc(a,b,c,d);
    }
}
