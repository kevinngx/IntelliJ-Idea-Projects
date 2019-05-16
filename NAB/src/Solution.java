import java.util.Random;

// This question asked you to check how many times the all light bulbs shine (consecutive ones starting from the left)
// The below code works but its efficiency needs to be improved

class Solution {
    public static void main(String[] args) {
        int[] values = {2, 1, 3, 5, 4};
        int result = solution(values);
        System.out.println(result);
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        int allShineCounter = 0;

        // Set up light bulbs
        int[] lightBulbs = new int[A.length];
        for (int i = 0; i < lightBulbs.length; i++) {
            lightBulbs[i] = 0;
        }

        // Loop through A array
        for (int i = 0; i < A.length; i++) {
            lightBulbs[A[i]-1] = 1; // swithch light on
            if (checkAllOn(lightBulbs)) allShineCounter++;
        }

        return allShineCounter;
    }

    private static boolean checkAllOn(int[] lightBulbs) {
        int lastOnIndex = -1;

        // Find first index
        for (int i = 0; i < lightBulbs.length; i++) {
            if (lightBulbs[i] == 0) break;
            lastOnIndex++;
        }

        // Make sure all proceeding indexes are 0
        for (int i = lastOnIndex + 1; i < lightBulbs.length; i++) {
            if (lightBulbs[i] == 1) {
                return false;
            }
        }

        return true;
    }

//    public static void printList(int[] lightBulbs) {
//        //Printout
//        for (int i = 0; i < lightBulbs.length; i++) {
//            System.out.print(lightBulbs[i] + " ");
//        }
//        System.out.println("");
//    }
}