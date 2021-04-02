import static java.lang.Math.*;

public class CalcMethod1 implements ICalc{

    @Override
    public double calc(double a, double b, double c, double d) {
        return (pow(a, b))/(sinh(abs(b))) + 4 * (log(c))/(pow(d, 0.25));
    }
}
