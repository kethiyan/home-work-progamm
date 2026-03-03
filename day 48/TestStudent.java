package builderpattern;

public class TestStudent
 {

    public static void main(String[] args) {

        Student student = new Student.Builder(101, "Kethiyan")
                .setEmail("kethiyan@gmail.com")
                .setPhone("9876543210")
                .setAddress("Tamil Nadu")
                .build();

        System.out.println(student);
    }
}