package codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SnakesLadders {

    private static final Map<Integer, Integer> SQUARES_MAPPING = new HashMap<>();

    static {
        SQUARES_MAPPING.put(2, 38);
        SQUARES_MAPPING.put(7, 14);
        SQUARES_MAPPING.put(8, 31);
        SQUARES_MAPPING.put(15, 26);
        SQUARES_MAPPING.put(21, 42);
        SQUARES_MAPPING.put(28, 84);
        SQUARES_MAPPING.put(36, 44);
        SQUARES_MAPPING.put(51, 67);
        SQUARES_MAPPING.put(71, 91);
        SQUARES_MAPPING.put(78, 98);
        SQUARES_MAPPING.put(87, 94);
        SQUARES_MAPPING.put(16, 6);
        SQUARES_MAPPING.put(46, 25);
        SQUARES_MAPPING.put(49, 11);
        SQUARES_MAPPING.put(62, 19);
        SQUARES_MAPPING.put(64, 60);
        SQUARES_MAPPING.put(74, 53);
        SQUARES_MAPPING.put(89, 68);
        SQUARES_MAPPING.put(92, 88);
        SQUARES_MAPPING.put(95, 75);
        SQUARES_MAPPING.put(99, 80);
    }

    abstract static class Player {
        int num;
        int currentSquare;

        Player(int num, int currentSquare) {
            this.num = num;
            this.currentSquare = currentSquare;
        }
    }

    static class Player1 extends Player {
        Player1() {
            super(1, 0);
        }
    }

    static class Player2 extends Player {
        Player2() {
            super(2, 0);
        }
    }

    static class PlayerFactory {
        Player createPlayer(int num) {
            if (num == 1) {
                return new Player1();
            }

            if (num == 2) {
                return new Player2();
            }

            return null;
        }
    }

    static final int LAST_SQUARE = 100;

    PlayerFactory playerFactory = new PlayerFactory();
    Player player1;
    Player player2;
    Player currentPlayer;

    public SnakesLadders() {
        this.player1 = playerFactory.createPlayer(1);
        this.player2 = playerFactory.createPlayer(2);
        this.currentPlayer = player1;
    }

    public String play(int die1, int die2) {
        var player = this.currentPlayer;
        if (player == null) {
            return "Game over!";
        }

        var nextSquare = player.currentSquare + die1 + die2;
        nextSquare = Optional.ofNullable(SQUARES_MAPPING.get(nextSquare)).orElse(nextSquare);
        if (nextSquare > LAST_SQUARE) {
            nextSquare = LAST_SQUARE - (nextSquare - LAST_SQUARE);
            nextSquare = Optional.ofNullable(SQUARES_MAPPING.get(nextSquare)).orElse(nextSquare);
        }

        if (nextSquare == LAST_SQUARE) {
            this.currentPlayer = null;
            return "Player %d Wins!".formatted(player.num);
        }

        player.currentSquare = nextSquare;

        if (die1 != die2) {
            if (this.currentPlayer == this.player1) {
                this.currentPlayer = this.player2;
            } else {
                this.currentPlayer = this.player1;
            }
        }

        return "Player %d is on square %d".formatted(player.num, player.currentSquare);
    }
}