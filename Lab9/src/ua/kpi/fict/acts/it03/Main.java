package ua.kpi.fict.acts.it03;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        test1();
        
    }

    public static void test1()
    {
        Test t1 = new Test("test1",1);
        Test t2 = new Test("test2", 2);
        Test t3 = new Test("test3",2);
        Test t4 = new Test("test4", 5);

        Comparator<Test> comp = (test1,test2) -> Double.compare(test1.getValue(),test2.getValue());
        Comparator<Test> comp2 = (a, b) -> (a.getName().compareTo(b.getName()));

        TreeSet<Test> testSet1 = new TreeSet<>(comp);
        testSet1.add(t4);
        testSet1.add(t3);
        testSet1.add(t2);
        testSet1.add(t1);
        System.out.println(testSet1);

        TreeSet<Test> testSet2 = new TreeSet<>(comp.reversed());
        testSet2.add(t4);
        testSet2.add(t3);
        testSet2.add(t2);
        testSet2.add(t1);
        System.out.println(testSet2);

        TreeSet<Test> testSet3 = new TreeSet<>(comp.thenComparing(comp2));
        testSet3.add(t4);
        testSet3.add(t3);
        testSet3.add(t2);
        testSet3.add(t1);
        System.out.println(testSet3);

        TreeSet<Test> testSet4 = new TreeSet<>(Comparator.nullsFirst(comp));
        testSet4.add(t4);
        testSet4.add(t3);
        testSet4.add(t2);
        testSet4.add(t1);
        testSet4.add(null);
        System.out.println(testSet4);



    }

    public static void task1()
    {
        Idrive drive = new Drive();
        Car m1 = new CarOnInternalCombustionEngine("mod1", 18.4,"red",20,1,drive);
        Car m2 = new CarOnInternalCombustionEngine("mod2", 20,"blue",20,1,drive);
        Car m3 = new CarOnInternalCombustionEngine("mod3", 20,"green",20,1,drive);
        Car m4 = new CarOnInternalCombustionEngine("mod4", 24,"orange",20,1,drive);

        System.out.println("<--Weight-->");

        Comparator<Car> comp = ( a, b) -> Double.compare(a.getWeight(),b.getWeight());
        TreeSet<Car> trSet = new TreeSet<>(comp);
        trSet.add(m1);
        trSet.add(m2);
        trSet.add(m3);
        trSet.add(m4);
        System.out.println(trSet);

        System.out.println("<--Reversed-Weight-->");

        TreeSet<Car> trSet2 = new TreeSet<>(comp.reversed());
        trSet2.add(m1);
        trSet2.add(m2);
        trSet2.add(m3);
        trSet2.add(m4);
        System.out.println(trSet2);

        System.out.println("<--Weight-Then-Color-->");

        Comparator<Car> comp2 = (a, b) -> (a.color.compareTo(b.color));

        TreeSet<Car> trSet3 = new TreeSet<>(comp.thenComparing(comp2));
        trSet3.add(m1);
        trSet3.add(m2);
        trSet3.add(m3);
        trSet3.add(m4);
        System.out.println(trSet3);

        System.out.println("<--Weight-And-nullsFirst-->");

        TreeSet<Car> trSet4 = new TreeSet<>(Comparator.nullsFirst(comp2));
        trSet4.add(m1);
        trSet4.add(m2);
        trSet4.add(m3);
        trSet4.add(m4);
        trSet4.add(null);
        System.out.println(trSet4);

    }
}
