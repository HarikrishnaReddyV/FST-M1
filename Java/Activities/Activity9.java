package Activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

    public static void main(String args[]) {
        List<String> names = new ArrayList<String>();
        names.add("Hari");
        names.add("Krishna");
        names.add("Parthav");
        names.add("Ravi");
        names.add("Kiran");

        System.out.println("Array size is " + names.size());
        System.out.println("Name in 3rd index is " + names.get(3));
        for (String name : names) {
            System.out.println(name);
            }
        System.out.println("Is Hari is in list: " + names.contains("Hari"));
            names.remove("Ravi");
            System.out.println("Size of array on removing a name is " + names.size());

        //System.out.println(names.get[3]);

    }
}

