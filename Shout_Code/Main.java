/*
    Collin Varisco
    CMPS 455
    Dr. Kumar
    This code is my own.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static int T; // Number of threads
    public static int S; // Number of times each thread should shout

    /* getT()
     * Collects user input for how many threads should be created.
     * Minimum of 1 thread, maximum of 10000000 threads.
     * The value is stored in the global variable T.
     */
    public static void getT() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of threads: ");
        try {
            T = scan.nextInt();
            if(T < 1 || T > 10000000) {
                getT();
            }
        } catch (Exception ex) {
            getT();
        }
    }

    /* getS()
     * Collects user input for how many times each thread should shout.
     * The value is stored in the global variable S.
     */
    public static void getS() {
        Scanner scan = new Scanner(System.in);
        System.out.print("How many times should each thread shout?: ");
        try {
            S = scan.nextInt();
            if(S < 1 || S > 100) {
                getS();
            }
        } catch (Exception ex) {
            getS();
        }
    }



    public static void main(String[] args) {
        // Problem 1
        getT(); // User inputs the number of threads
        getS(); // User inputs the number of shouts per thread

        Thread[] threads = new Thread[T];
        for (int i = 0; i < T; i++) {
            threads[i] = new Thread(new Shout(i));
        }
        for(Thread t: threads) {
            t.start();
        }
    }
}

