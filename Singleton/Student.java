public class Student {
    public int rollno;
    public String name;

    public String toString() {
        return "Student: [rollno: " + this.rollno + ", name: " + this.name + "]";
    }

    private static Student instance;

    private Student() {}

    public static Student getInstance() {
        if(instance == null) {
            instance = new Student();   
        }
        return instance;
    }

}