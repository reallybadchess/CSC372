import java.util.ArrayList;
import java.util.Comparator;

class Student {
    int rollno;
    String name;
    String address;

    Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return rollno + " " + name + " " + address;
    }
}

class NameComparator implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}

class RollNoComparator implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.rollno - b.rollno;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(7, "Carl", "Floor 1"));
        list.add(new Student(3, "Donut", "Floor 1"));
        list.add(new Student(10, "Mordecai", "Floor 1"));
        list.add(new Student(1, "Katia", "Floor 3"));
        list.add(new Student(5, "Brandon", "Floor 2"));
        list.add(new Student(8, "Imani", "Floor 2"));
        list.add(new Student(2, "Elle", "Floor 2"));
        list.add(new Student(9, "Zev", "Floor 3"));
        list.add(new Student(4, "Lucia", "Floor 3"));
        list.add(new Student(6, "Prepotente", "Floor 3"));

        SelectionSort.sort(list, new NameComparator());
        System.out.println("By name:");
        for (Student s : list) System.out.println(s);

        SelectionSort.sort(list, new RollNoComparator());
        System.out.println("\nBy rollno:");
        for (Student s : list) System.out.println(s);
    }
}