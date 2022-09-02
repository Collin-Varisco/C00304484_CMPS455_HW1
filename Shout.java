import java.util.ArrayList;
import java.util.Random;

public class Shout implements Runnable {
    Thread t;
    private boolean exit;
    public int threadShoutTotal;

    Shout(int id) {
        t = new Thread(this, "Thread "+id+".) ");
        exit = false;
        t.start();
    }

    // 15 Randomly generated sentences stored in an array
    String[] sentences = {
            "They looked up at the sky and saw a million stars.",
            "Tomatoes make great weapons when water balloons aren’t available.",
            "Homesickness became contagious in the young campers' cabin.",
            "The fifty mannequin heads floating in the pool kind of freaked them out.",
            "He was the type of guy who liked Christmas lights on his house in the middle of July.",
            "She looked into the mirror and saw another person.",
            "In that instant, everything changed.",
            "It's a skateboarding penguin with a sunhat!",
            "The lake is a long way from here.",
            "He ended up burning his fingers poking someone else's fire.",
            "It's never been my responsibility to glaze the donuts.",
            "The tortoise jumped into the lake with dreams of becoming a sea turtle.",
            "8% of 25 is the same as 25% of 8 and one of them is much easier to do in your head.",
            "I am counting my calories, yet I really want dessert.",
            "The tour bus was packed with teenage girls heading toward their next adventure."
    };


    /* Run()
     * Shout random sentences for the specified amount of times given by the user.
     */
    @Override
    public void run() {
        while(!exit) {
            if (threadShoutTotal < (Main.S - 1)) {
                System.out.println(this.t.getName() + sentences[new Random().nextInt(15)]);
                threadShoutTotal++;
                int randInt = new Random().nextInt(3, 6);
                for (int i = 0; i < randInt; i++) {
                    Thread.yield();
                }
            } else {
                stop();
            }
        }
    }

    public void stop(){
        exit = true;
    }
}
