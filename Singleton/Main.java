public class Main {
    public static void main(String[] args) {
        Student student1 = Student.getInstance();
        student1.name = "Priyanshu Gupta";
        student1.rollno = 1;
        System.out.println(student1.toString());

        Student student2 = Student.getInstance();
        System.out.println(student2.toString());
    }
}   