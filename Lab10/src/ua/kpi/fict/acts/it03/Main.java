package ua.kpi.fict.acts.it03;

import java.lang.Math;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ILambda lambda = (a, b, c, d) -> Math.pow(a,b)/(Math.sinh(Math.abs(b)))+4*Math.log(c)/Math.pow(d,0.25);
        System.out.println("---Task1---");
        task1(1,1,1,1,lambda);

        System.out.println("---Task2---");
        task2();
    }

    public static void task1(double a, double b, double c, double d, ILambda lambda)
    {
        double result = lambda.calc(a,b,c,d);
        System.out.println("result= " + result);
    }

    public static void task2()
    {
        LinkedList<Test> llist = new LinkedList<>();
        Test t1 = new Test("test1", 1);
        Test t2 = new Test("test2", 2);
        Test t3 = new Test("test3", 3);
        Test t4 = new Test("test4", 4);

        llist.add(t4);
        llist.add(t3);
        llist.add(t2);
        llist.add(t1);

        llist.forEach(iterator-> System.out.println(iterator));
    }


}
