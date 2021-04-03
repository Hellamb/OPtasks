import static java.lang.Math.*;

public class CalcMethod2 implements ICalcMethod {

    @Override
    public double calc(double a, double b, double c, double d) {
        return (6 * pow(sin(abs(2*a)), log10(b))) + (sqrt(c*cosh(-d)));
    }
}
