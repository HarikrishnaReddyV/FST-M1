package Activities;

public class Activity4 {
    public static void main(String[] args) {

        //Initialize array
        int [] arr = new int [] {4,1, 6, 2, 5, 3};
        int temp = 0;

        //Displaying elements of original array
        System.out.println("Elements of original array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }

        //Sort the array in ascending order
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        //Displaying elements of array after sorting
        System.out.println('\n');
        System.out.println("Elements of array  in ascending order: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

