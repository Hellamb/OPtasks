package ua.kpi.fict.acts.it03;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        LinkedList<Enrollee> abitura = formAbitura(new LinkedList<>());
        University univer = formUniver(new University("KPI"));

        task1(abitura, 4);
        System.out.println("---");
        task2(univer);
        System.out.println("---");
        task3(abitura);


    }

    public static LinkedList<Enrollee> formAbitura(LinkedList<Enrollee> abitura){
        abitura.add(new Enrollee("Dvacatka",20));
        abitura.add(new Enrollee("Soroket",40));
        abitura.add(new Enrollee("FiveSeven",57));
        abitura.add(new Enrollee("Shistdesyatnik",60));
        abitura.add(new Enrollee("Itsmedio",65));
        abitura.add(new Enrollee("Trichetverti",75));
        abitura.add(new Enrollee("Vosmidesyatnik",80));
        abitura.add(new Enrollee("Bezpyati",95));
        abitura.add(new Enrollee("Sotnik",100));

        return abitura;
    }

    public static University formUniver(University univer){

        Faculty faculty1 = new Faculty("FICT");
        Faculty faculty2 = new Faculty("IASA");

        Student student1 = new Student("Vlad", "Kuksiuk",1234, 99);
        Student student2 = new Student("neVlad", "neKuksiuk",4321, 64);
        Student student3 = new Student("Ilia", "Kakoito",9876, 85);
        Student student4 = new Student("neIlia", "neKakoito",6789, 45);

        univer.getList().add(faculty1);
        univer.getList().add(faculty2);

        faculty1.getList().add(student1);
        faculty1.getList().add(student2);
        faculty2.getList().add(student3);
        faculty2.getList().add(student4);

        return univer;
    }

    public static void task1(LinkedList<Enrollee> list, int limit)
    {
        list.stream()
                .filter(x -> x.getScore() > 60)
                .sorted((x,y)-> -Integer.compare(x.getScore(),y.getScore()))
                .limit(limit)
                .sorted(Comparator.comparing(Enrollee::getName))
                .forEach(System.out::println);
    }

    public static void task3(LinkedList<Enrollee> list)
    {
        list.stream()
                .filter(x -> x.getScore()<=60)
                .sorted(Comparator.comparing(Enrollee::getName))
                .forEach(System.out::println);
    }

    public static void task2(University university)
    {
//        int[] sum = {0,0};
//        university.getList().forEach(x -> x.getList().stream()
//                .forEach( y -> sum[0]+= y.getScore())); //все баллы всех студентов
//
//        university.getList().stream()
//                .forEach(x-> sum[1] += x.getList().size()); //общее количество студентов
//
//        int middleScore = sum[0]/sum[1];

//        LinkedList<Student> topStudents = new LinkedList<>();
//        university.getList().forEach(x -> x.getList().stream()
//                        .filter(y -> y.getScore() > middleScore).forEach(topStudents::add));
//        topStudents.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);

        double middleScore = university.getList().stream()
                .flatMap(x -> x.getList().stream())
                .mapToInt(Student::getScore)
                .average()
                .getAsDouble();

        List<Student> topStudents;
        topStudents = university.getList().stream()
                .flatMap(x -> x.getList().stream())
                .filter(x -> x.getScore() > middleScore)
                .collect(Collectors.toList());

        topStudents.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);


    }
}
