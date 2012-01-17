                                                                     
                                                                     
                                                                     
                                             
                                                                     
                                                                     
                                                                     
                                             
import java.util.Arrays;
import java.util.Scanner;


public class GameProblem {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int m, n;

        System.out.println("M");
        m = scanner.nextInt();
        System.out.println("N");
        n = scanner.nextInt();
        int arr[] = new int[m];
        System.out.println(findWinner(arr, n));
    }

    static int findWinner(int arr[], int n) {

        // this holds the cummulative index
        int k = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            // it holds the array index
            int index;
            // it holds the counter value for each iteration
            int j = 1;
            k = k < arr.length ? k + arr.length : k;
            while (true) {
                if (j == n) {
                    break;
                }

                index = k % arr.length;
                // If the position is already marked as out of the game then increment the cummulative counter and continue
                if (arr[index] == -1) {
                    k++;
                    continue;
                } else {
                    // If the position is not already marked as out of the game then increment the cummulative counter and also the counter for this iteration i.e. j
                    k++;
                    j++;
                }
            }
            index = k % arr.length;
            int m = index;
            // If the position is already marked find the next position to mark
            if (arr[index] == -1) {
                while (arr[m % arr.length] == -1) {
                    m++;
                    k++;
                }
            }
            index = k % arr.length;
            arr[index] = -1;
          //  System.out.println("Iteration " + i + "\n" + Arrays.toString(arr));
            // The next iteration the round should start from the next position of the marked position
            k++;
        }
// find the winning postion and return it
        int winningPostion = 0;
        for (; winningPostion < arr.length; winningPostion++) {
            if (arr[winningPostion] != -1) {
                winningPostion++;
                break;
            }
        }
        return winningPostion;
    }
}
