import java.util.Random;

class Player {
    private int score;
    private final Random dice;

    public Player() { //constructor
        this.score = 0;
        this.dice = new Random();
    }

    public int getScore() { //gets current score
        return score;
    }

    public void rollDice() { //dicerolling method
        int roll = dice.nextInt(6) + 1;

        if (roll == 1) {
            score = 0;
        } else {
            score += roll;
        }
        
    }

    public boolean isFinished() { //finish argument
        return score >= 100;
    }

}

public class OneHundred {
    public static void main(String[] args) {
        Player a = new Player();
        Player b = new Player();

        int round = 1;
        //boolean finished = false;


        while (true) {
             System.out.println("Round " + round);
             
             a.rollDice(); // player A's turn
             System.out.println("Player A:" + a.getScore());

             if (a.isFinished()) {
                System.out.println("Player A has won.");
                //finished = true;
                break;
             }

             b.rollDice(); //player B's turn
             System.out.println("Player B:" + b.getScore());

             if (b.isFinished()) {
                System.out.println("Player B has won.");
                //finished = true;
                break;
             }

             System.out.println("-----------------");
             round++;

        }

    }

}