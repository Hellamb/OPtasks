public class ArithmeticThread extends Thread {
    int nMin;
    int nMax;
    long result;

    public ArithmeticThread(int nMin, int nMax){
        this.nMin = nMin;
        this.nMax = nMax;
    }

    @Override
    public void run() {
        long res=0;
        for(int i = nMin; i <= nMax; i++){
            res += 4*i;
        }
        result = res;
    }

    public long getResult() {
        return result;
    }
}
