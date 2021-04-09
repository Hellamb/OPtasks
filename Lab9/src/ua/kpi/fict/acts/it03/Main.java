package ua.kpi.fict.acts.it03;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        LinkedList<Test> listTest = formList();

        Comparator<Test> comp = (test1,test2) -> Double.compare(test1.getValue(),test2.getValue());
        Comparator<Test> comp2 = (a, b) -> (a.getName().compareTo(b.getName()));

        treeSetCheck(listTest, comp);
        treeSetCheck(listTest, comp.reversed());
        treeSetCheck(listTest, comp.thenComparing(comp2));
        treeSetCheck(listTest, Comparator.nullsFirst(comp));
        
    }

    public static LinkedList formList(){
        LinkedList<Test> list = new LinkedList<>();
        list.add(new Test("test1",1));
        list.add(new Test("test2", 2));
        list.add(new Test("test3",2));
        list.add(new Test("test4", 5));
        return list;
    }

    public static void treeSetCheck(LinkedList<Test> listTest,Comparator<Test> comp){
        TreeSet<Test> testSet = new TreeSet<>(comp);
        for(Test item:listTest){
            testSet.add(item);
        }
        System.out.println(testSet);
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
