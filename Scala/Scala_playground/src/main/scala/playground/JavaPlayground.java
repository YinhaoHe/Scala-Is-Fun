package playground;

/**
 * Created by yinhaohe on Feb 23, 2022
 */
public class JavaPlayground {


    public static void main(String[] args) {
        // we can access N_EYES in Class Person not instance Person
        // This is called class level functionality
        System.out.println(Person.N_EYES);
    }
}

class Person {
    public static final int N_EYES = 2; // Not able to modify

}
