import javax.ws.rs.core.Request;
import java.util.HashMap;
import java.util.Map;

public class Equations {
    private double a;
    private double b;
    private double c;
    private double d;
    private int equation;
    private HashMap<Integer, ICalcMethod>  calcMethodMap = new HashMap<>();

    public Equations(Map<String, String[]> params)
    {
        try {
            this.a = Double.parseDouble(params.get("a")[0]);
            this.b = Double.parseDouble(params.get("b")[0]);
            this.c = Double.parseDouble(params.get("c")[0]);
            this.d = Double.parseDouble(params.get("d")[0]);
            this.equation = Integer.parseInt(params.get("equation")[0]);
        }catch (NumberFormatException e)
        {
            throw new IllegalArgumentException("Wrong arguments!");
        }
        this.calcMethodMap.put(1, new CalcMethod1());
        this.calcMethodMap.put(2, new CalcMethod2());
        this.calcMethodMap.put(3, new CalcMethod3());

    }
    public double calc()
    {
        ICalcMethod calcMethod;
        double result;
        try
        {
            calcMethod = calcMethodMap.get(equation);
            result = calcMethod.calc(a,b,c,d);
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException("Wrong arguments!");
        }

        return result;
    }
}