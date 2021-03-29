public class OneThread implements Task {
    @Override
    public void calc(int nMax) {
        ArithmeticThread thread = new ArithmeticThread(1, nMax);
        long timeStart = System.currentTimeMillis();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Результат однопоточности: " + thread.result +
                " расчитан за " + (System.currentTimeMillis()-timeStart) + " мс"
        );
    }
}
