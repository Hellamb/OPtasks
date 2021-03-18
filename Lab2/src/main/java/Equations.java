import static java.lang.Math.*;

public class Equations {
    public static double template1(double a, double b, double c, double d)
    {
        return roundToPlaces((pow(a, b))/(sinh(abs(b))) + 4 * (log(c))/(pow(d, 0.25)), 4);
    }

    public static double template2(double a, double b, double c, double d)
    {
        return roundToPlaces((6 * pow(sin(abs(2*a)), log10(b))) + (sqrt(c*cosh(-d))), 4);
    }

    public static double template3(double a, double b, double c, double d)
    {
        return roundToPlaces((9 * asin(a)/cos(sqrt(abs(b)))) + (pow(2.43, d)) + (log(c)), 4);
    }

    private static double roundToPlaces(double number, int places)
    {
        return (double) round(number * pow(10, places)) / pow(10, places);
    }
}