import static java.lang.Math.*;

public class Equations {

    public static double parseParams(String toA, String toB, String toC, String toD, String equation)
    {
        double result;

        try
        {
            double a = Double.parseDouble(toA);
            double b = Double.parseDouble(toB);
            double c = Double.parseDouble(toC);
            double d = Double.parseDouble(toD);

            switch (equation)
            {
                case "1":
                    CalculationLogic calc1 = new CalculationLogic(new CalcMethod1());
                    result = calc1.calculate(a,b,c,d);
                    break;

                case "2":
                    CalculationLogic calc2 = new CalculationLogic(new CalcMethod2());
                    result = calc2.calculate(a,b,c,d);
                    break;

                case "3":
                    CalculationLogic calc3 = new CalculationLogic(new CalcMethod3());
                    result = calc3.calculate(a,b,c,d);
                    break;

                default:
                    throw new IllegalArgumentException("Bad equation!");
            }
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException("Wrong arguments!");
        }

        return result;

}}