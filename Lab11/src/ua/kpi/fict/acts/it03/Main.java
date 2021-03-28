package ua.kpi.fict.acts.it03;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
        Utility tasks = new Utility();

        tasks.task1(); //Ссылка на конструктор
        tasks.task2(); //Ссылка на статический метод
        tasks.task3(); //Ссылка на не статический метод объекта
        tasks.task4(); //Ссылка на не статический метод конкретного типа


    }

}
