package Activities;

import java.util.HashMap;
public class Activity11 {
    public static void main(String[] args) {

        HashMap<Integer, String> colors = new HashMap<Integer, String>();
        colors.put(1, "Orange");
        colors.put(2, "Purple");
        colors.put(3, "Red");
        colors.put(4, "Pink");
        colors.put(5, "blue");
        System.out.println("Initial map: " + colors);
        colors.remove(4);
        System.out.println("After removing Pink: " + colors);
        if(colors.containsValue("Green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }
        System.out.println("Number of pairs in the Map is: " + colors.size());

    }
}
