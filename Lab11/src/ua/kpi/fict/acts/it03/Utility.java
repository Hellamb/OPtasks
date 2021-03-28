package ua.kpi.fict.acts.it03;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Utility {

    public void task1()
    {
        DoubleParamConstract<Test, String, Double> testConstructor = Test::new; //Ссылка на конструктор
        Test test1 = testConstructor.get("test1", 1.1);
        System.out.println(test1);
    }

    public void task2()
    {
        Consumer<String> writer = Test::staticMethod; //Ссылка на статический метод
        writer.accept("Hello from static");
    }

    public void task3()
    {
        Test test2 = new Test("test2", 2.2);
        Consumer<String> writer = test2::nonStaticMethod; //Ссылка на не статический метод объекта
        writer.accept("Hello from nonStatic");
    }

    public void task4()
    {
        Test test2 = new Test("test2", 2.2);
        UnaryOperator<String> writer = String::toLowerCase; //Ссылка на не статический метод конкретного типа
        System.out.println(writer.apply("HeLlO fRoM NoN StAtIc"));
    }
}
