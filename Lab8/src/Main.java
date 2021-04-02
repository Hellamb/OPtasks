import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Pills[] arr = new Pills[10];
        arr[0] = new Pills("Вітаміни",100);
        arr[1] = new Pills("Аспірін",50);
        arr[2] = new Pills("Аспірін",50);
        arr[3] = new Pills("Карвалол",150);
        arr[4] = new Pills("Ергоферон",60);
        arr[5] = new Pills("Но-шпа",40);
        arr[6] = new Pills("Карвалол",145);
        arr[7] = new Pills("Панкреатин",55);
        arr[8] = new Pills("Но-шпа",35);
        arr[9] = new Pills("Аспірін",45);

        System.out.println("-------------Comparator 1 (inner static)-----------------");
        ComparatorForPills comp1 = new ComparatorForPills();
        Arrays.sort(arr, comp1);
        for (Pills item:arr){
            System.out.println(item.getName() + " " + item.getPrice());
        }

        System.out.println("-------------Comparator 2 (anonymous)-----------------");
        ComparatorForPills2 comp2 = new ComparatorForPills2(){
            @Override
            public int compare(Pills p1, Pills p2) {
                if (p1.getPrice() > p2.getPrice())
                    return 1;
                else if (p1.getPrice() == p2.getPrice())
                    return 0;
                else
                    return -1;
            }
        };

        Arrays.sort(arr, comp2);
        for (Pills item:arr){
            System.out.println(item.getName() + " " + item.getPrice());
        }

        System.out.println("-------------Comparator 1 (Treeset)-----------------");
        TreeSet<Pills> treeset1 = new TreeSet<Pills>(comp1);
        treeset1.addAll(Arrays.asList(arr));
        for (Pills item:treeset1){
            System.out.println(item.getName() + " " + item.getPrice());
        }

        System.out.println("-------------Comparator 2 (Treeset)-----------------");
        TreeSet<Pills> treeset2 = new TreeSet<Pills>(comp2);
        for (Pills item:arr){
            treeset2.add(item);
        }
        for (Pills item:treeset2){
            System.out.println(item.getName() + " " + item.getPrice());
        }
    }

    public static class ComparatorForPills implements Comparator<Pills> {
        @Override
        public int compare(Pills p1, Pills p2) {
            if(p1.getName() != null && p2.getName() != null && p1.getName().compareTo(p2.getName()) != 0) {
                return p1.getName().compareTo(p2.getName());
            } else {
                if (p1.getPrice() > p2.getPrice())
                    return 1;
                else if (p1.getPrice() == p2.getPrice())
                    return 0;
                else
                    return -1;
            }
        }
    }

    private static abstract class ComparatorForPills2 implements Comparator<Pills> {
        public abstract int compare(Pills p1, Pills p2);
    }
}

