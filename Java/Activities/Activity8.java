package Activities;

public class Activity8 {
    public static void main(String args[]) {
        try {

            Activity8.exceptionTest("Will print to console");
            Activity8.exceptionTest(null);
            Activity8.exceptionTest("Won't execute");
        } catch (CustomException mae) {
            System.out.println("Inside catch block: " + mae.getMessage());
        }

    }

    static void exceptionTest(String text) throws CustomException {
        if (text == null) {
            throw new CustomException("String is null");
        } else {
            System.out.println(text);
        }


    }
}
