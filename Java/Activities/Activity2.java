
package Activities;
public class Activity2 {
    public static void main(String args[]){
        int numbers[]= {10, 77, 10, 54, -11, 10};
        int arrayLength = numbers.length;
        int sum =0;
        int expectedSum = 30;
        for(int i =0;i<arrayLength;i++) {
            if (numbers[i] == 10) {
                sum = sum + 10;
            }
        }

        if(sum==30){
            System.out.println("expected Sum of 10's in the array is 30:"  +  " actual sum of 10 in Array is: " + sum);
        }
        else {
            System.out.println("expected Sum of 10's in the array is 30:"  +  " actual sum of 10 in Array is: " + sum);
        }

    }


}


