package lotto;

import Game.GameController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();

        try {
            gameController.progressGame();
        } catch (IllegalArgumentException message) {
            System.out.println(message);
        }
    }
}
