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
                    result = Equations.template1(a, b, c, d);
                    break;

                case "2":
                    result = Equations.template2(a, b, c, d);
                    break;

                case "3":
                    result = Equations.template3(a, b, c, d);
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
    }
    private static double template1(double a, double b, double c, double d)
    {
        return roundToPlaces((pow(a, b))/(sinh(abs(b))) + 4 * (log(c))/(pow(d, 0.25)), 4);
    }

    private static double template2(double a, double b, double c, double d)
    {
        return roundToPlaces((6 * pow(sin(abs(2*a)), log10(b))) + (sqrt(c*cosh(-d))), 4);
    }

    private static double template3(double a, double b, double c, double d)
    {
        return roundToPlaces((9 * asin(a)/cos(sqrt(abs(b)))) + (pow(2.43, d)) + (log(c)), 4);
    }

    private static double roundToPlaces(double number, int places)
    {
        return (double) round(number * pow(10, places)) / pow(10, places);
    }
}