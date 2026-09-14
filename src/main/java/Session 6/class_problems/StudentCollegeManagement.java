class Student {

    // Instance variables
    String name;
    double attendance;


    // Static variables
    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;


    // Constructor
    Student(
            String name,
            double attendance) {

        this.name = name;

        this.attendance = attendance;

        // Increase count whenever object is created
        studentCount++;
    }


    // Static method
    static void printCollegeInfo() {

        System.out.println(
            collegeName
        );

        System.out.println(
            "Students created: " +
            studentCount
        );
    }
}


public class StudentCollegeManagement {

    public static void main(String[] args) {


        Student student1 =
                new Student(
                    "Anushka",
                    90
                );


        Student student2 =
                new Student(
                    "Ravi",
                    85
                );


        // Call using class name
        Student.printCollegeInfo();
    }
}