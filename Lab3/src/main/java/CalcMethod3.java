import static java.lang.Math.*;
import static java.lang.Math.log;

public class CalcMethod3 implements ICalc{
    @Override
    public double calc(double a, double b, double c, double d) {
        return (9 * asin(a)/cos(sqrt(abs(b)))) + (pow(2.43, d)) + (log(c));
    }
}
