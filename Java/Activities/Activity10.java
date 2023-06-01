package Activities;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();

        set.add("M");
        set.add("B");
        set.add("C");
        set.add("A");
        set.add("M");
        set.add("X");

        System.out.println("Original HashSet: " + set);
        System.out.println("Size of HashSet: " + set.size());
        System.out.println("Removing A from HashSet: " + set.remove("A"));
        //Remove element that is not present
        if(set.contains("J")){
            System.out.println("Z removed from the Set");
        } else {
            System.out.println("Z is not present in the Set");
        }
        System.out.println("Checking if M is present: " + set.contains("M"));

        System.out.println("Updated HashSet: " + set);

    }

}