public class ByFormula implements Task{
    @Override
    public void calc(int nMax) {
        long timeStart = System.currentTimeMillis();
        long res = (2 * 4 + (nMax - 1)*4L)*nMax/2;
        long time = System.currentTimeMillis()-timeStart;
        System.out.println("Результат по формуле: " + res +
                " расчитан за " + time + " мс"
        );
    }
}
