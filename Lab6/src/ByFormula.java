public class ByFormula implements Task{
    @Override
    public void calc(int nMax) {
        long timeStart = System.currentTimeMillis();
        long res = (2 * 4 + (nMax - 1)*4)*nMax/2;
        System.out.println("Результат по формуле: " + res +
                " расчитан за " + (System.currentTimeMillis()-timeStart) + " мс"
        );
    }
}
