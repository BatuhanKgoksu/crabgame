import java.util.Random;

public class DiceGame {
    private int currentPlayer;
    private int targetSum;
    private boolean isFirstTurn;

    public DiceGame() {
        currentPlayer = 1;
        targetSum = -1;  // -1 means no target sum set
        isFirstTurn = true;
    }

    public void playGame() {
        Player player1 = new Player();
        Player player2 = new Player();

        while (true) {
            System.out.println("Player " + currentPlayer + ", it's your turn.");
            int diceResult = rollDice();
            System.out.println("You rolled: " + diceResult);

            if (isFirstTurn) {
                if (diceResult == 6 || diceResult == 5 || diceResult == 3) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (diceResult == 4 || diceResult == 2 || diceResult == 1) {
                    System.out.println("Player " + currentPlayer + " loses!");
                    break;
                } else if (diceResult == 7) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else {
                    targetSum = diceResult;
                    isFirstTurn = false;
                }
            } else {
                if (diceResult == targetSum) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (diceResult == 7) {
                    System.out.println("Player " + currentPlayer + " loses!");
                    break;
                }
            }

            currentPlayer = (currentPlayer % 2) + 1; // Switch players
        }
    }

    private int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1 + rand.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        DiceGame game = new DiceGame();
        game.playGame();
    }
}

class Player {
    private int total;
    private boolean hasWon;

    public int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1 + rand.nextInt(6) + 1;
    }
}
