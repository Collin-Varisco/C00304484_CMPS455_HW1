import java.util.ArrayList;
import java.util.Random;

public class Shout implements Runnable {
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

    public int threadID;
    public int threadShoutTotal;
    public Shout(){ }

    public Shout(int threadNum){ threadID = threadNum; }

    @Override
    public void run() {
        if(threadShoutTotal == Main.S){
            Thread.currentThread().stop();
        } else {
            int randomIndex = 15;
            System.out.println("Thread " + this.threadID + ".) " + sentences[new Random().nextInt(randomIndex)]);
            threadShoutTotal++;

        }

    }
}
