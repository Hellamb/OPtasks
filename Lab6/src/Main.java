public class Main {
    public static void main(String[] args) {
        ByFormula test1 = new ByFormula();
        test1.calc(10000);

        OneThread test2 = new OneThread();
        test2.calc(10000);

        MultiThreads test3 = new MultiThreads();
        test3.calc(10000);

    }

}
