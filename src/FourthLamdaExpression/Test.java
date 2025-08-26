package FourthLamdaExpression;

public class Test {
    public static void main(String[] args) {
//        EngineeringDigest ed = new EngineeringDigest();
//        String ram = ed.getBio("Ram");
//        System.out.println(ram);
//        Instead of Doing This Do Directly

        Student student = new Student() {
            @Override
            public String getBio(String name) {
                return name + " is Engineering Student";
            }
        };
        String st = student.getBio("Ram");
        System.out.println(st);

        // Now with Lambda Expression
        Student newStudent = name -> {
            return st + " is Law Student ";
        };

        String rana = newStudent.getBio("Rana");
        System.out.println(rana);

        // make more small as one statement
        Student newStudent1 = name -> st + " is Law Student ";

        String rana1 = newStudent1.getBio("Rana");
        System.out.println(rana1);
    }
}
