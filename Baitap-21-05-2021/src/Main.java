import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageStudent manageStudent = new ManageStudent();
        Scanner scanner = new Scanner(System.in);
        manageStudent.addStudent(new Student("Hihi", 12, "Đực", "HN"));
        manageStudent.addStudent(new Student("Huhu", 15, "Cái", "TPHCM"));
        manageStudent.addStudent(new Student("Haha", 13, "Đực", "ĐN"));
        manageStudent.addStudent(new Student("Hehe", 20, "Cái", "HN"));
        manageStudent.addStudent(new Student("Hihe", 20, "Đực", "NĐ"));
        manageStudent.addStudent(new Student("Hahe", 20, "Đực", "HN"));
        manageStudent.addStudent(new Student("Hohe", 20, "Đực", "HN"));

        manageStudent.start();

    }

}
