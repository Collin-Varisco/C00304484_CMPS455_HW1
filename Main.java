/*
    Collin Varisco
    CMPS 455
    Dr. Kumar
    This code is my own.
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {


    public static int T; // Number of threads
    public static int S; // Number of times each thread should shout

    public static void inputMethod(boolean tValid){
        Scanner threadInput = new Scanner(System.in);
        boolean tV = false;
        if(!tValid){
            System.out.print("Enter the number of threads: ");
            try {
                int tempT = threadInput.nextInt();
                if(tempT > 0 && tempT <= 10000000) {
                    T = tempT;
                } else {
                    inputMethod(false);
                }
            } catch (Exception ex) {
                inputMethod(false);
            }
            tV = true;
        }
        if(tV || tValid) {
            System.out.print("How many times should each thread shout?: ");
            try {
                int tempS = threadInput.nextInt();
                if (tempS > 0 && tempS <= 100) {
                    S = tempS;
                } else {
                    inputMethod(true);
                }
            } catch (Exception ex) {
                inputMethod(true);
            }
        }
    }

    public static void main(String[] args) {
        inputMethod(false);

        Thread[] threads = new Thread[T];

        for (int i = 0; i < T; i++) {
            threads[i] = new Thread(new Shout(i));
        }
        ArrayList<Integer> threadIDs = new ArrayList<Integer>();
        int[] runCount = new int[T];
        for (int i = 0; i < T; i++) { runCount[i] = 0;}

        boolean finished = false;
        while(!finished){
            int randomId = new Random().nextInt(T);
            if(runCount[randomId] < S) {
                if (!threadIDs.contains(randomId)) {
                    threadIDs.add(randomId);
                    threads[randomId].start();
                    runCount[randomId]++;
                } else {
                    threads[randomId].run();
                    runCount[randomId]++;
                }
            }
            boolean allFinished = true;
            for(int c : runCount) {
                if (c != S) { allFinished = false; }
            }
            finished = allFinished;
        }
    }
}

