package ua.kpi.fict.acts.it03;

@FunctionalInterface
public interface DoubleParamConstract<T,R,P> {
    public abstract T get(R aParam, P bParam);
}
